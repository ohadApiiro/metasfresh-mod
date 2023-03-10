//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:46:48 PM CET 
//


package com.dpd.common.service.types.shipmentservice._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for parcelShopDelivery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parcelShopDelivery"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="parcelShopId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="parcelShopNotification" type="{http://dpd.com/common/service/types/ShipmentService/3.2}notification"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parcelShopDelivery", propOrder = {
    "parcelShopId",
    "parcelShopNotification"
})
public class ParcelShopDelivery {

    protected long parcelShopId;
    @XmlElement(required = true)
    protected Notification parcelShopNotification;

    /**
     * Gets the value of the parcelShopId property.
     * 
     */
    public long getParcelShopId() {
        return parcelShopId;
    }

    /**
     * Sets the value of the parcelShopId property.
     * 
     */
    public void setParcelShopId(long value) {
        this.parcelShopId = value;
    }

    /**
     * Gets the value of the parcelShopNotification property.
     * 
     * @return
     *     possible object is
     *     {@link Notification }
     *     
     */
    public Notification getParcelShopNotification() {
        return parcelShopNotification;
    }

    /**
     * Sets the value of the parcelShopNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Notification }
     *     
     */
    public void setParcelShopNotification(Notification value) {
        this.parcelShopNotification = value;
    }

}
