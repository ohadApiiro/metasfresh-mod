//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:46:48 PM CET 
//


package com.dpd.common.service.types.shipmentservice._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for storeOrdersResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="storeOrdersResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="parcellabelsPDF" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="shipmentResponses" type="{http://dpd.com/common/service/types/ShipmentService/3.2}shipmentResponse" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "storeOrdersResponseType", propOrder = {
    "parcellabelsPDF",
    "shipmentResponses"
})
public class StoreOrdersResponseType {

    protected byte[] parcellabelsPDF;
    protected List<ShipmentResponse> shipmentResponses;

    /**
     * Gets the value of the parcellabelsPDF property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getParcellabelsPDF() {
        return parcellabelsPDF;
    }

    /**
     * Sets the value of the parcellabelsPDF property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setParcellabelsPDF(byte[] value) {
        this.parcellabelsPDF = value;
    }

    /**
     * Gets the value of the shipmentResponses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipmentResponses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipmentResponses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentResponse }
     * 
     * 
     */
    public List<ShipmentResponse> getShipmentResponses() {
        if (shipmentResponses == null) {
            shipmentResponses = new ArrayList<ShipmentResponse>();
        }
        return this.shipmentResponses;
    }

}
