//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:38:01 PM CET 
//


package de.metas.vertical.pharma.vendor.gateway.msv3.schema.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verfuegbarkeitAnfragen complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verfuegbarkeitAnfragen"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="clientSoftwareKennung" type="{urn:msv3:v1}ClientSoftwareKennung"/&gt;
 *         &lt;element name="verfuegbarkeitsanfrage" type="{urn:msv3:v1}VerfuegbarkeitsanfrageEinzelne"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verfuegbarkeitAnfragen", propOrder = {
    "clientSoftwareKennung",
    "verfuegbarkeitsanfrage"
})
public class VerfuegbarkeitAnfragen {

    @XmlElement(namespace = "", required = true)
    protected String clientSoftwareKennung;
    @XmlElement(namespace = "", required = true)
    protected VerfuegbarkeitsanfrageEinzelne verfuegbarkeitsanfrage;

    /**
     * Gets the value of the clientSoftwareKennung property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientSoftwareKennung() {
        return clientSoftwareKennung;
    }

    /**
     * Sets the value of the clientSoftwareKennung property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientSoftwareKennung(String value) {
        this.clientSoftwareKennung = value;
    }

    /**
     * Gets the value of the verfuegbarkeitsanfrage property.
     * 
     * @return
     *     possible object is
     *     {@link VerfuegbarkeitsanfrageEinzelne }
     *     
     */
    public VerfuegbarkeitsanfrageEinzelne getVerfuegbarkeitsanfrage() {
        return verfuegbarkeitsanfrage;
    }

    /**
     * Sets the value of the verfuegbarkeitsanfrage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VerfuegbarkeitsanfrageEinzelne }
     *     
     */
    public void setVerfuegbarkeitsanfrage(VerfuegbarkeitsanfrageEinzelne value) {
        this.verfuegbarkeitsanfrage = value;
    }

}
