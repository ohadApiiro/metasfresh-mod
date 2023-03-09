//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:47:07 PM CET 
//


package de.metas.vertical.healthcare_ch.forum_datenaustausch_ch.invoice_450.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for esrRedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="esrRedType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bank" type="{http://www.forum-datenaustausch.ch/invoice}esrAddressType" minOccurs="0"/&gt;
 *         &lt;element name="creditor" type="{http://www.forum-datenaustausch.ch/invoice}esrAddressType"/&gt;
 *         &lt;element name="payment_reason" type="{http://www.forum-datenaustausch.ch/invoice}stringType1_35" maxOccurs="4" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="payment_to" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="postal_account"/&gt;
 *             &lt;enumeration value="bank_account"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="post_account" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="[0-9]{2}-[0-9]{1,6}-[0-9]"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="iban"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="(LI|CH)[0-9]{7}[0-9A-Z]{12}"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="reference_number"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="[0-9A-Z]{10}"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="coding_line1" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="([0-9]{27}\+ 07[0-9]{7}&gt;|[0-9]{9}&gt;)"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="coding_line2" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="[0-9]{9}&gt;"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "esrRedType", namespace = "http://www.forum-datenaustausch.ch/invoice", propOrder = {
    "bank",
    "creditor",
    "paymentReason"
})
public class EsrRedType {

    @XmlElement(namespace = "http://www.forum-datenaustausch.ch/invoice")
    protected EsrAddressType bank;
    @XmlElement(namespace = "http://www.forum-datenaustausch.ch/invoice", required = true)
    protected EsrAddressType creditor;
    @XmlElement(name = "payment_reason", namespace = "http://www.forum-datenaustausch.ch/invoice")
    protected List<String> paymentReason;
    @XmlAttribute(name = "payment_to", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String paymentTo;
    @XmlAttribute(name = "post_account", required = true)
    protected String postAccount;
    @XmlAttribute(name = "iban")
    protected String iban;
    @XmlAttribute(name = "reference_number")
    protected String referenceNumber;
    @XmlAttribute(name = "coding_line1", required = true)
    protected String codingLine1;
    @XmlAttribute(name = "coding_line2", required = true)
    protected String codingLine2;

    /**
     * Gets the value of the bank property.
     * 
     * @return
     *     possible object is
     *     {@link EsrAddressType }
     *     
     */
    public EsrAddressType getBank() {
        return bank;
    }

    /**
     * Sets the value of the bank property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsrAddressType }
     *     
     */
    public void setBank(EsrAddressType value) {
        this.bank = value;
    }

    /**
     * Gets the value of the creditor property.
     * 
     * @return
     *     possible object is
     *     {@link EsrAddressType }
     *     
     */
    public EsrAddressType getCreditor() {
        return creditor;
    }

    /**
     * Sets the value of the creditor property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsrAddressType }
     *     
     */
    public void setCreditor(EsrAddressType value) {
        this.creditor = value;
    }

    /**
     * Gets the value of the paymentReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPaymentReason() {
        if (paymentReason == null) {
            paymentReason = new ArrayList<String>();
        }
        return this.paymentReason;
    }

    /**
     * Gets the value of the paymentTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentTo() {
        return paymentTo;
    }

    /**
     * Sets the value of the paymentTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentTo(String value) {
        this.paymentTo = value;
    }

    /**
     * Gets the value of the postAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostAccount() {
        return postAccount;
    }

    /**
     * Sets the value of the postAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostAccount(String value) {
        this.postAccount = value;
    }

    /**
     * Gets the value of the iban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIban() {
        return iban;
    }

    /**
     * Sets the value of the iban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIban(String value) {
        this.iban = value;
    }

    /**
     * Gets the value of the referenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Sets the value of the referenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceNumber(String value) {
        this.referenceNumber = value;
    }

    /**
     * Gets the value of the codingLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodingLine1() {
        return codingLine1;
    }

    /**
     * Sets the value of the codingLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodingLine1(String value) {
        this.codingLine1 = value;
    }

    /**
     * Gets the value of the codingLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodingLine2() {
        return codingLine2;
    }

    /**
     * Sets the value of the codingLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodingLine2(String value) {
        this.codingLine2 = value;
    }

}