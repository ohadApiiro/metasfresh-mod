//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:50:38 PM CET 
//


package de.metas.payment.sepa.jaxb.sct.pain_008_003_02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonIdentificationSEPA2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonIdentificationSEPA2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.003.02}RestrictedPersonIdentificationSEPA"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonIdentificationSEPA2", propOrder = {
    "othr"
})
public class PersonIdentificationSEPA2 {

    @XmlElement(name = "Othr", required = true)
    protected RestrictedPersonIdentificationSEPA othr;

    /**
     * Gets the value of the othr property.
     * 
     * @return
     *     possible object is
     *     {@link RestrictedPersonIdentificationSEPA }
     *     
     */
    public RestrictedPersonIdentificationSEPA getOthr() {
        return othr;
    }

    /**
     * Sets the value of the othr property.
     * 
     * @param value
     *     allowed object is
     *     {@link RestrictedPersonIdentificationSEPA }
     *     
     */
    public void setOthr(RestrictedPersonIdentificationSEPA value) {
        this.othr = value;
    }

}