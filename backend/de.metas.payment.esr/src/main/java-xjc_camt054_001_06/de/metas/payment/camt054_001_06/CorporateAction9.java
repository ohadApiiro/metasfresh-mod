//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 06:04:17 PM CET 
//


package de.metas.payment.camt054_001_06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CorporateAction9 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CorporateAction9"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EvtTp" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}Max35Text"/&gt;
 *         &lt;element name="EvtId" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}Max35Text"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorporateAction9", propOrder = {
    "evtTp",
    "evtId"
})
public class CorporateAction9 {

    @XmlElement(name = "EvtTp", required = true)
    protected String evtTp;
    @XmlElement(name = "EvtId", required = true)
    protected String evtId;

    /**
     * Gets the value of the evtTp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvtTp() {
        return evtTp;
    }

    /**
     * Sets the value of the evtTp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvtTp(String value) {
        this.evtTp = value;
    }

    /**
     * Gets the value of the evtId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvtId() {
        return evtId;
    }

    /**
     * Sets the value of the evtId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvtId(String value) {
        this.evtId = value;
    }

}