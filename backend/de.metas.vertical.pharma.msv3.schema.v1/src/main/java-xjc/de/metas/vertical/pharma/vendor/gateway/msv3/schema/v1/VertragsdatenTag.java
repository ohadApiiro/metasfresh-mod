//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:38:01 PM CET 
//


package de.metas.vertical.pharma.vendor.gateway.msv3.schema.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VertragsdatenTag.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VertragsdatenTag"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Mo"/&gt;
 *     &lt;enumeration value="Di"/&gt;
 *     &lt;enumeration value="Mi"/&gt;
 *     &lt;enumeration value="Do"/&gt;
 *     &lt;enumeration value="Fr"/&gt;
 *     &lt;enumeration value="Sa"/&gt;
 *     &lt;enumeration value="So"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "VertragsdatenTag")
@XmlEnum
public enum VertragsdatenTag {

    @XmlEnumValue("Mo")
    MO("Mo"),
    @XmlEnumValue("Di")
    DI("Di"),
    @XmlEnumValue("Mi")
    MI("Mi"),
    @XmlEnumValue("Do")
    DO("Do"),
    @XmlEnumValue("Fr")
    FR("Fr"),
    @XmlEnumValue("Sa")
    SA("Sa"),
    @XmlEnumValue("So")
    SO("So");
    private final String value;

    VertragsdatenTag(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VertragsdatenTag fromValue(String v) {
        for (VertragsdatenTag c: VertragsdatenTag.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
