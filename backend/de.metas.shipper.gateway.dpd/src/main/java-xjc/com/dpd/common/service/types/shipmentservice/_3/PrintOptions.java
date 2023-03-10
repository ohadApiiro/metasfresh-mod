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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Options how to return the parcel labels
 * 
 * <p>Java class for printOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="printOptions"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="printerLanguage"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="PDF"/&gt;
 *               &lt;enumeration value="ZPL"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="paperFormat"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="A4"/&gt;
 *               &lt;enumeration value="A6"/&gt;
 *               &lt;enumeration value="A7"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="printer" type="{http://dpd.com/common/service/types/ShipmentService/3.2}printer" minOccurs="0"/&gt;
 *         &lt;element name="startPosition" type="{http://dpd.com/common/service/types/ShipmentService/3.2}startPosition" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "printOptions", propOrder = {
    "printerLanguage",
    "paperFormat",
    "printer",
    "startPosition"
})
public class PrintOptions {

    @XmlElement(required = true)
    protected String printerLanguage;
    @XmlElement(required = true)
    protected String paperFormat;
    protected Printer printer;
    @XmlSchemaType(name = "string")
    protected StartPosition startPosition;

    /**
     * Gets the value of the printerLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrinterLanguage() {
        return printerLanguage;
    }

    /**
     * Sets the value of the printerLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrinterLanguage(String value) {
        this.printerLanguage = value;
    }

    /**
     * Gets the value of the paperFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaperFormat() {
        return paperFormat;
    }

    /**
     * Sets the value of the paperFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaperFormat(String value) {
        this.paperFormat = value;
    }

    /**
     * Gets the value of the printer property.
     * 
     * @return
     *     possible object is
     *     {@link Printer }
     *     
     */
    public Printer getPrinter() {
        return printer;
    }

    /**
     * Sets the value of the printer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Printer }
     *     
     */
    public void setPrinter(Printer value) {
        this.printer = value;
    }

    /**
     * Gets the value of the startPosition property.
     * 
     * @return
     *     possible object is
     *     {@link StartPosition }
     *     
     */
    public StartPosition getStartPosition() {
        return startPosition;
    }

    /**
     * Sets the value of the startPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartPosition }
     *     
     */
    public void setStartPosition(StartPosition value) {
        this.startPosition = value;
    }

}
