/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.opencb.biodata.models.variant.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Cosmic extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Cosmic\",\"namespace\":\"org.opencb.biodata.models.variant.avro\",\"fields\":[{\"name\":\"mutationID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"primarySite\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"siteSubtype\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"primaryHistology\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"histologySubtype\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"sampleSource\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"tumourOrigin\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"geneName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mutationSomaticStatus\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private java.lang.String mutationID;
   private java.lang.String primarySite;
   private java.lang.String siteSubtype;
   private java.lang.String primaryHistology;
   private java.lang.String histologySubtype;
   private java.lang.String sampleSource;
   private java.lang.String tumourOrigin;
   private java.lang.String geneName;
   private java.lang.String mutationSomaticStatus;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Cosmic() {}

  /**
   * All-args constructor.
   */
  public Cosmic(java.lang.String mutationID, java.lang.String primarySite, java.lang.String siteSubtype, java.lang.String primaryHistology, java.lang.String histologySubtype, java.lang.String sampleSource, java.lang.String tumourOrigin, java.lang.String geneName, java.lang.String mutationSomaticStatus) {
    this.mutationID = mutationID;
    this.primarySite = primarySite;
    this.siteSubtype = siteSubtype;
    this.primaryHistology = primaryHistology;
    this.histologySubtype = histologySubtype;
    this.sampleSource = sampleSource;
    this.tumourOrigin = tumourOrigin;
    this.geneName = geneName;
    this.mutationSomaticStatus = mutationSomaticStatus;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return mutationID;
    case 1: return primarySite;
    case 2: return siteSubtype;
    case 3: return primaryHistology;
    case 4: return histologySubtype;
    case 5: return sampleSource;
    case 6: return tumourOrigin;
    case 7: return geneName;
    case 8: return mutationSomaticStatus;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: mutationID = (java.lang.String)value$; break;
    case 1: primarySite = (java.lang.String)value$; break;
    case 2: siteSubtype = (java.lang.String)value$; break;
    case 3: primaryHistology = (java.lang.String)value$; break;
    case 4: histologySubtype = (java.lang.String)value$; break;
    case 5: sampleSource = (java.lang.String)value$; break;
    case 6: tumourOrigin = (java.lang.String)value$; break;
    case 7: geneName = (java.lang.String)value$; break;
    case 8: mutationSomaticStatus = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'mutationID' field.
   */
  public java.lang.String getMutationID() {
    return mutationID;
  }

  /**
   * Sets the value of the 'mutationID' field.
   * @param value the value to set.
   */
  public void setMutationID(java.lang.String value) {
    this.mutationID = value;
  }

  /**
   * Gets the value of the 'primarySite' field.
   */
  public java.lang.String getPrimarySite() {
    return primarySite;
  }

  /**
   * Sets the value of the 'primarySite' field.
   * @param value the value to set.
   */
  public void setPrimarySite(java.lang.String value) {
    this.primarySite = value;
  }

  /**
   * Gets the value of the 'siteSubtype' field.
   */
  public java.lang.String getSiteSubtype() {
    return siteSubtype;
  }

  /**
   * Sets the value of the 'siteSubtype' field.
   * @param value the value to set.
   */
  public void setSiteSubtype(java.lang.String value) {
    this.siteSubtype = value;
  }

  /**
   * Gets the value of the 'primaryHistology' field.
   */
  public java.lang.String getPrimaryHistology() {
    return primaryHistology;
  }

  /**
   * Sets the value of the 'primaryHistology' field.
   * @param value the value to set.
   */
  public void setPrimaryHistology(java.lang.String value) {
    this.primaryHistology = value;
  }

  /**
   * Gets the value of the 'histologySubtype' field.
   */
  public java.lang.String getHistologySubtype() {
    return histologySubtype;
  }

  /**
   * Sets the value of the 'histologySubtype' field.
   * @param value the value to set.
   */
  public void setHistologySubtype(java.lang.String value) {
    this.histologySubtype = value;
  }

  /**
   * Gets the value of the 'sampleSource' field.
   */
  public java.lang.String getSampleSource() {
    return sampleSource;
  }

  /**
   * Sets the value of the 'sampleSource' field.
   * @param value the value to set.
   */
  public void setSampleSource(java.lang.String value) {
    this.sampleSource = value;
  }

  /**
   * Gets the value of the 'tumourOrigin' field.
   */
  public java.lang.String getTumourOrigin() {
    return tumourOrigin;
  }

  /**
   * Sets the value of the 'tumourOrigin' field.
   * @param value the value to set.
   */
  public void setTumourOrigin(java.lang.String value) {
    this.tumourOrigin = value;
  }

  /**
   * Gets the value of the 'geneName' field.
   */
  public java.lang.String getGeneName() {
    return geneName;
  }

  /**
   * Sets the value of the 'geneName' field.
   * @param value the value to set.
   */
  public void setGeneName(java.lang.String value) {
    this.geneName = value;
  }

  /**
   * Gets the value of the 'mutationSomaticStatus' field.
   */
  public java.lang.String getMutationSomaticStatus() {
    return mutationSomaticStatus;
  }

  /**
   * Sets the value of the 'mutationSomaticStatus' field.
   * @param value the value to set.
   */
  public void setMutationSomaticStatus(java.lang.String value) {
    this.mutationSomaticStatus = value;
  }

  /** Creates a new Cosmic RecordBuilder */
  public static org.opencb.biodata.models.variant.avro.Cosmic.Builder newBuilder() {
    return new org.opencb.biodata.models.variant.avro.Cosmic.Builder();
  }
  
  /** Creates a new Cosmic RecordBuilder by copying an existing Builder */
  public static org.opencb.biodata.models.variant.avro.Cosmic.Builder newBuilder(org.opencb.biodata.models.variant.avro.Cosmic.Builder other) {
    return new org.opencb.biodata.models.variant.avro.Cosmic.Builder(other);
  }
  
  /** Creates a new Cosmic RecordBuilder by copying an existing Cosmic instance */
  public static org.opencb.biodata.models.variant.avro.Cosmic.Builder newBuilder(org.opencb.biodata.models.variant.avro.Cosmic other) {
    return new org.opencb.biodata.models.variant.avro.Cosmic.Builder(other);
  }
  
  /**
   * RecordBuilder for Cosmic instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Cosmic>
    implements org.apache.avro.data.RecordBuilder<Cosmic> {

    private java.lang.String mutationID;
    private java.lang.String primarySite;
    private java.lang.String siteSubtype;
    private java.lang.String primaryHistology;
    private java.lang.String histologySubtype;
    private java.lang.String sampleSource;
    private java.lang.String tumourOrigin;
    private java.lang.String geneName;
    private java.lang.String mutationSomaticStatus;

    /** Creates a new Builder */
    private Builder() {
      super(org.opencb.biodata.models.variant.avro.Cosmic.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.opencb.biodata.models.variant.avro.Cosmic.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.mutationID)) {
        this.mutationID = data().deepCopy(fields()[0].schema(), other.mutationID);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.primarySite)) {
        this.primarySite = data().deepCopy(fields()[1].schema(), other.primarySite);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.siteSubtype)) {
        this.siteSubtype = data().deepCopy(fields()[2].schema(), other.siteSubtype);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.primaryHistology)) {
        this.primaryHistology = data().deepCopy(fields()[3].schema(), other.primaryHistology);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.histologySubtype)) {
        this.histologySubtype = data().deepCopy(fields()[4].schema(), other.histologySubtype);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.sampleSource)) {
        this.sampleSource = data().deepCopy(fields()[5].schema(), other.sampleSource);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.tumourOrigin)) {
        this.tumourOrigin = data().deepCopy(fields()[6].schema(), other.tumourOrigin);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.geneName)) {
        this.geneName = data().deepCopy(fields()[7].schema(), other.geneName);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.mutationSomaticStatus)) {
        this.mutationSomaticStatus = data().deepCopy(fields()[8].schema(), other.mutationSomaticStatus);
        fieldSetFlags()[8] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Cosmic instance */
    private Builder(org.opencb.biodata.models.variant.avro.Cosmic other) {
            super(org.opencb.biodata.models.variant.avro.Cosmic.SCHEMA$);
      if (isValidValue(fields()[0], other.mutationID)) {
        this.mutationID = data().deepCopy(fields()[0].schema(), other.mutationID);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.primarySite)) {
        this.primarySite = data().deepCopy(fields()[1].schema(), other.primarySite);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.siteSubtype)) {
        this.siteSubtype = data().deepCopy(fields()[2].schema(), other.siteSubtype);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.primaryHistology)) {
        this.primaryHistology = data().deepCopy(fields()[3].schema(), other.primaryHistology);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.histologySubtype)) {
        this.histologySubtype = data().deepCopy(fields()[4].schema(), other.histologySubtype);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.sampleSource)) {
        this.sampleSource = data().deepCopy(fields()[5].schema(), other.sampleSource);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.tumourOrigin)) {
        this.tumourOrigin = data().deepCopy(fields()[6].schema(), other.tumourOrigin);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.geneName)) {
        this.geneName = data().deepCopy(fields()[7].schema(), other.geneName);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.mutationSomaticStatus)) {
        this.mutationSomaticStatus = data().deepCopy(fields()[8].schema(), other.mutationSomaticStatus);
        fieldSetFlags()[8] = true;
      }
    }

    /** Gets the value of the 'mutationID' field */
    public java.lang.String getMutationID() {
      return mutationID;
    }
    
    /** Sets the value of the 'mutationID' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder setMutationID(java.lang.String value) {
      validate(fields()[0], value);
      this.mutationID = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'mutationID' field has been set */
    public boolean hasMutationID() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'mutationID' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder clearMutationID() {
      mutationID = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'primarySite' field */
    public java.lang.String getPrimarySite() {
      return primarySite;
    }
    
    /** Sets the value of the 'primarySite' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder setPrimarySite(java.lang.String value) {
      validate(fields()[1], value);
      this.primarySite = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'primarySite' field has been set */
    public boolean hasPrimarySite() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'primarySite' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder clearPrimarySite() {
      primarySite = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'siteSubtype' field */
    public java.lang.String getSiteSubtype() {
      return siteSubtype;
    }
    
    /** Sets the value of the 'siteSubtype' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder setSiteSubtype(java.lang.String value) {
      validate(fields()[2], value);
      this.siteSubtype = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'siteSubtype' field has been set */
    public boolean hasSiteSubtype() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'siteSubtype' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder clearSiteSubtype() {
      siteSubtype = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'primaryHistology' field */
    public java.lang.String getPrimaryHistology() {
      return primaryHistology;
    }
    
    /** Sets the value of the 'primaryHistology' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder setPrimaryHistology(java.lang.String value) {
      validate(fields()[3], value);
      this.primaryHistology = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'primaryHistology' field has been set */
    public boolean hasPrimaryHistology() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'primaryHistology' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder clearPrimaryHistology() {
      primaryHistology = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'histologySubtype' field */
    public java.lang.String getHistologySubtype() {
      return histologySubtype;
    }
    
    /** Sets the value of the 'histologySubtype' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder setHistologySubtype(java.lang.String value) {
      validate(fields()[4], value);
      this.histologySubtype = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'histologySubtype' field has been set */
    public boolean hasHistologySubtype() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'histologySubtype' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder clearHistologySubtype() {
      histologySubtype = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'sampleSource' field */
    public java.lang.String getSampleSource() {
      return sampleSource;
    }
    
    /** Sets the value of the 'sampleSource' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder setSampleSource(java.lang.String value) {
      validate(fields()[5], value);
      this.sampleSource = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'sampleSource' field has been set */
    public boolean hasSampleSource() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'sampleSource' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder clearSampleSource() {
      sampleSource = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'tumourOrigin' field */
    public java.lang.String getTumourOrigin() {
      return tumourOrigin;
    }
    
    /** Sets the value of the 'tumourOrigin' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder setTumourOrigin(java.lang.String value) {
      validate(fields()[6], value);
      this.tumourOrigin = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'tumourOrigin' field has been set */
    public boolean hasTumourOrigin() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'tumourOrigin' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder clearTumourOrigin() {
      tumourOrigin = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'geneName' field */
    public java.lang.String getGeneName() {
      return geneName;
    }
    
    /** Sets the value of the 'geneName' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder setGeneName(java.lang.String value) {
      validate(fields()[7], value);
      this.geneName = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'geneName' field has been set */
    public boolean hasGeneName() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'geneName' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder clearGeneName() {
      geneName = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'mutationSomaticStatus' field */
    public java.lang.String getMutationSomaticStatus() {
      return mutationSomaticStatus;
    }
    
    /** Sets the value of the 'mutationSomaticStatus' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder setMutationSomaticStatus(java.lang.String value) {
      validate(fields()[8], value);
      this.mutationSomaticStatus = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'mutationSomaticStatus' field has been set */
    public boolean hasMutationSomaticStatus() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'mutationSomaticStatus' field */
    public org.opencb.biodata.models.variant.avro.Cosmic.Builder clearMutationSomaticStatus() {
      mutationSomaticStatus = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    public Cosmic build() {
      try {
        Cosmic record = new Cosmic();
        record.mutationID = fieldSetFlags()[0] ? this.mutationID : (java.lang.String) defaultValue(fields()[0]);
        record.primarySite = fieldSetFlags()[1] ? this.primarySite : (java.lang.String) defaultValue(fields()[1]);
        record.siteSubtype = fieldSetFlags()[2] ? this.siteSubtype : (java.lang.String) defaultValue(fields()[2]);
        record.primaryHistology = fieldSetFlags()[3] ? this.primaryHistology : (java.lang.String) defaultValue(fields()[3]);
        record.histologySubtype = fieldSetFlags()[4] ? this.histologySubtype : (java.lang.String) defaultValue(fields()[4]);
        record.sampleSource = fieldSetFlags()[5] ? this.sampleSource : (java.lang.String) defaultValue(fields()[5]);
        record.tumourOrigin = fieldSetFlags()[6] ? this.tumourOrigin : (java.lang.String) defaultValue(fields()[6]);
        record.geneName = fieldSetFlags()[7] ? this.geneName : (java.lang.String) defaultValue(fields()[7]);
        record.mutationSomaticStatus = fieldSetFlags()[8] ? this.mutationSomaticStatus : (java.lang.String) defaultValue(fields()[8]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
