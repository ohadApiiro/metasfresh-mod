//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.06 at 03:38:18 PM CET 
//


package at.erpel.schemas._1p0.documents;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PriceTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PriceTypeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="CalculationNet"/&gt;
 *     &lt;enumeration value="CalculationGross"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PriceTypeType")
@XmlEnum
public enum PriceTypeType {


    /**
     * Indicates the calculation net price. The calculation net price is the price including allowances/ charges and excluding taxes.
     * 
     */
    @XmlEnumValue("CalculationNet")
    CALCULATION_NET("CalculationNet"),

    /**
     * Indicates the calculation gross price. The calculation gross price is the price excluding all allowances, charges and taxes.
     * 
     */
    @XmlEnumValue("CalculationGross")
    CALCULATION_GROSS("CalculationGross");
    private final String value;

    PriceTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PriceTypeType fromValue(String v) {
        for (PriceTypeType c: PriceTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}