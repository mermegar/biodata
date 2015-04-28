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
// Generated on: 2014.09.26 at 06:05:35 PM CEST 
//


package org.opencb.biodata.formats.variant.clinvar.v19jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for SampleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SampleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SampleDescription" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Description" type="{}CommentType" minOccurs="0"/>
 *                   &lt;element name="Citation" type="{}CitationType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Origin">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="germline"/>
 *               &lt;enumeration value="somatic"/>
 *               &lt;enumeration value="de novo"/>
 *               &lt;enumeration value="uncertain"/>
 *               &lt;enumeration value="unknown"/>
 *               &lt;enumeration value="not provided"/>
 *               &lt;enumeration value="inherited"/>
 *               &lt;enumeration value="maternal"/>
 *               &lt;enumeration value="paternal"/>
 *               &lt;enumeration value="uniparental"/>
 *               &lt;enumeration value="biparental"/>
 *               &lt;enumeration value="not-reported"/>
 *               &lt;enumeration value="tested-inconclusive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Ethnicity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GeographicOrigin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tissue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CellLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Species" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="TaxonomyId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Age" maxOccurs="2" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
 *                 &lt;attribute name="age_unit" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="days"/>
 *                       &lt;enumeration value="months"/>
 *                       &lt;enumeration value="years"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="Type" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="minimum"/>
 *                       &lt;enumeration value="maximum"/>
 *                       &lt;enumeration value="single"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Strain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AffectedStatus">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="yes"/>
 *               &lt;enumeration value="no"/>
 *               &lt;enumeration value="not provided"/>
 *               &lt;enumeration value="unknown"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NumberTested" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NumberMales" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NumberFemales" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NumberChrTested" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Gender" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="male"/>
 *               &lt;enumeration value="female"/>
 *               &lt;enumeration value="mixed"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FamilyData" type="{}FamilyInfo" minOccurs="0"/>
 *         &lt;element name="Proband" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Citation" type="{}CitationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="XRef" type="{}XrefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Comment" type="{}CommentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SourceType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="submitter-generated"/>
 *               &lt;enumeration value="data mining"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SampleType", propOrder = {
    "sampleDescription",
    "origin",
    "ethnicity",
    "geographicOrigin",
    "tissue",
    "cellLine",
    "species",
    "age",
    "strain",
    "affectedStatus",
    "numberTested",
    "numberMales",
    "numberFemales",
    "numberChrTested",
    "gender",
    "familyData",
    "proband",
    "citation",
    "xRef",
    "comment",
    "sourceType"
})
public class SampleType {

    @XmlElement(name = "SampleDescription")
    protected SampleType.SampleDescription sampleDescription;
    @XmlElement(name = "Origin", required = true)
    protected String origin;
    @XmlElement(name = "Ethnicity")
    protected String ethnicity;
    @XmlElement(name = "GeographicOrigin")
    protected String geographicOrigin;
    @XmlElement(name = "Tissue")
    protected String tissue;
    @XmlElement(name = "CellLine")
    protected String cellLine;
    @XmlElement(name = "Species")
    protected SampleType.Species species;
    @XmlElement(name = "Age")
    protected List<SampleType.Age> age;
    @XmlElement(name = "Strain")
    protected String strain;
    @XmlElement(name = "AffectedStatus", required = true)
    protected String affectedStatus;
    @XmlElement(name = "NumberTested")
    protected Integer numberTested;
    @XmlElement(name = "NumberMales")
    protected Integer numberMales;
    @XmlElement(name = "NumberFemales")
    protected Integer numberFemales;
    @XmlElement(name = "NumberChrTested")
    protected Integer numberChrTested;
    @XmlElement(name = "Gender")
    protected String gender;
    @XmlElement(name = "FamilyData")
    protected FamilyInfo familyData;
    @XmlElement(name = "Proband")
    protected String proband;
    @XmlElement(name = "Citation")
    protected List<CitationType> citation;
    @XmlElement(name = "XRef")
    protected List<XrefType> xRef;
    @XmlElement(name = "Comment")
    protected List<CommentType> comment;
    @XmlElement(name = "SourceType")
    protected String sourceType;

    /**
     * Gets the value of the sampleDescription property.
     * 
     * @return
     *     possible object is
     *     {@link SampleType.SampleDescription }
     *     
     */
    public SampleType.SampleDescription getSampleDescription() {
        return sampleDescription;
    }

    /**
     * Sets the value of the sampleDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link SampleType.SampleDescription }
     *     
     */
    public void setSampleDescription(SampleType.SampleDescription value) {
        this.sampleDescription = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * Gets the value of the ethnicity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEthnicity() {
        return ethnicity;
    }

    /**
     * Sets the value of the ethnicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEthnicity(String value) {
        this.ethnicity = value;
    }

    /**
     * Gets the value of the geographicOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeographicOrigin() {
        return geographicOrigin;
    }

    /**
     * Sets the value of the geographicOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeographicOrigin(String value) {
        this.geographicOrigin = value;
    }

    /**
     * Gets the value of the tissue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTissue() {
        return tissue;
    }

    /**
     * Sets the value of the tissue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTissue(String value) {
        this.tissue = value;
    }

    /**
     * Gets the value of the cellLine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellLine() {
        return cellLine;
    }

    /**
     * Sets the value of the cellLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellLine(String value) {
        this.cellLine = value;
    }

    /**
     * Gets the value of the species property.
     * 
     * @return
     *     possible object is
     *     {@link SampleType.Species }
     *     
     */
    public SampleType.Species getSpecies() {
        return species;
    }

    /**
     * Sets the value of the species property.
     * 
     * @param value
     *     allowed object is
     *     {@link SampleType.Species }
     *     
     */
    public void setSpecies(SampleType.Species value) {
        this.species = value;
    }

    /**
     * Gets the value of the age property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the age property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SampleType.Age }
     * 
     * 
     */
    public List<SampleType.Age> getAge() {
        if (age == null) {
            age = new ArrayList<SampleType.Age>();
        }
        return this.age;
    }

    /**
     * Gets the value of the strain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrain() {
        return strain;
    }

    /**
     * Sets the value of the strain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrain(String value) {
        this.strain = value;
    }

    /**
     * Gets the value of the affectedStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAffectedStatus() {
        return affectedStatus;
    }

    /**
     * Sets the value of the affectedStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAffectedStatus(String value) {
        this.affectedStatus = value;
    }

    /**
     * Gets the value of the numberTested property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberTested() {
        return numberTested;
    }

    /**
     * Sets the value of the numberTested property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberTested(Integer value) {
        this.numberTested = value;
    }

    /**
     * Gets the value of the numberMales property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberMales() {
        return numberMales;
    }

    /**
     * Sets the value of the numberMales property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberMales(Integer value) {
        this.numberMales = value;
    }

    /**
     * Gets the value of the numberFemales property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberFemales() {
        return numberFemales;
    }

    /**
     * Sets the value of the numberFemales property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberFemales(Integer value) {
        this.numberFemales = value;
    }

    /**
     * Gets the value of the numberChrTested property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberChrTested() {
        return numberChrTested;
    }

    /**
     * Sets the value of the numberChrTested property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberChrTested(Integer value) {
        this.numberChrTested = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the familyData property.
     * 
     * @return
     *     possible object is
     *     {@link FamilyInfo }
     *     
     */
    public FamilyInfo getFamilyData() {
        return familyData;
    }

    /**
     * Sets the value of the familyData property.
     * 
     * @param value
     *     allowed object is
     *     {@link FamilyInfo }
     *     
     */
    public void setFamilyData(FamilyInfo value) {
        this.familyData = value;
    }

    /**
     * Gets the value of the proband property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProband() {
        return proband;
    }

    /**
     * Sets the value of the proband property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProband(String value) {
        this.proband = value;
    }

    /**
     * Gets the value of the citation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the citation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCitation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CitationType }
     * 
     * 
     */
    public List<CitationType> getCitation() {
        if (citation == null) {
            citation = new ArrayList<CitationType>();
        }
        return this.citation;
    }

    /**
     * Gets the value of the xRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XrefType }
     * 
     * 
     */
    public List<XrefType> getXRef() {
        if (xRef == null) {
            xRef = new ArrayList<XrefType>();
        }
        return this.xRef;
    }

    /**
     * Gets the value of the comment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommentType }
     * 
     * 
     */
    public List<CommentType> getComment() {
        if (comment == null) {
            comment = new ArrayList<CommentType>();
        }
        return this.comment;
    }

    /**
     * Gets the value of the sourceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * Sets the value of the sourceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceType(String value) {
        this.sourceType = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
     *       &lt;attribute name="age_unit" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="days"/>
     *             &lt;enumeration value="months"/>
     *             &lt;enumeration value="years"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="Type" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="minimum"/>
     *             &lt;enumeration value="maximum"/>
     *             &lt;enumeration value="single"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Age {

        @XmlValue
        protected int value;
        @XmlAttribute(name = "age_unit", required = true)
        protected String ageUnit;
        @XmlAttribute(name = "Type", required = true)
        protected String type;

        /**
         * Gets the value of the value property.
         * 
         */
        public int getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         */
        public void setValue(int value) {
            this.value = value;
        }

        /**
         * Gets the value of the ageUnit property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAgeUnit() {
            return ageUnit;
        }

        /**
         * Sets the value of the ageUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAgeUnit(String value) {
            this.ageUnit = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Description" type="{}CommentType" minOccurs="0"/>
     *         &lt;element name="Citation" type="{}CitationType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "description",
        "citation"
    })
    public static class SampleDescription {

        @XmlElement(name = "Description")
        protected CommentType description;
        @XmlElement(name = "Citation")
        protected CitationType citation;

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link CommentType }
         *     
         */
        public CommentType getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link CommentType }
         *     
         */
        public void setDescription(CommentType value) {
            this.description = value;
        }

        /**
         * Gets the value of the citation property.
         * 
         * @return
         *     possible object is
         *     {@link CitationType }
         *     
         */
        public CitationType getCitation() {
            return citation;
        }

        /**
         * Sets the value of the citation property.
         * 
         * @param value
         *     allowed object is
         *     {@link CitationType }
         *     
         */
        public void setCitation(CitationType value) {
            this.citation = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="TaxonomyId" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Species {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "TaxonomyId")
        protected Integer taxonomyId;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the taxonomyId property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getTaxonomyId() {
            return taxonomyId;
        }

        /**
         * Sets the value of the taxonomyId property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setTaxonomyId(Integer value) {
            this.taxonomyId = value;
        }

    }

}
