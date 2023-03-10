//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:47:04 PM CET 
//


package de.metas.vertical.healthcare_ch.forum_datenaustausch_ch.invoice_440.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for servicesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="servicesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="record_tarmed" type="{http://www.forum-datenaustausch.ch/invoice}recordTarmedType"/&gt;
 *         &lt;element name="record_drg" type="{http://www.forum-datenaustausch.ch/invoice}recordDRGType"/&gt;
 *         &lt;element name="record_lab" type="{http://www.forum-datenaustausch.ch/invoice}recordLabType"/&gt;
 *         &lt;element name="record_migel" type="{http://www.forum-datenaustausch.ch/invoice}recordMigelType"/&gt;
 *         &lt;element name="record_paramed" type="{http://www.forum-datenaustausch.ch/invoice}recordParamedType"/&gt;
 *         &lt;element name="record_drug" type="{http://www.forum-datenaustausch.ch/invoice}recordDrugType"/&gt;
 *         &lt;element name="record_other" type="{http://www.forum-datenaustausch.ch/invoice}recordOtherType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "servicesType", namespace = "http://www.forum-datenaustausch.ch/invoice", propOrder = {
    "recordTarmedOrRecordDrgOrRecordLab"
})
public class ServicesType {

    @XmlElements({
        @XmlElement(name = "record_tarmed", namespace = "http://www.forum-datenaustausch.ch/invoice", type = RecordTarmedType.class),
        @XmlElement(name = "record_drg", namespace = "http://www.forum-datenaustausch.ch/invoice", type = RecordDRGType.class),
        @XmlElement(name = "record_lab", namespace = "http://www.forum-datenaustausch.ch/invoice", type = RecordLabType.class),
        @XmlElement(name = "record_migel", namespace = "http://www.forum-datenaustausch.ch/invoice", type = RecordMigelType.class),
        @XmlElement(name = "record_paramed", namespace = "http://www.forum-datenaustausch.ch/invoice", type = RecordParamedType.class),
        @XmlElement(name = "record_drug", namespace = "http://www.forum-datenaustausch.ch/invoice", type = RecordDrugType.class),
        @XmlElement(name = "record_other", namespace = "http://www.forum-datenaustausch.ch/invoice", type = RecordOtherType.class)
    })
    protected List<Object> recordTarmedOrRecordDrgOrRecordLab;

    /**
     * Gets the value of the recordTarmedOrRecordDrgOrRecordLab property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recordTarmedOrRecordDrgOrRecordLab property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordTarmedOrRecordDrgOrRecordLab().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecordTarmedType }
     * {@link RecordDRGType }
     * {@link RecordLabType }
     * {@link RecordMigelType }
     * {@link RecordParamedType }
     * {@link RecordDrugType }
     * {@link RecordOtherType }
     * 
     * 
     */
    public List<Object> getRecordTarmedOrRecordDrgOrRecordLab() {
        if (recordTarmedOrRecordDrgOrRecordLab == null) {
            recordTarmedOrRecordDrgOrRecordLab = new ArrayList<Object>();
        }
        return this.recordTarmedOrRecordDrgOrRecordLab;
    }

}
