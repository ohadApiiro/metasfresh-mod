//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:47:06 PM CET 
//


package de.metas.vertical.healthcare_ch.forum_datenaustausch_ch.invoice_440.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for statusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="status_in" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="unknown"/&gt;
 *             &lt;enumeration value="ambiguous"/&gt;
 *             &lt;enumeration value="received"/&gt;
 *             &lt;enumeration value="frozen"/&gt;
 *             &lt;enumeration value="processed"/&gt;
 *             &lt;enumeration value="granted"/&gt;
 *             &lt;enumeration value="canceled"/&gt;
 *             &lt;enumeration value="claimed"/&gt;
 *             &lt;enumeration value="reimbursed"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="status_out" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="unknown"/&gt;
 *             &lt;enumeration value="ambiguous"/&gt;
 *             &lt;enumeration value="received"/&gt;
 *             &lt;enumeration value="frozen"/&gt;
 *             &lt;enumeration value="processed"/&gt;
 *             &lt;enumeration value="granted"/&gt;
 *             &lt;enumeration value="canceled"/&gt;
 *             &lt;enumeration value="claimed"/&gt;
 *             &lt;enumeration value="reimbursed"/&gt;
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
@XmlType(name = "statusType")
@XmlSeeAlso({
    PendingType.class,
    AcceptedType.class,
    RejectedType.class
})
public class StatusType {

    @XmlAttribute(name = "status_in", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String statusIn;
    @XmlAttribute(name = "status_out", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String statusOut;

    /**
     * Gets the value of the statusIn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusIn() {
        return statusIn;
    }

    /**
     * Sets the value of the statusIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusIn(String value) {
        this.statusIn = value;
    }

    /**
     * Gets the value of the statusOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusOut() {
        return statusOut;
    }

    /**
     * Sets the value of the statusOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusOut(String value) {
        this.statusOut = value;
    }

}