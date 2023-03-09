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
 * <p>Java class for Bestellstatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Bestellstatus"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="KennungUnbekannt"/&gt;
 *     &lt;enumeration value="BestellantwortNichtVerfuegbar"/&gt;
 *     &lt;enumeration value="BestellantwortVerfuegbar"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Bestellstatus")
@XmlEnum
public enum Bestellstatus {

    @XmlEnumValue("KennungUnbekannt")
    KENNUNG_UNBEKANNT("KennungUnbekannt"),
    @XmlEnumValue("BestellantwortNichtVerfuegbar")
    BESTELLANTWORT_NICHT_VERFUEGBAR("BestellantwortNichtVerfuegbar"),
    @XmlEnumValue("BestellantwortVerfuegbar")
    BESTELLANTWORT_VERFUEGBAR("BestellantwortVerfuegbar");
    private final String value;

    Bestellstatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Bestellstatus fromValue(String v) {
        for (Bestellstatus c: Bestellstatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}