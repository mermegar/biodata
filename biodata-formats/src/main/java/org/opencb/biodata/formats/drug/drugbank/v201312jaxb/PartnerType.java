/*
 * Copyright 2015 OpenCB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.18 at 04:12:32 PM CET 
//


package org.opencb.biodata.formats.drug.drugbank.v201312jaxb;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for PartnerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartnerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="general-function" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="specific-function" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gene-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="locus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reaction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="signals" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cellular-location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transmembrane-regions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="theoretical-pi" type="{http://drugbank.ca}DecimalOrEmptyType"/>
 *         &lt;element name="molecular-weight" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chromosome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://drugbank.ca}species"/>
 *         &lt;element ref="{http://drugbank.ca}essentiality"/>
 *         &lt;element name="references" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="external-identifiers" type="{http://drugbank.ca}IdentifiersType"/>
 *         &lt;element name="synonyms" type="{http://drugbank.ca}SynonymsType"/>
 *         &lt;element name="protein-sequence" type="{http://drugbank.ca}SequenceType" minOccurs="0"/>
 *         &lt;element name="gene-sequence" type="{http://drugbank.ca}SequenceType" minOccurs="0"/>
 *         &lt;element ref="{http://drugbank.ca}pfams"/>
 *         &lt;element ref="{http://drugbank.ca}go-classifiers"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartnerType", propOrder = {
    "name",
    "generalFunction",
    "specificFunction",
    "geneName",
    "locus",
    "reaction",
    "signals",
    "cellularLocation",
    "transmembraneRegions",
    "theoreticalPi",
    "molecularWeight",
    "chromosome",
    "species",
    "essentiality",
    "references",
    "externalIdentifiers",
    "synonyms",
    "proteinSequence",
    "geneSequence",
    "pfams",
    "goClassifiers"
})
public class PartnerType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "general-function", required = true)
    protected String generalFunction;
    @XmlElement(name = "specific-function", required = true)
    protected String specificFunction;
    @XmlElement(name = "gene-name", required = true)
    protected String geneName;
    @XmlElement(required = true)
    protected String locus;
    @XmlElement(required = true)
    protected String reaction;
    @XmlElement(required = true)
    protected String signals;
    @XmlElement(name = "cellular-location", required = true)
    protected String cellularLocation;
    @XmlElement(name = "transmembrane-regions", required = true)
    protected String transmembraneRegions;
    @XmlElement(name = "theoretical-pi", required = true)
    protected String theoreticalPi;
    @XmlElement(name = "molecular-weight", required = true)
    protected String molecularWeight;
    @XmlElement(required = true)
    protected String chromosome;
    @XmlElement(required = true)
    protected Species species;
    @XmlElement(required = true)
    protected String essentiality;
    @XmlElement(required = true)
    protected String references;
    @XmlElement(name = "external-identifiers", required = true)
    protected IdentifiersType externalIdentifiers;
    @XmlElement(required = true)
    protected SynonymsType synonyms;
    @XmlElement(name = "protein-sequence")
    protected SequenceType proteinSequence;
    @XmlElement(name = "gene-sequence")
    protected SequenceType geneSequence;
    @XmlElement(required = true)
    protected Pfams pfams;
    @XmlElement(name = "go-classifiers", required = true)
    protected GoClassifiers goClassifiers;
    @XmlAttribute(name = "id", required = true)
    protected BigInteger id;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the generalFunction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneralFunction() {
        return generalFunction;
    }

    /**
     * Sets the value of the generalFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneralFunction(String value) {
        this.generalFunction = value;
    }

    /**
     * Gets the value of the specificFunction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificFunction() {
        return specificFunction;
    }

    /**
     * Sets the value of the specificFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificFunction(String value) {
        this.specificFunction = value;
    }

    /**
     * Gets the value of the geneName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneName() {
        return geneName;
    }

    /**
     * Sets the value of the geneName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneName(String value) {
        this.geneName = value;
    }

    /**
     * Gets the value of the locus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocus() {
        return locus;
    }

    /**
     * Sets the value of the locus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocus(String value) {
        this.locus = value;
    }

    /**
     * Gets the value of the reaction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReaction() {
        return reaction;
    }

    /**
     * Sets the value of the reaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReaction(String value) {
        this.reaction = value;
    }

    /**
     * Gets the value of the signals property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignals() {
        return signals;
    }

    /**
     * Sets the value of the signals property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignals(String value) {
        this.signals = value;
    }

    /**
     * Gets the value of the cellularLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellularLocation() {
        return cellularLocation;
    }

    /**
     * Sets the value of the cellularLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellularLocation(String value) {
        this.cellularLocation = value;
    }

    /**
     * Gets the value of the transmembraneRegions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransmembraneRegions() {
        return transmembraneRegions;
    }

    /**
     * Sets the value of the transmembraneRegions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransmembraneRegions(String value) {
        this.transmembraneRegions = value;
    }

    /**
     * Gets the value of the theoreticalPi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheoreticalPi() {
        return theoreticalPi;
    }

    /**
     * Sets the value of the theoreticalPi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheoreticalPi(String value) {
        this.theoreticalPi = value;
    }

    /**
     * Gets the value of the molecularWeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMolecularWeight() {
        return molecularWeight;
    }

    /**
     * Sets the value of the molecularWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMolecularWeight(String value) {
        this.molecularWeight = value;
    }

    /**
     * Gets the value of the chromosome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChromosome() {
        return chromosome;
    }

    /**
     * Sets the value of the chromosome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChromosome(String value) {
        this.chromosome = value;
    }

    /**
     * Gets the value of the species property.
     * 
     * @return
     *     possible object is
     *     {@link Species }
     *     
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * Sets the value of the species property.
     * 
     * @param value
     *     allowed object is
     *     {@link Species }
     *     
     */
    public void setSpecies(Species value) {
        this.species = value;
    }

    /**
     * Gets the value of the essentiality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEssentiality() {
        return essentiality;
    }

    /**
     * Sets the value of the essentiality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEssentiality(String value) {
        this.essentiality = value;
    }

    /**
     * Gets the value of the references property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferences() {
        return references;
    }

    /**
     * Sets the value of the references property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferences(String value) {
        this.references = value;
    }

    /**
     * Gets the value of the externalIdentifiers property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifiersType }
     *     
     */
    public IdentifiersType getExternalIdentifiers() {
        return externalIdentifiers;
    }

    /**
     * Sets the value of the externalIdentifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifiersType }
     *     
     */
    public void setExternalIdentifiers(IdentifiersType value) {
        this.externalIdentifiers = value;
    }

    /**
     * Gets the value of the synonyms property.
     * 
     * @return
     *     possible object is
     *     {@link SynonymsType }
     *     
     */
    public SynonymsType getSynonyms() {
        return synonyms;
    }

    /**
     * Sets the value of the synonyms property.
     * 
     * @param value
     *     allowed object is
     *     {@link SynonymsType }
     *     
     */
    public void setSynonyms(SynonymsType value) {
        this.synonyms = value;
    }

    /**
     * Gets the value of the proteinSequence property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceType }
     *     
     */
    public SequenceType getProteinSequence() {
        return proteinSequence;
    }

    /**
     * Sets the value of the proteinSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceType }
     *     
     */
    public void setProteinSequence(SequenceType value) {
        this.proteinSequence = value;
    }

    /**
     * Gets the value of the geneSequence property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceType }
     *     
     */
    public SequenceType getGeneSequence() {
        return geneSequence;
    }

    /**
     * Sets the value of the geneSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceType }
     *     
     */
    public void setGeneSequence(SequenceType value) {
        this.geneSequence = value;
    }

    /**
     * Gets the value of the pfams property.
     * 
     * @return
     *     possible object is
     *     {@link Pfams }
     *     
     */
    public Pfams getPfams() {
        return pfams;
    }

    /**
     * Sets the value of the pfams property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pfams }
     *     
     */
    public void setPfams(Pfams value) {
        this.pfams = value;
    }

    /**
     * Gets the value of the goClassifiers property.
     * 
     * @return
     *     possible object is
     *     {@link GoClassifiers }
     *     
     */
    public GoClassifiers getGoClassifiers() {
        return goClassifiers;
    }

    /**
     * Sets the value of the goClassifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link GoClassifiers }
     *     
     */
    public void setGoClassifiers(GoClassifiers value) {
        this.goClassifiers = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

}
