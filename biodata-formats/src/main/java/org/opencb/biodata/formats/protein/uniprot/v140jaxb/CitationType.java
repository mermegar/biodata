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
// This path was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this path will be lost upon recompilation of the source schema.
// Generated on: 2011.09.14 at 07:50:17 PM CEST 
//


package org.opencb.biodata.formats.protein.uniprot.v140jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Describes different types of citations.
 * Equivalent to the flat path RX-, RG-, RA-, RT- and RL-lines.
 * <p/>
 * <p>Java class for citationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="citationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="editorList" type="{http://uniprot.org/uniprot}nameListType" minOccurs="0"/>
 *         &lt;element name="authorList" type="{http://uniprot.org/uniprot}nameListType" minOccurs="0"/>
 *         &lt;element name="locator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dbReference" type="{http://uniprot.org/uniprot}dbReferenceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="book"/>
 *             &lt;enumeration value="journal article"/>
 *             &lt;enumeration value="online journal article"/>
 *             &lt;enumeration value="patent"/>
 *             &lt;enumeration value="submission"/>
 *             &lt;enumeration value="thesis"/>
 *             &lt;enumeration value="unpublished observations"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="date">
 *         &lt;simpleType>
 *           &lt;union memberTypes=" {http://www.w3.org/2001/XMLSchema}date {http://www.w3.org/2001/XMLSchema}gYearMonth {http://www.w3.org/2001/XMLSchema}gYear">
 *           &lt;/union>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="volume" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="first" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="last" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="publisher" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="city" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="db" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="institute" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "citationType", propOrder = {
        "title",
        "editorList",
        "authorList",
        "locator",
        "dbReference"
})
public class CitationType {

    protected String title;
    protected NameListType editorList;
    protected NameListType authorList;
    protected String locator;
    protected List<DbReferenceType> dbReference;
    @XmlAttribute(required = true)
    protected String type;
    @XmlAttribute
    protected String date;
    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected String volume;
    @XmlAttribute
    protected String first;
    @XmlAttribute
    protected String last;
    @XmlAttribute
    protected String publisher;
    @XmlAttribute
    protected String city;
    @XmlAttribute
    protected String db;
    @XmlAttribute
    protected String number;
    @XmlAttribute
    protected String institute;
    @XmlAttribute
    protected String country;

    /**
     * Gets the value of the title property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the editorList property.
     *
     * @return possible object is
     *         {@link NameListType }
     */
    public NameListType getEditorList() {
        return editorList;
    }

    /**
     * Sets the value of the editorList property.
     *
     * @param value allowed object is
     *              {@link NameListType }
     */
    public void setEditorList(NameListType value) {
        this.editorList = value;
    }

    /**
     * Gets the value of the authorList property.
     *
     * @return possible object is
     *         {@link NameListType }
     */
    public NameListType getAuthorList() {
        return authorList;
    }

    /**
     * Sets the value of the authorList property.
     *
     * @param value allowed object is
     *              {@link NameListType }
     */
    public void setAuthorList(NameListType value) {
        this.authorList = value;
    }

    /**
     * Gets the value of the locator property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLocator() {
        return locator;
    }

    /**
     * Sets the value of the locator property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLocator(String value) {
        this.locator = value;
    }

    /**
     * Gets the value of the dbReference property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dbReference property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDbReference().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link DbReferenceType }
     */
    public List<DbReferenceType> getDbReference() {
        if (dbReference == null) {
            dbReference = new ArrayList<DbReferenceType>();
        }
        return this.dbReference;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the date property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the volume property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVolume(String value) {
        this.volume = value;
    }

    /**
     * Gets the value of the first property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFirst() {
        return first;
    }

    /**
     * Sets the value of the first property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFirst(String value) {
        this.first = value;
    }

    /**
     * Gets the value of the last property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLast() {
        return last;
    }

    /**
     * Sets the value of the last property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLast(String value) {
        this.last = value;
    }

    /**
     * Gets the value of the publisher property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the value of the publisher property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPublisher(String value) {
        this.publisher = value;
    }

    /**
     * Gets the value of the city property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the db property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDb() {
        return db;
    }

    /**
     * Sets the value of the db property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDb(String value) {
        this.db = value;
    }

    /**
     * Gets the value of the number property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the institute property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getInstitute() {
        return institute;
    }

    /**
     * Sets the value of the institute property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInstitute(String value) {
        this.institute = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCountry(String value) {
        this.country = value;
    }

}
