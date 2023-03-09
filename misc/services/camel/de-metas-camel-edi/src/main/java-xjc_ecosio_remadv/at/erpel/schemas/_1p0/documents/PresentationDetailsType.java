//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.06 at 03:38:18 PM CET 
//


package at.erpel.schemas._1p0.documents;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import at.erpel.schemas._1p0.documents.ext.PresentationDetailsExtensionType;


/**
 * <p>Java class for PresentationDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PresentationDetailsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}URL" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}LogoURL" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}LayoutID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}SuppressZero" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/ext}PresentationDetailsExtension" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PresentationDetailsType", propOrder = {
    "url",
    "logoURL",
    "layoutID",
    "suppressZero",
    "presentationDetailsExtension"
})
public class PresentationDetailsType {

    @XmlElement(name = "URL")
    @XmlSchemaType(name = "anyURI")
    protected String url;
    @XmlElement(name = "LogoURL")
    @XmlSchemaType(name = "anyURI")
    protected String logoURL;
    @XmlElement(name = "LayoutID")
    protected String layoutID;
    @XmlElement(name = "SuppressZero")
    protected Boolean suppressZero;
    @XmlElement(name = "PresentationDetailsExtension", namespace = "http://erpel.at/schemas/1p0/documents/ext")
    protected PresentationDetailsExtensionType presentationDetailsExtension;

    /**
     * A link to the website of the issuer of the document.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURL() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURL(String value) {
        this.url = value;
    }

    /**
     * A URL to the logo of the issuer of the document.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogoURL() {
        return logoURL;
    }

    /**
     * Sets the value of the logoURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogoURL(String value) {
        this.logoURL = value;
    }

    /**
     * A certain layout id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLayoutID() {
        return layoutID;
    }

    /**
     * Sets the value of the layoutID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLayoutID(String value) {
        this.layoutID = value;
    }

    /**
     * Indicates whether an amount of 0 shall be shown or not.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSuppressZero() {
        return suppressZero;
    }

    /**
     * Sets the value of the suppressZero property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuppressZero(Boolean value) {
        this.suppressZero = value;
    }

    /**
     * Gets the value of the presentationDetailsExtension property.
     * 
     * @return
     *     possible object is
     *     {@link PresentationDetailsExtensionType }
     *     
     */
    public PresentationDetailsExtensionType getPresentationDetailsExtension() {
        return presentationDetailsExtension;
    }

    /**
     * Sets the value of the presentationDetailsExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link PresentationDetailsExtensionType }
     *     
     */
    public void setPresentationDetailsExtension(PresentationDetailsExtensionType value) {
        this.presentationDetailsExtension = value;
    }

}