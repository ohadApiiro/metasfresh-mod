//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:38:20 PM CET 
//


package de.metas.vertical.pharma.vendor.gateway.msv3.schema.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * unverbind. Anfrage zur Beurteilung durch GH
 * 
 * <p>Java class for RetourenavisAnfrageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetourenavisAnfrageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Position" type="{urn:msv3:v2}RetourePositionType" maxOccurs="999"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ID" use="required" type="{urn:msv3:v2}uuid" /&gt;
 *       &lt;attribute name="RetoureSupportID" use="required" type="{urn:msv3:v2}SupportIDType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetourenavisAnfrageType", propOrder = {
    "position"
})
public class RetourenavisAnfrageType {

    @XmlElement(name = "Position", required = true)
    protected List<RetourePositionType> position;
    @XmlAttribute(name = "ID", required = true)
    protected String id;
    @XmlAttribute(name = "RetoureSupportID", required = true)
    protected int retoureSupportID;

    /**
     * Gets the value of the position property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the position property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RetourePositionType }
     * 
     * 
     */
    public List<RetourePositionType> getPosition() {
        if (position == null) {
            position = new ArrayList<RetourePositionType>();
        }
        return this.position;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
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
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the retoureSupportID property.
     * 
     */
    public int getRetoureSupportID() {
        return retoureSupportID;
    }

    /**
     * Sets the value of the retoureSupportID property.
     * 
     */
    public void setRetoureSupportID(int value) {
        this.retoureSupportID = value;
    }

}