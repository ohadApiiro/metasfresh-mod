//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:38:01 PM CET 
//


package de.metas.vertical.pharma.vendor.gateway.msv3.schema.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for VerfuegbarkeitsanfrageEinzelne complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VerfuegbarkeitsanfrageEinzelne"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Artikel" type="{urn:msv3:v1}ArtikelMenge" maxOccurs="50"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{urn:msv3:v1}uuid" /&gt;
 *       &lt;attribute name="EinsAusNBedarf" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerfuegbarkeitsanfrageEinzelne", propOrder = {
    "artikel"
})
public class VerfuegbarkeitsanfrageEinzelne {

    @XmlElement(name = "Artikel", required = true)
    protected List<ArtikelMenge> artikel;
    @XmlAttribute(name = "Id", required = true)
    protected String id;
    @XmlAttribute(name = "EinsAusNBedarf", required = true)
    protected boolean einsAusNBedarf;

    /**
     * Gets the value of the artikel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the artikel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArtikel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArtikelMenge }
     * 
     * 
     */
    public List<ArtikelMenge> getArtikel() {
        if (artikel == null) {
            artikel = new ArrayList<ArtikelMenge>();
        }
        return this.artikel;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the einsAusNBedarf property.
     * 
     */
    public boolean isEinsAusNBedarf() {
        return einsAusNBedarf;
    }

    /**
     * Sets the value of the einsAusNBedarf property.
     * 
     */
    public void setEinsAusNBedarf(boolean value) {
        this.einsAusNBedarf = value;
    }

}
