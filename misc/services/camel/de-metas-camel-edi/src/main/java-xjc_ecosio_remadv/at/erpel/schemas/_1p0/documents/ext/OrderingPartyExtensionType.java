//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.06 at 03:38:18 PM CET 
//


package at.erpel.schemas._1p0.documents.ext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderingPartyExtensionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderingPartyExtensionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}OrderingPartyExtension"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/ext}ErpelOrderingPartyExtension"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderingPartyExtensionType", propOrder = {
    "orderingPartyExtension",
    "erpelOrderingPartyExtension"
})
public class OrderingPartyExtensionType {

    @XmlElement(name = "OrderingPartyExtension", namespace = "http://erpel.at/schemas/1p0/documents/extensions/edifact")
    protected at.erpel.schemas._1p0.documents.extensions.edifact.OrderingPartyExtensionType orderingPartyExtension;
    @XmlElement(name = "ErpelOrderingPartyExtension")
    protected CustomType erpelOrderingPartyExtension;

    /**
     * Gets the value of the orderingPartyExtension property.
     * 
     * @return
     *     possible object is
     *     {@link at.erpel.schemas._1p0.documents.extensions.edifact.OrderingPartyExtensionType }
     *     
     */
    public at.erpel.schemas._1p0.documents.extensions.edifact.OrderingPartyExtensionType getOrderingPartyExtension() {
        return orderingPartyExtension;
    }

    /**
     * Sets the value of the orderingPartyExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link at.erpel.schemas._1p0.documents.extensions.edifact.OrderingPartyExtensionType }
     *     
     */
    public void setOrderingPartyExtension(at.erpel.schemas._1p0.documents.extensions.edifact.OrderingPartyExtensionType value) {
        this.orderingPartyExtension = value;
    }

    /**
     * Gets the value of the erpelOrderingPartyExtension property.
     * 
     * @return
     *     possible object is
     *     {@link CustomType }
     *     
     */
    public CustomType getErpelOrderingPartyExtension() {
        return erpelOrderingPartyExtension;
    }

    /**
     * Sets the value of the erpelOrderingPartyExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomType }
     *     
     */
    public void setErpelOrderingPartyExtension(CustomType value) {
        this.erpelOrderingPartyExtension = value;
    }

}