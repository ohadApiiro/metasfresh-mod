//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:46:48 PM CET 
//


package com.dpd.common.service.types.shipmentservice._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for international complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="international"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="parcelType" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="customsAmount"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long"&gt;
 *               &lt;maxInclusive value="999999999999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="customsCurrency"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="customsTerms"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="01"/&gt;
 *               &lt;enumeration value="02"/&gt;
 *               &lt;enumeration value="03"/&gt;
 *               &lt;enumeration value="05"/&gt;
 *               &lt;enumeration value="06"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="customsContent"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="35"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="customsTarif" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="8"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="customsPaper" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="customsEnclosure" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="customsInvoice" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="customsInvoiceDate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;maxInclusive value="99999999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="customsAmountParcel" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long"&gt;
 *               &lt;maxInclusive value="999999999999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="customsOrigin" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="linehaul" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="AI"/&gt;
 *               &lt;enumeration value="RO"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="shipMrn" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="collectiveCustomsClearance" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="invoicePosition" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="6"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="comment1" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="70"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="comment2" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="70"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="commercialInvoiceConsigneeVatNumber" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="commercialInvoiceConsignee" type="{http://dpd.com/common/service/types/ShipmentService/3.2}address"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "international", propOrder = {
    "parcelType",
    "customsAmount",
    "customsCurrency",
    "customsTerms",
    "customsContent",
    "customsTarif",
    "customsPaper",
    "customsEnclosure",
    "customsInvoice",
    "customsInvoiceDate",
    "customsAmountParcel",
    "customsOrigin",
    "linehaul",
    "shipMrn",
    "collectiveCustomsClearance",
    "invoicePosition",
    "comment1",
    "comment2",
    "commercialInvoiceConsigneeVatNumber",
    "commercialInvoiceConsignee"
})
public class International {

    protected boolean parcelType;
    protected long customsAmount;
    @XmlElement(required = true)
    protected String customsCurrency;
    @XmlElement(required = true)
    protected String customsTerms;
    @XmlElement(required = true)
    protected String customsContent;
    protected String customsTarif;
    protected String customsPaper;
    protected Boolean customsEnclosure;
    protected String customsInvoice;
    protected Integer customsInvoiceDate;
    protected Long customsAmountParcel;
    protected String customsOrigin;
    protected String linehaul;
    protected String shipMrn;
    protected Boolean collectiveCustomsClearance;
    protected String invoicePosition;
    protected String comment1;
    protected String comment2;
    protected String commercialInvoiceConsigneeVatNumber;
    @XmlElement(required = true)
    protected Address commercialInvoiceConsignee;

    /**
     * Gets the value of the parcelType property.
     * 
     */
    public boolean isParcelType() {
        return parcelType;
    }

    /**
     * Sets the value of the parcelType property.
     * 
     */
    public void setParcelType(boolean value) {
        this.parcelType = value;
    }

    /**
     * Gets the value of the customsAmount property.
     * 
     */
    public long getCustomsAmount() {
        return customsAmount;
    }

    /**
     * Sets the value of the customsAmount property.
     * 
     */
    public void setCustomsAmount(long value) {
        this.customsAmount = value;
    }

    /**
     * Gets the value of the customsCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomsCurrency() {
        return customsCurrency;
    }

    /**
     * Sets the value of the customsCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomsCurrency(String value) {
        this.customsCurrency = value;
    }

    /**
     * Gets the value of the customsTerms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomsTerms() {
        return customsTerms;
    }

    /**
     * Sets the value of the customsTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomsTerms(String value) {
        this.customsTerms = value;
    }

    /**
     * Gets the value of the customsContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomsContent() {
        return customsContent;
    }

    /**
     * Sets the value of the customsContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomsContent(String value) {
        this.customsContent = value;
    }

    /**
     * Gets the value of the customsTarif property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomsTarif() {
        return customsTarif;
    }

    /**
     * Sets the value of the customsTarif property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomsTarif(String value) {
        this.customsTarif = value;
    }

    /**
     * Gets the value of the customsPaper property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomsPaper() {
        return customsPaper;
    }

    /**
     * Sets the value of the customsPaper property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomsPaper(String value) {
        this.customsPaper = value;
    }

    /**
     * Gets the value of the customsEnclosure property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCustomsEnclosure() {
        return customsEnclosure;
    }

    /**
     * Sets the value of the customsEnclosure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCustomsEnclosure(Boolean value) {
        this.customsEnclosure = value;
    }

    /**
     * Gets the value of the customsInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomsInvoice() {
        return customsInvoice;
    }

    /**
     * Sets the value of the customsInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomsInvoice(String value) {
        this.customsInvoice = value;
    }

    /**
     * Gets the value of the customsInvoiceDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCustomsInvoiceDate() {
        return customsInvoiceDate;
    }

    /**
     * Sets the value of the customsInvoiceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCustomsInvoiceDate(Integer value) {
        this.customsInvoiceDate = value;
    }

    /**
     * Gets the value of the customsAmountParcel property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomsAmountParcel() {
        return customsAmountParcel;
    }

    /**
     * Sets the value of the customsAmountParcel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomsAmountParcel(Long value) {
        this.customsAmountParcel = value;
    }

    /**
     * Gets the value of the customsOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomsOrigin() {
        return customsOrigin;
    }

    /**
     * Sets the value of the customsOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomsOrigin(String value) {
        this.customsOrigin = value;
    }

    /**
     * Gets the value of the linehaul property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinehaul() {
        return linehaul;
    }

    /**
     * Sets the value of the linehaul property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinehaul(String value) {
        this.linehaul = value;
    }

    /**
     * Gets the value of the shipMrn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipMrn() {
        return shipMrn;
    }

    /**
     * Sets the value of the shipMrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipMrn(String value) {
        this.shipMrn = value;
    }

    /**
     * Gets the value of the collectiveCustomsClearance property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCollectiveCustomsClearance() {
        return collectiveCustomsClearance;
    }

    /**
     * Sets the value of the collectiveCustomsClearance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCollectiveCustomsClearance(Boolean value) {
        this.collectiveCustomsClearance = value;
    }

    /**
     * Gets the value of the invoicePosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoicePosition() {
        return invoicePosition;
    }

    /**
     * Sets the value of the invoicePosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoicePosition(String value) {
        this.invoicePosition = value;
    }

    /**
     * Gets the value of the comment1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment1() {
        return comment1;
    }

    /**
     * Sets the value of the comment1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment1(String value) {
        this.comment1 = value;
    }

    /**
     * Gets the value of the comment2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment2() {
        return comment2;
    }

    /**
     * Sets the value of the comment2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment2(String value) {
        this.comment2 = value;
    }

    /**
     * Gets the value of the commercialInvoiceConsigneeVatNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommercialInvoiceConsigneeVatNumber() {
        return commercialInvoiceConsigneeVatNumber;
    }

    /**
     * Sets the value of the commercialInvoiceConsigneeVatNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommercialInvoiceConsigneeVatNumber(String value) {
        this.commercialInvoiceConsigneeVatNumber = value;
    }

    /**
     * Gets the value of the commercialInvoiceConsignee property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getCommercialInvoiceConsignee() {
        return commercialInvoiceConsignee;
    }

    /**
     * Sets the value of the commercialInvoiceConsignee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setCommercialInvoiceConsignee(Address value) {
        this.commercialInvoiceConsignee = value;
    }

}