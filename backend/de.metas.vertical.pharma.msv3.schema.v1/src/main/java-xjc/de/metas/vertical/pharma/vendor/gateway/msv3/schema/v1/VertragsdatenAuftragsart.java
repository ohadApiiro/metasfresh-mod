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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VertragsdatenAuftragsart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VertragsdatenAuftragsart"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:msv3:v1}VertragsdatenAuftragsartNormal"&gt;
 *       &lt;attribute name="Vereinbart" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VertragsdatenAuftragsart")
@XmlSeeAlso({
    VertragsdatenAuftragsartVersand.class
})
public class VertragsdatenAuftragsart
    extends VertragsdatenAuftragsartNormal
{

    @XmlAttribute(name = "Vereinbart", required = true)
    protected boolean vereinbart;

    /**
     * Gets the value of the vereinbart property.
     * 
     */
    public boolean isVereinbart() {
        return vereinbart;
    }

    /**
     * Sets the value of the vereinbart property.
     * 
     */
    public void setVereinbart(boolean value) {
        this.vereinbart = value;
    }

}
