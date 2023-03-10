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


/**
 * The data of the pickup order.
 * 
 * <p>Java class for PickupBookingInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PickupBookingInformationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Account"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="14"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PickupDate"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="10"/&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ReadyByTime"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="5"/&gt;
 *               &lt;maxLength value="5"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ClosingTime"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="5"/&gt;
 *               &lt;maxLength value="5"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PickupLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AmountOfPieces" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AmountOfPallets" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="WeightInKG" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *               &lt;minInclusive value="0.0"/&gt;
 *               &lt;maxInclusive value="9999999.99"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CountOfShipments" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TotalVolumeWeight" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *               &lt;minInclusive value="0.0"/&gt;
 *               &lt;maxInclusive value="9999999.99"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MaxLengthInCM" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *               &lt;minInclusive value="0.0"/&gt;
 *               &lt;maxInclusive value="9999999.99"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MaxWidthInCM" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *               &lt;minInclusive value="0.0"/&gt;
 *               &lt;maxInclusive value="9999999.99"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MaxHeightInCM" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *               &lt;minInclusive value="0.0"/&gt;
 *               &lt;maxInclusive value="9999999.99"/&gt;
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
@XmlType(name = "PickupBookingInformationType", propOrder = {
    "account",
    "pickupDate",
    "readyByTime",
    "closingTime",
    "remark",
    "pickupLocation",
    "amountOfPieces",
    "amountOfPallets",
    "weightInKG",
    "countOfShipments",
    "totalVolumeWeight",
    "maxLengthInCM",
    "maxWidthInCM",
    "maxHeightInCM"
})
public class PickupBookingInformationType {

    @XmlElement(name = "Account", required = true)
    protected String account;
    @XmlElement(name = "PickupDate", required = true)
    protected String pickupDate;
    @XmlElement(name = "ReadyByTime", required = true)
    protected String readyByTime;
    @XmlElement(name = "ClosingTime", required = true)
    protected String closingTime;
    @XmlElement(name = "Remark")
    protected String remark;
    @XmlElement(name = "PickupLocation")
    protected String pickupLocation;
    @XmlElement(name = "AmountOfPieces")
    protected BigInteger amountOfPieces;
    @XmlElement(name = "AmountOfPallets")
    protected BigInteger amountOfPallets;
    @XmlElement(name = "WeightInKG")
    protected BigDecimal weightInKG;
    @XmlElement(name = "CountOfShipments")
    protected BigInteger countOfShipments;
    @XmlElement(name = "TotalVolumeWeight")
    protected BigDecimal totalVolumeWeight;
    @XmlElement(name = "MaxLengthInCM")
    protected BigDecimal maxLengthInCM;
    @XmlElement(name = "MaxWidthInCM")
    protected BigDecimal maxWidthInCM;
    @XmlElement(name = "MaxHeightInCM")
    protected BigDecimal maxHeightInCM;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Gets the value of the pickupDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPickupDate() {
        return pickupDate;
    }

    /**
     * Sets the value of the pickupDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPickupDate(String value) {
        this.pickupDate = value;
    }

    /**
     * Gets the value of the readyByTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadyByTime() {
        return readyByTime;
    }

    /**
     * Sets the value of the readyByTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadyByTime(String value) {
        this.readyByTime = value;
    }

    /**
     * Gets the value of the closingTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClosingTime() {
        return closingTime;
    }

    /**
     * Sets the value of the closingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClosingTime(String value) {
        this.closingTime = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the pickupLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPickupLocation() {
        return pickupLocation;
    }

    /**
     * Sets the value of the pickupLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPickupLocation(String value) {
        this.pickupLocation = value;
    }

    /**
     * Gets the value of the amountOfPieces property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmountOfPieces() {
        return amountOfPieces;
    }

    /**
     * Sets the value of the amountOfPieces property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmountOfPieces(BigInteger value) {
        this.amountOfPieces = value;
    }

    /**
     * Gets the value of the amountOfPallets property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmountOfPallets() {
        return amountOfPallets;
    }

    /**
     * Sets the value of the amountOfPallets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmountOfPallets(BigInteger value) {
        this.amountOfPallets = value;
    }

    /**
     * Gets the value of the weightInKG property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWeightInKG() {
        return weightInKG;
    }

    /**
     * Sets the value of the weightInKG property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWeightInKG(BigDecimal value) {
        this.weightInKG = value;
    }

    /**
     * Gets the value of the countOfShipments property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCountOfShipments() {
        return countOfShipments;
    }

    /**
     * Sets the value of the countOfShipments property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCountOfShipments(BigInteger value) {
        this.countOfShipments = value;
    }

    /**
     * Gets the value of the totalVolumeWeight property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalVolumeWeight() {
        return totalVolumeWeight;
    }

    /**
     * Sets the value of the totalVolumeWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalVolumeWeight(BigDecimal value) {
        this.totalVolumeWeight = value;
    }

    /**
     * Gets the value of the maxLengthInCM property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxLengthInCM() {
        return maxLengthInCM;
    }

    /**
     * Sets the value of the maxLengthInCM property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxLengthInCM(BigDecimal value) {
        this.maxLengthInCM = value;
    }

    /**
     * Gets the value of the maxWidthInCM property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxWidthInCM() {
        return maxWidthInCM;
    }

    /**
     * Sets the value of the maxWidthInCM property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxWidthInCM(BigDecimal value) {
        this.maxWidthInCM = value;
    }

    /**
     * Gets the value of the maxHeightInCM property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxHeightInCM() {
        return maxHeightInCM;
    }

    /**
     * Sets the value of the maxHeightInCM property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxHeightInCM(BigDecimal value) {
        this.maxHeightInCM = value;
    }

}
