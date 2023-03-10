//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:46:45 PM CET 
//


package de.dhl.webservices.businesscustomershipping._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * The data of the export document for a shipment.
 * 
 * <p>Java class for ExportDocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="invoiceNumber" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="35"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="exportType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="OTHER"/&gt;
 *               &lt;enumeration value="PRESENT"/&gt;
 *               &lt;enumeration value="COMMERCIAL_SAMPLE"/&gt;
 *               &lt;enumeration value="DOCUMENT"/&gt;
 *               &lt;enumeration value="RETURN_OF_GOODS"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="exportTypeDescription" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="256"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="termsOfTrade" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="3"/&gt;
 *               &lt;maxLength value="3"/&gt;
 *               &lt;enumeration value="DDP"/&gt;
 *               &lt;enumeration value="DXV"/&gt;
 *               &lt;enumeration value="DDU"/&gt;
 *               &lt;enumeration value="DDX"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="placeOfCommital"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="35"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="additionalFee"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *               &lt;minInclusive value="0.0"/&gt;
 *               &lt;maxInclusive value="9999999.99"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="permitNumber" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="attestationNumber" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="35"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="WithElectronicExportNtfctn" type="{http://dhl.de/webservices/businesscustomershipping/3.0}Serviceconfiguration" minOccurs="0"/&gt;
 *         &lt;element name="ExportDocPosition" maxOccurs="6" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="description"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="256"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="countryCodeOrigin"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;minLength value="2"/&gt;
 *                         &lt;maxLength value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="customsTariffNumber"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="10"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="amount"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                         &lt;minInclusive value="1"/&gt;
 *                         &lt;totalDigits value="10"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="netWeightInKG"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                         &lt;minInclusive value="0.0"/&gt;
 *                         &lt;maxInclusive value="999999.99"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="customsValue"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                         &lt;minInclusive value="0.0"/&gt;
 *                         &lt;maxInclusive value="999999.99"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportDocumentType", propOrder = {
    "invoiceNumber",
    "exportType",
    "exportTypeDescription",
    "termsOfTrade",
    "placeOfCommital",
    "additionalFee",
    "permitNumber",
    "attestationNumber",
    "withElectronicExportNtfctn",
    "exportDocPosition"
})
public class ExportDocumentType {

    protected String invoiceNumber;
    @XmlElement(required = true)
    protected String exportType;
    protected String exportTypeDescription;
    protected String termsOfTrade;
    @XmlElement(required = true)
    protected String placeOfCommital;
    @XmlElement(required = true)
    protected BigDecimal additionalFee;
    protected String permitNumber;
    protected String attestationNumber;
    @XmlElement(name = "WithElectronicExportNtfctn")
    protected Serviceconfiguration withElectronicExportNtfctn;
    @XmlElement(name = "ExportDocPosition")
    protected List<ExportDocumentType.ExportDocPosition> exportDocPosition;

    /**
     * Gets the value of the invoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Sets the value of the invoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

    /**
     * Gets the value of the exportType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportType() {
        return exportType;
    }

    /**
     * Sets the value of the exportType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportType(String value) {
        this.exportType = value;
    }

    /**
     * Gets the value of the exportTypeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportTypeDescription() {
        return exportTypeDescription;
    }

    /**
     * Sets the value of the exportTypeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportTypeDescription(String value) {
        this.exportTypeDescription = value;
    }

    /**
     * Gets the value of the termsOfTrade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermsOfTrade() {
        return termsOfTrade;
    }

    /**
     * Sets the value of the termsOfTrade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermsOfTrade(String value) {
        this.termsOfTrade = value;
    }

    /**
     * Gets the value of the placeOfCommital property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceOfCommital() {
        return placeOfCommital;
    }

    /**
     * Sets the value of the placeOfCommital property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceOfCommital(String value) {
        this.placeOfCommital = value;
    }

    /**
     * Gets the value of the additionalFee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAdditionalFee() {
        return additionalFee;
    }

    /**
     * Sets the value of the additionalFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAdditionalFee(BigDecimal value) {
        this.additionalFee = value;
    }

    /**
     * Gets the value of the permitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermitNumber() {
        return permitNumber;
    }

    /**
     * Sets the value of the permitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermitNumber(String value) {
        this.permitNumber = value;
    }

    /**
     * Gets the value of the attestationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttestationNumber() {
        return attestationNumber;
    }

    /**
     * Sets the value of the attestationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttestationNumber(String value) {
        this.attestationNumber = value;
    }

    /**
     * Gets the value of the withElectronicExportNtfctn property.
     * 
     * @return
     *     possible object is
     *     {@link Serviceconfiguration }
     *     
     */
    public Serviceconfiguration getWithElectronicExportNtfctn() {
        return withElectronicExportNtfctn;
    }

    /**
     * Sets the value of the withElectronicExportNtfctn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Serviceconfiguration }
     *     
     */
    public void setWithElectronicExportNtfctn(Serviceconfiguration value) {
        this.withElectronicExportNtfctn = value;
    }

    /**
     * Gets the value of the exportDocPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportDocPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportDocPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportDocumentType.ExportDocPosition }
     * 
     * 
     */
    public List<ExportDocumentType.ExportDocPosition> getExportDocPosition() {
        if (exportDocPosition == null) {
            exportDocPosition = new ArrayList<ExportDocumentType.ExportDocPosition>();
        }
        return this.exportDocPosition;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="description"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="256"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="countryCodeOrigin"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="2"/&gt;
     *               &lt;maxLength value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="customsTariffNumber"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="10"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="amount"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *               &lt;minInclusive value="1"/&gt;
     *               &lt;totalDigits value="10"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="netWeightInKG"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *               &lt;minInclusive value="0.0"/&gt;
     *               &lt;maxInclusive value="999999.99"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="customsValue"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *               &lt;minInclusive value="0.0"/&gt;
     *               &lt;maxInclusive value="999999.99"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "description",
        "countryCodeOrigin",
        "customsTariffNumber",
        "amount",
        "netWeightInKG",
        "customsValue"
    })
    public static class ExportDocPosition {

        @XmlElement(required = true)
        protected String description;
        @XmlElement(required = true)
        protected String countryCodeOrigin;
        @XmlElement(required = true)
        protected String customsTariffNumber;
        @XmlElement(required = true)
        protected BigInteger amount;
        @XmlElement(required = true)
        protected BigDecimal netWeightInKG;
        @XmlElement(required = true)
        protected BigDecimal customsValue;

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * Gets the value of the countryCodeOrigin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountryCodeOrigin() {
            return countryCodeOrigin;
        }

        /**
         * Sets the value of the countryCodeOrigin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountryCodeOrigin(String value) {
            this.countryCodeOrigin = value;
        }

        /**
         * Gets the value of the customsTariffNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCustomsTariffNumber() {
            return customsTariffNumber;
        }

        /**
         * Sets the value of the customsTariffNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCustomsTariffNumber(String value) {
            this.customsTariffNumber = value;
        }

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAmount(BigInteger value) {
            this.amount = value;
        }

        /**
         * Gets the value of the netWeightInKG property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getNetWeightInKG() {
            return netWeightInKG;
        }

        /**
         * Sets the value of the netWeightInKG property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setNetWeightInKG(BigDecimal value) {
            this.netWeightInKG = value;
        }

        /**
         * Gets the value of the customsValue property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getCustomsValue() {
            return customsValue;
        }

        /**
         * Sets the value of the customsValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setCustomsValue(BigDecimal value) {
            this.customsValue = value;
        }

    }

}
