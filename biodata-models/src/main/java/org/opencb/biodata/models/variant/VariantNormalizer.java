package org.opencb.biodata.models.variant;

import org.apache.commons.lang3.StringUtils;
import org.biojava.nbio.alignment.Alignments;
import org.biojava.nbio.alignment.SimpleGapPenalty;
import org.biojava.nbio.alignment.SubstitutionMatrixHelper;
import org.biojava.nbio.alignment.template.SequencePair;
import org.biojava.nbio.alignment.template.SubstitutionMatrix;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.compound.AmbiguityDNACompoundSet;
import org.biojava.nbio.core.sequence.compound.NucleotideCompound;
import org.opencb.biodata.models.feature.AllelesCode;
import org.opencb.biodata.models.feature.Genotype;
import org.opencb.biodata.models.variant.avro.AlternateCoordinate;
import org.opencb.biodata.models.variant.avro.FileEntry;
import org.opencb.biodata.models.variant.avro.VariantType;
import org.opencb.biodata.models.variant.exceptions.NonStandardCompliantSampleField;
import org.opencb.commons.run.ParallelTaskRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 06/10/15
 *
 * @author Jacobo Coll &lt;jacobo167@gmail.com&gt;
 */
public class VariantNormalizer implements ParallelTaskRunner.Task<Variant, Variant> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass().toString());

    private boolean reuseVariants = true;
    private boolean normalizeAlleles = false;
    private boolean decomposeMNVs = false;

    public VariantNormalizer() {}

    public VariantNormalizer(boolean reuseVariants) {
        this.reuseVariants = reuseVariants;
    }

    public VariantNormalizer(boolean reuseVariants, boolean normalizeAlleles) {
        this.reuseVariants = reuseVariants;
        this.normalizeAlleles = normalizeAlleles;
    }

    public VariantNormalizer(boolean reuseVariants, boolean normalizeAlleles, boolean decomposeMNVs) {
        this.reuseVariants = reuseVariants;
        this.normalizeAlleles = normalizeAlleles;
        this.decomposeMNVs = decomposeMNVs;
    }

    public boolean isReuseVariants() {
        return reuseVariants;
    }

    public VariantNormalizer setReuseVariants(boolean reuseVariants) {
        this.reuseVariants = reuseVariants;
        return this;
    }

    public boolean isNormalizeAlleles() {
        return normalizeAlleles;
    }

    public boolean isDecomposeMNVs() {
        return decomposeMNVs;
    }

    public VariantNormalizer setDecomposeMNVs(boolean decomposeMNVs) {
        this.decomposeMNVs = decomposeMNVs;
        return this;
    }

    public VariantNormalizer setNormalizeAlleles(boolean normalizeAlleles) {
        this.normalizeAlleles = normalizeAlleles;
        return this;
    }

    @Override
    public List<Variant> apply(List<Variant> batch) {
        try {
            return normalize(batch, reuseVariants);
        } catch (NonStandardCompliantSampleField e) {
            throw new RuntimeException(e);
        }
    }

    public List<Variant> normalize(List<Variant> batch, boolean reuse) throws NonStandardCompliantSampleField {
        List<Variant> normalizedVariants = new ArrayList<>(batch.size());

        for (Variant variant : batch) {
            if (!isNormalizable(variant)) {
                normalizedVariants.add(variant);
                continue;
            }

            String reference = variant.getReference();  //Save original values, as they can be changed
            String alternate = variant.getAlternate();
            Integer start = variant.getStart();
            String chromosome = variant.getChromosome();

            if (variant.getStudies() == null || variant.getStudies().isEmpty()) {
                List<VariantKeyFields> keyFieldsList = normalize(
                        chromosome, start, reference, Collections.singletonList(alternate));
                for (VariantKeyFields keyFields : keyFieldsList) {
                    String call = start + ":" + reference + ":" + alternate + ":" + keyFields.getNumAllele();
                    Variant normalizedVariant = newVariant(variant, keyFields);
                    if (keyFields.getPhaseSet() != null) {
                        StudyEntry studyEntry = new StudyEntry();
                        studyEntry.setSamplesData(
                                Collections.singletonList(Collections.singletonList(keyFields.getPhaseSet())));
                        studyEntry.setFormat(Collections.singletonList("PS"));
                        // Use mnv string as file Id so that it can be later identified. It is also used
                        // as the genotype call since we don't have an actual call and to avoid confusion
                        studyEntry.setFiles(Collections.singletonList(new FileEntry(keyFields.getPhaseSet(), call, null)));
                        normalizedVariant.setStudies(Collections.singletonList(studyEntry));
                    }
                    normalizedVariants.add(normalizedVariant);
                }
            } else {
                for (StudyEntry entry : variant.getStudies()) {
                    List<String> alternates = new ArrayList<>(1 + entry.getSecondaryAlternates().size());
                    alternates.add(alternate);
                    alternates.addAll(entry.getSecondaryAlternatesAlleles());

                    List<VariantKeyFields> keyFieldsList = normalize(chromosome, start, reference, alternates);
                    boolean sameVariant = keyFieldsList.size() == 1
                            && keyFieldsList.get(0).getStart() == start
                            && keyFieldsList.get(0).getReference().equals(reference)
                            && keyFieldsList.get(0).getAlternate().equals(alternate);
                    for (VariantKeyFields keyFields : keyFieldsList) {
                        String call = start + ":" + reference + ":" + String.join(",", alternates) + ":" + keyFields.getNumAllele();

                        final Variant normalizedVariant;
                        final StudyEntry normalizedEntry;
                        final List<List<String>> samplesData;
                        if (reuse && keyFieldsList.size() == 1) {   //Only reuse for non multiallelic variants
                            //Reuse variant. Set new fields.
                            normalizedVariant = variant;
                            variant.setStart(keyFields.getStart());
                            variant.setEnd(keyFields.getEnd());
                            variant.setReference(keyFields.getReference());
                            variant.setAlternate(keyFields.getAlternate());
                            normalizedEntry = entry;
                            entry.getFiles().forEach(fileEntry -> fileEntry.setCall(sameVariant ? "" : call)); //TODO: Check file attributes
                            samplesData = entry.getSamplesData();
                        } else {
                            normalizedVariant = newVariant(variant, keyFields);

                            normalizedEntry = new StudyEntry();
                            normalizedEntry.setStudyId(entry.getStudyId());
                            normalizedEntry.setSamplesPosition(entry.getSamplesPosition());
                            normalizedEntry.setFormat(entry.getFormat());

                            List<FileEntry> files = new ArrayList<>(entry.getFiles().size());
                            for (FileEntry file : entry.getFiles()) {
                                files.add(new FileEntry(file.getFileId(), sameVariant ? "" : call, file.getAttributes())); //TODO: Check file attributes
                            }
                            normalizedEntry.setFiles(files);
                            normalizedVariant.addStudyEntry(normalizedEntry);
                            samplesData = newSamplesData(entry.getSamplesData().size(), entry.getFormat().size());
                        }

                        //Set normalized secondary alternates
                        normalizedEntry.setSecondaryAlternates(getSecondaryAlternatesMap(chromosome, keyFields, keyFieldsList));

                        //Set normalized samples data
                        try {
                            List<String> format = entry.getFormat();
                            if (keyFields.getPhaseSet() != null) {
                                if (!normalizedEntry.getFormatPositions().containsKey("PS")) {
                                    normalizedEntry.addFormat("PS");
                                    format = new ArrayList<>(normalizedEntry.getFormat());
                                }
                                // If no files are provided one must be created to ensure genotype calls are the same
                                // for all mnv-phased variants
                                if (normalizedEntry.getFiles().size() == 0) {
                                    // Use mnv string as file Id so that it can be later identified.
                                    normalizedEntry.setFiles(Collections.singletonList(new FileEntry(keyFields.getPhaseSet(), call, null)));
                                }
                            }
                            List<List<String>> normalizedSamplesData = normalizeSamplesData(keyFields,
                                    entry.getSamplesData(), format, reference, alternates, samplesData);
                            normalizedEntry.setSamplesData(normalizedSamplesData);
                            normalizedVariants.add(normalizedVariant);

                        } catch (Exception e) {
                            logger.warn("Error parsing variant " + call + ", numAllele " + keyFields.getNumAllele(), e);
                            throw e;
                        }
                    }
                }
            }
        }

        return normalizedVariants;
    }

    public VariantKeyFields normalize(String chromosome, int position, String reference, String alternate) {
        return normalize(chromosome, position, reference, Collections.singletonList(alternate)).get(0);
    }

    public List<VariantKeyFields> normalize(String chromosome, int position, String reference, List<String> alternates) {
        List<VariantKeyFields> list = new ArrayList<>(alternates.size());
        int numAllelesIdx = 0; // This index is necessary for getting the samples where the mutated allele is present
        for (Iterator<String> iterator = alternates.iterator(); iterator.hasNext(); numAllelesIdx++) {
            String currentAlternate = iterator.next();
            VariantKeyFields keyFields;
            int referenceLen = reference.length();
            int alternateLen = currentAlternate.length();

            if (referenceLen == alternateLen) {
                keyFields = createVariantsFromSameLengthRefAlt(position, reference, currentAlternate);
            } else if (referenceLen == 0) {
                keyFields = createVariantsFromInsertionEmptyRef(position, currentAlternate);
            } else if (alternateLen == 0) {
                keyFields = createVariantsFromDeletionEmptyAlt(position, reference);
            } else {
                keyFields = createVariantsFromIndelNoEmptyRefAlt(position, reference, currentAlternate);
            }

            if (decomposeMNVs
                    && ((keyFields.getReference().length() > 1 && keyFields.getAlternate().length() > 1)
                       || ((
                              (keyFields.getReference().length() > 1 && keyFields.getAlternate().length() == 1) // To deal with cases such as A>GT
                           || (keyFields.getAlternate().length() > 1 && keyFields.getReference().length() == 1)
                            // After left and right trimming, first character of reference and alternate must be different.
                        ) /*&& keyFields.getReference().charAt(0) != keyFields.getAlternate().charAt(0)*/ ))) {
                for (VariantKeyFields keyFields1 : decomposeMNVSingleVariants(keyFields)) {
                    keyFields1.numAllele = numAllelesIdx;
                    keyFields1.phaseSet = chromosome + ":" + position + ":" + reference + ":" + currentAlternate;
                    list.add(keyFields1);
                }
            } else {
                keyFields.numAllele = numAllelesIdx;
                list.add(keyFields);
            }
        }
        return list;
    }

    private List<VariantKeyFields> decomposeMNVSingleVariants(VariantKeyFields keyFields) {
        SequencePair<DNASequence, NucleotideCompound> sequenceAlignment = getPairwiseAlignment(keyFields.getReference(),
                keyFields.getAlternate());
        return decomposeAlignmentSingleVariants(sequenceAlignment, keyFields.getStart());
    }

    private List<VariantKeyFields> decomposeAlignmentSingleVariants(SequencePair<DNASequence, NucleotideCompound> sequenceAlignment,
                                                                    int genomicStart) {

        String reference = sequenceAlignment.getTarget().getSequenceAsString();
        String alternate = sequenceAlignment.getQuery().getSequenceAsString();
        List<VariantKeyFields> keyFieldsList = new ArrayList<>();
        VariantKeyFields keyFields = null;
        char previousReferenceChar = 0;
        char previousAlternateChar = 0;
        // Assume that as a result of the alignment "reference" and "alternate" Strings are of the same length
        for (int i = 0; i < reference.length(); i++) {
            char referenceChar = reference.charAt(i);
            char alternateChar = alternate.charAt(i);
            // Insertion
            if (referenceChar == '-') {
                // Assume there cannot be a '-' at the reference and alternate aligned sequences at the same position
                if (alternateChar == '-') {
                    logger.error("Unhandled case found after pairwise alignment of MNVs. Alignment result: "
                            + reference + "/" + alternate);
                }
                // Current character is a continuation of an insertion
                if (previousReferenceChar == '-') {
                    keyFields.setAlternate(keyFields.getAlternate() + alternateChar);
                // New insertion found, create new keyFields
                } else {
                    keyFields = new VariantKeyFields(genomicStart + i, genomicStart + i, "",
                            String.valueOf(alternateChar));
                    keyFieldsList.add(keyFields);
                }
            // Deletion
            } else if (alternateChar == '-') {
                // Current character is a continuation of a deletion
                if (previousAlternateChar == '-') {
                    keyFields.setReference(keyFields.getReference() + referenceChar);
                    keyFields.setEnd(keyFields.getEnd()+1);
                // New deletion found, create new keyFields
                } else {
                    keyFields = new VariantKeyFields(genomicStart + i, genomicStart + i, String.valueOf(referenceChar),
                            "");
                    keyFieldsList.add(keyFields);
                }
            // SNV
            } else if (referenceChar != alternateChar) {
                keyFields = new VariantKeyFields(genomicStart + i, genomicStart + i, String.valueOf(referenceChar),
                        String.valueOf(alternateChar));
                keyFieldsList.add(keyFields);
            }
            previousReferenceChar = referenceChar;
            previousAlternateChar = alternateChar;
        }

        return keyFieldsList;
    }

    private SequencePair<DNASequence, NucleotideCompound> getPairwiseAlignment(String seq1, String seq2) {
        DNASequence target = null;
        DNASequence query = null;
        try {
            target = new DNASequence(seq1, AmbiguityDNACompoundSet.getDNACompoundSet());
            query = new DNASequence(seq2, AmbiguityDNACompoundSet.getDNACompoundSet());
        } catch (Exception e) {
            logger.error("Error when creating DNASequence objects for "+seq1+" and "+seq2+" prior to pairwise " +
                    "sequence alignment", e);
        }
        SubstitutionMatrix<NucleotideCompound> substitutionMatrix = SubstitutionMatrixHelper.getNuc4_4();
        SimpleGapPenalty gapP = new SimpleGapPenalty();
        gapP.setOpenPenalty((short)5);
        gapP.setExtensionPenalty((short)2);
        SequencePair<DNASequence, NucleotideCompound> psa = Alignments.getPairwiseAlignment(query, target,
                Alignments.PairwiseSequenceAlignerType.GLOBAL, gapP, substitutionMatrix);

        return psa;
    }

    /**
     * Non normalizable variants
     * TODO: Add {@link VariantType#SYMBOLIC} variants?
     */
    private boolean isNormalizable(Variant variant) {
        return !variant.getType().equals(VariantType.NO_VARIATION);
    }

    /**
     * Calculates the start, end, reference and alternate of a SNV/MNV where the
     * reference and the alternate are not empty.
     *
     * This task comprises 2 steps: removing the trailing bases that are
     * identical in both alleles, then the leading identical bases.
     *
     * @param position Input starting position
     * @param reference Input reference allele
     * @param alt Input alternate allele
     * @return The new start, end, reference and alternate alleles
     */
    protected VariantKeyFields createVariantsFromSameLengthRefAlt(int position, String reference, String alt) {
        int indexOfDifference;
        // Remove the trailing bases
        String refReversed = StringUtils.reverse(reference);
        String altReversed = StringUtils.reverse(alt);
        indexOfDifference = StringUtils.indexOfDifference(refReversed, altReversed);

        reference = StringUtils.reverse(refReversed.substring(indexOfDifference));
        alt = StringUtils.reverse(altReversed.substring(indexOfDifference));

        // Remove the leading bases
        indexOfDifference = StringUtils.indexOfDifference(reference, alt);
        if (indexOfDifference < 0) {
            return null;
        } else {
            int start = position + indexOfDifference;
            int end = position + reference.length() - 1;
            String ref = reference.substring(indexOfDifference);
            String inAlt = alt.substring(indexOfDifference);
            return new VariantKeyFields(start, end, ref, inAlt);
        }
    }

    protected VariantKeyFields createVariantsFromInsertionEmptyRef(int position, String alt) {
        return new VariantKeyFields(position, position + alt.length() - 1, "", alt);
    }

    protected VariantKeyFields createVariantsFromDeletionEmptyAlt(int position, String reference) {
        return new VariantKeyFields(position, position + reference.length() - 1, reference, "");
    }

    /**
     * Calculates the start, end, reference and alternate of an indel where the
     * reference and the alternate are not empty.
     *
     * This task comprises 2 steps: removing the trailing bases that are
     * identical in both alleles, then the leading identical bases.
     *
     * @param position Input starting position
     * @param reference Input reference allele
     * @param alt Input alternate allele
     * @return The new start, end, reference and alternate alleles
     */
    protected VariantKeyFields createVariantsFromIndelNoEmptyRefAlt(int position, String reference, String alt) {
        int indexOfDifference;
        // Remove the trailing bases
        String refReversed = StringUtils.reverse(reference);
        String altReversed = StringUtils.reverse(alt);
        indexOfDifference = StringUtils.indexOfDifference(refReversed, altReversed);

        reference = StringUtils.reverse(refReversed.substring(indexOfDifference));
        alt = StringUtils.reverse(altReversed.substring(indexOfDifference));

        // Remove the leading bases
        indexOfDifference = StringUtils.indexOfDifference(reference, alt);
        if (indexOfDifference < 0) {
            return null;
        } else if (indexOfDifference == 0) {
            if (reference.length() > alt.length()) { // Deletion
                return new VariantKeyFields(position, position + reference.length() - 1, reference, alt);
            } else { // Insertion
                return new VariantKeyFields(position, position + alt.length() - 1, reference, alt);
            }
        } else {
            if (reference.length() > alt.length()) { // Deletion
                int start = position + indexOfDifference;
                int end = position + reference.length() - 1;
                String ref = reference.substring(indexOfDifference);
                String inAlt = alt.substring(indexOfDifference);
                return new VariantKeyFields(start, end, ref, inAlt);
            } else { // Insertion
                int start = position + indexOfDifference;
                int end = position + alt.length() - 1;
                String ref = reference.substring(indexOfDifference);
                String inAlt = alt.substring(indexOfDifference);
                return new VariantKeyFields(start, end, ref, inAlt);
            }
        }
    }

    public List<List<String>> normalizeSamplesData(VariantKeyFields variantKeyFields, final List<List<String>> samplesData, List<String> format,
                                                   String reference, List<String> alternateAlleles) throws NonStandardCompliantSampleField {
        return normalizeSamplesData(variantKeyFields, samplesData, format, reference, alternateAlleles, null);
    }

    public List<List<String>> normalizeSamplesData(VariantKeyFields variantKeyFields, final List<List<String>> samplesData, List<String> format,
                                                   String reference, List<String> alternateAlleles, List<List<String>> reuseSampleData)
            throws NonStandardCompliantSampleField {

        List<List<String>> newSampleData;
        if (reuseSampleData == null) {
            newSampleData = newSamplesData(samplesData.size(), format.size());
        } else {
            newSampleData = reuseSampleData;
        }

        Genotype genotype = null;
        String[] secondaryAlternatesMap = new String[1 + alternateAlleles.size()];  //reference + alternates
        int secondaryReferencesIdx = 2;
        int alleleIdx = 1;
        secondaryAlternatesMap[0] = "0";     // Set the reference id
        for (String alternateAllele : alternateAlleles) {
            if (variantKeyFields.getNumAllele() == alleleIdx - 1) {
                secondaryAlternatesMap[alleleIdx] = "1";    //The first alternate
            } else {    //Secondary alternates will start at position 2, and increase sequentially
                secondaryAlternatesMap[alleleIdx] = Integer.toString(secondaryReferencesIdx);
                secondaryReferencesIdx++;
            }
            alleleIdx++;
        }

        // Normalizing an mnv and no sample data was provided in the original variant - need to create sample data to
        // indicate the phase set
        if (variantKeyFields.getPhaseSet() != null && samplesData.size() == 0) {
            if (format.equals(Collections.singletonList("PS"))) {
                newSampleData.add(Collections.singletonList(variantKeyFields.getPhaseSet()));
            } else {
                List<String> sampleData = new ArrayList<>(format.size());
                for (String f : format) {
                    if (f.equals("PS")) {
                        sampleData.add(variantKeyFields.getPhaseSet());
                    } else {
                        sampleData.add("");
                    }
                }
                newSampleData.add(sampleData);
            }
        } else {
            for (int sampleIdx = 0; sampleIdx < samplesData.size(); sampleIdx++) {
                List<String> sampleData = samplesData.get(sampleIdx);

                // TODO we could check that format and sampleData sizes are equals
                //            if (sampleData.size() == 1 && sampleData.get(0).equals(".")) {
                //                newSampleData.get(sampleIdx).set(0, "./.");
                //                System.out.println("Format data equals '.'");
                //                continue;
                //            }

                for (int formatFieldIdx = 0; formatFieldIdx < format.size(); formatFieldIdx++) {
                    String formatField = format.get(formatFieldIdx);
                    // It may happen that the Format contains other fields that were not in the original format,
                    // or that some sampleData array is smaller than the format list.
                    // If the variant was a splitted MNV, a new field 'PS' is added to the format (if missing), so it may
                    // not be in the original sampleData.
                    String sampleField = sampleData.size() > formatFieldIdx ? sampleData.get(formatFieldIdx) : "";

                    if (formatField.equalsIgnoreCase("GT")) {
                        // Save alleles just in case they are necessary for GL/PL/GP transformation
                        // Use the original alternates to create the genotype.
                        genotype = new Genotype(sampleField, reference, alternateAlleles);

                        StringBuilder genotypeStr = new StringBuilder();

                        int[] allelesIdx;
                        if (normalizeAlleles && !genotype.isPhased()) {
                            allelesIdx = genotype.getNormalizedAllelesIdx();
                        } else {
                            allelesIdx = genotype.getAllelesIdx();
                        }
                        for (int i = 0; i < allelesIdx.length; i++) {
                            int allele = allelesIdx[i];
                            if (allele < 0) { // Missing
                                genotypeStr.append(".");
                            } else {
                                // Replace numerical indexes when they refer to another alternate allele
                                genotypeStr.append(secondaryAlternatesMap[allele]);
                            }
                            if (i < allelesIdx.length - 1) {
                                genotypeStr.append(genotype.isPhased() ? "|" : "/");
                            }
                        }
                        sampleField = genotypeStr.toString();

                    } else if (formatField.equalsIgnoreCase("GL")
                            || formatField.equalsIgnoreCase("PL")
                            || formatField.equalsIgnoreCase("GP")) {
                        // All-alleles present and not haploid
                        if (!sampleField.equals(".") && genotype != null
                                && (genotype.getCode() == AllelesCode.ALLELES_OK
                                || genotype.getCode() == AllelesCode.MULTIPLE_ALTERNATES)) {
                            String[] likelihoods = sampleField.split(",");

                            // If only 3 likelihoods are represented, no transformation is needed
                            if (likelihoods.length > 3) {
                                // Get alleles index to work with: if both are the same alternate,
                                // the combinations must be run with the reference allele.
                                // Otherwise all GL reported would be alt/alt.
                                int allele1 = genotype.getAllele(0);
                                int allele2 = genotype.getAllele(1);
                                if (genotype.getAllele(0) == genotype.getAllele(1) && genotype.getAllele(0) > 0) {
                                    allele1 = 0;
                                }

                                // If the number of values is not enough for this GT
                                int maxAllele = allele1 >= allele2 ? allele1 : allele2;
                                int numValues = (int) (((float) maxAllele * (maxAllele + 1)) / 2) + maxAllele;
                                if (likelihoods.length < numValues) {
                                    throw new NonStandardCompliantSampleField(formatField, sampleField, String.format("It must contain %d values", numValues));
                                }

                                // Genotype likelihood must be distributed following similar criteria as genotypes
                                String[] alleleLikelihoods = new String[3];
                                alleleLikelihoods[0] = likelihoods[(int) (((float) allele1 * (allele1 + 1)) / 2) + allele1];
                                alleleLikelihoods[1] = likelihoods[(int) (((float) allele2 * (allele2 + 1)) / 2) + allele1];
                                alleleLikelihoods[2] = likelihoods[(int) (((float) allele2 * (allele2 + 1)) / 2) + allele2];
                                sampleField = String.join(",", alleleLikelihoods);
                            }
                        }
                    } else if (formatField.equals("PS")) {
                        if (variantKeyFields.getPhaseSet() != null) {
                            sampleField = variantKeyFields.getPhaseSet();
                        }
                    }
                    List<String> data = newSampleData.get(sampleIdx);
                    if (data.size() > formatFieldIdx) {
                        data.set(formatFieldIdx, sampleField);
                    } else {
                        try {
                            data.add(sampleField);
                        } catch (UnsupportedOperationException e ) {
                            data = new ArrayList<>(data);
                            data.add(sampleField);
                            newSampleData.set(sampleIdx, data);
                        }
                    }
                }
            }
        }
        return newSampleData;
    }


    private Variant newVariant(Variant variant, VariantKeyFields keyFields) {
        Variant normalizedVariant = new Variant(variant.getChromosome(), keyFields.getStart(), keyFields.getEnd(), keyFields.getReference(), keyFields.getAlternate());
        normalizedVariant.setIds(variant.getIds());
        normalizedVariant.setStrand(variant.getStrand());
        normalizedVariant.setAnnotation(variant.getAnnotation());
        return normalizedVariant;
    }

    public List<AlternateCoordinate> getSecondaryAlternatesMap(String chromosome, VariantKeyFields alternate, List<VariantKeyFields> alternates) {
        List<AlternateCoordinate> secondaryAlternates;
        if (alternates.size() == 1) {
            secondaryAlternates = Collections.emptyList();
        } else if (alternate.getPhaseSet() != null) {
            for (VariantKeyFields variantKeyFields : alternates) {
                if (variantKeyFields.getNumAllele() > 0) {
                    throw new IllegalStateException("Unable to resolve multiallelic with MNV variants -> "
                            + alternates.stream()
                            .map((v) -> chromosome + ":" + v.toString())
                            .collect(Collectors.joining(" , ")));
                }
            }
            secondaryAlternates = Collections.emptyList();
        } else {

            secondaryAlternates = new ArrayList<>(alternates.size() - 1);
            for (VariantKeyFields keyFields : alternates) {
                if (!keyFields.equals(alternate)) {
                    secondaryAlternates.add(new AlternateCoordinate(
                            // Chromosome is always the same, do not set
                            null,
                            //Set position only if is different from the original one
                            alternate.getStart() == keyFields.getStart() ? null : keyFields.getStart(),
                            alternate.getEnd() == keyFields.getEnd() ? null : keyFields.getEnd(),
                            //Set reference only if is different from the original one
                            alternate.getReference().equals(keyFields.getReference()) ? null : keyFields.getReference(),
                            keyFields.getAlternate(),
                            Variant.inferType(keyFields.getReference(), keyFields.getAlternate(), keyFields.getEnd() - keyFields.getStart() + 1)
                    ));
                }
            }
        }
        return secondaryAlternates;
    }

    private List<List<String>> newSamplesData(int samplesSize, int formatSize) {
        List<List<String>> newSampleData;
        newSampleData = new ArrayList<>(samplesSize);
        for (int i = 0; i < samplesSize; i++) {
            newSampleData.add(Arrays.asList(new String[formatSize]));
        }
        return newSampleData;
    }


    public static class VariantKeyFields {

        private int start;
        private int end;
        private int numAllele;
        private String phaseSet;
        private String reference;
        private String alternate;

        public VariantKeyFields(int start, int end, int numAllele, String reference, String alternate) {
            this.start = start;
            this.end = end;
            this.numAllele = numAllele;
            this.reference = reference;
            this.alternate = alternate;
        }

        public VariantKeyFields(int start, int end, String reference, String alternate) {
            this.start = start;
            this.end = end;
            this.reference = reference;
            this.alternate = alternate;
        }

        public int getStart() {
            return start;
        }

        public VariantKeyFields setStart(int start) {
            this.start = start;
            return this;
        }

        public int getEnd() {
            return end;
        }

        public VariantKeyFields setEnd(int end) {
            this.end = end;
            return this;
        }

        public int getNumAllele() {
            return numAllele;
        }

        public VariantKeyFields setNumAllele(int numAllele) {
            this.numAllele = numAllele;
            return this;
        }

        public String getPhaseSet() { return phaseSet; }

        public VariantKeyFields setPhaseSet(String phaseSet) {
            this.phaseSet = phaseSet;
            return this;
        }

        public String getReference() {
            return reference;
        }

        public VariantKeyFields setReference(String reference) {
            this.reference = reference;
            return this;
        }

        public String getAlternate() {
            return alternate;
        }

        public VariantKeyFields setAlternate(String alternate) {
            this.alternate = alternate;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof VariantKeyFields)) return false;

            VariantKeyFields that = (VariantKeyFields) o;

            if (start != that.start) return false;
            if (end != that.end) return false;
            if (numAllele != that.numAllele) return false;
            if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
            return !(alternate != null ? !alternate.equals(that.alternate) : that.alternate != null);

        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            result = 31 * result + numAllele;
            result = 31 * result + (reference != null ? reference.hashCode() : 0);
            result = 31 * result + (alternate != null ? alternate.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return start + ":" + reference + ":" + alternate + ":" + numAllele + (phaseSet == null ? "" : ("(ps:" + phaseSet + ")"));
        }


    }

}