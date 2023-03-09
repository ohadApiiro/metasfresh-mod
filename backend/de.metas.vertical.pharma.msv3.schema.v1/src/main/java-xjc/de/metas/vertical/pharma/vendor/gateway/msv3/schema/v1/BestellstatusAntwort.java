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
 * Dibt an, ob:
 *         - Bestellkennung unbekannt ist (seit 7 Tagen)
 *         - Bestellkennung bekannt, aber Bestellantwort ist NICHT MEHR verfügbar
 *         - Bestellkennung bekannt, Bestellantwort ist verfügbar
 *       
 * 
 * <p>Java class for BestellstatusAntwort complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BestellstatusAntwort"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BestellSupportId"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="1"/&gt;
 *               &lt;maxInclusive value="999999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Auftraege" type="{urn:msv3:v1}BestellungAntwortAuftrag" maxOccurs="1000" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{urn:msv3:v1}uuid" /&gt;
 *       &lt;attribute name="Status" use="required" type="{urn:msv3:v1}Bestellstatus" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BestellstatusAntwort", propOrder = {
    "bestellSupportId",
    "auftraege"
})
public class BestellstatusAntwort {

    @XmlElement(name = "BestellSupportId", required = true, type = Integer.class, nillable = true)
    protected Integer bestellSupportId;
    @XmlElement(name = "Auftraege")
    protected List<BestellungAntwortAuftrag> auftraege;
    @XmlAttribute(name = "Id", required = true)
    protected String id;
    @XmlAttribute(name = "Status", required = true)
    protected Bestellstatus status;

    /**
     * Gets the value of the bestellSupportId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBestellSupportId() {
        return bestellSupportId;
    }

    /**
     * Sets the value of the bestellSupportId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBestellSupportId(Integer value) {
        this.bestellSupportId = value;
    }

    /**
     * Gets the value of the auftraege property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the auftraege property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuftraege().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BestellungAntwortAuftrag }
     * 
     * 
     */
    public List<BestellungAntwortAuftrag> getAuftraege() {
        if (auftraege == null) {
            auftraege = new ArrayList<BestellungAntwortAuftrag>();
        }
        return this.auftraege;
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Bestellstatus }
     *     
     */
    public Bestellstatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bestellstatus }
     *     
     */
    public void setStatus(Bestellstatus value) {
        this.status = value;
    }

}