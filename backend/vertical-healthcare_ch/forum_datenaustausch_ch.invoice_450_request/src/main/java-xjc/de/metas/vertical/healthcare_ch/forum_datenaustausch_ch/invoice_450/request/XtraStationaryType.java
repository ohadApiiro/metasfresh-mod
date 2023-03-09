//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:47:07 PM CET 
//


package de.metas.vertical.healthcare_ch.forum_datenaustausch_ch.invoice_450.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for xtraStationaryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xtraStationaryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="admission_type" type="{http://www.forum-datenaustausch.ch/invoice}grouperDataType"/&gt;
 *         &lt;element name="discharge_type" type="{http://www.forum-datenaustausch.ch/invoice}grouperDataType"/&gt;
 *         &lt;element name="provider_type" type="{http://www.forum-datenaustausch.ch/invoice}grouperDataType"/&gt;
 *         &lt;element name="bfs_residence_before_admission" type="{http://www.forum-datenaustausch.ch/invoice}bfsDataType"/&gt;
 *         &lt;element name="bfs_admission_type" type="{http://www.forum-datenaustausch.ch/invoice}bfsDataType"/&gt;
 *         &lt;element name="bfs_decision_for_discharge" type="{http://www.forum-datenaustausch.ch/invoice}bfsDataType"/&gt;
 *         &lt;element name="bfs_residence_after_discharge" type="{http://www.forum-datenaustausch.ch/invoice}bfsDataType"/&gt;
 *         &lt;element name="case_detail" type="{http://www.forum-datenaustausch.ch/invoice}caseDetailType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="hospitalization_date" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="treatment_days" use="required" type="{http://www.w3.org/2001/XMLSchema}duration" /&gt;
 *       &lt;attribute name="hospitalization_type" default="regular"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="regular"/&gt;
 *             &lt;enumeration value="emergency"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="hospitalization_mode" default="cantonal"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="cantonal"/&gt;
 *             &lt;enumeration value="noncantonal_indicated"/&gt;
 *             &lt;enumeration value="noncantonal_nonindicated"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="class" default="general"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="private"/&gt;
 *             &lt;enumeration value="semi_private"/&gt;
 *             &lt;enumeration value="general"/&gt;
 *             &lt;enumeration value="hospital_comfort"/&gt;
 *             &lt;enumeration value="md_free_choice"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="section_major" type="{http://www.forum-datenaustausch.ch/invoice}stringType1_6" /&gt;
 *       &lt;attribute name="has_expense_loading" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xtraStationaryType", namespace = "http://www.forum-datenaustausch.ch/invoice", propOrder = {
    "admissionType",
    "dischargeType",
    "providerType",
    "bfsResidenceBeforeAdmission",
    "bfsAdmissionType",
    "bfsDecisionForDischarge",
    "bfsResidenceAfterDischarge",
    "caseDetail"
})
public class XtraStationaryType {

    @XmlElement(name = "admission_type", namespace = "http://www.forum-datenaustausch.ch/invoice", required = true)
    protected GrouperDataType admissionType;
    @XmlElement(name = "discharge_type", namespace = "http://www.forum-datenaustausch.ch/invoice", required = true)
    protected GrouperDataType dischargeType;
    @XmlElement(name = "provider_type", namespace = "http://www.forum-datenaustausch.ch/invoice", required = true)
    protected GrouperDataType providerType;
    @XmlElement(name = "bfs_residence_before_admission", namespace = "http://www.forum-datenaustausch.ch/invoice", required = true)
    protected BfsDataType bfsResidenceBeforeAdmission;
    @XmlElement(name = "bfs_admission_type", namespace = "http://www.forum-datenaustausch.ch/invoice", required = true)
    protected BfsDataType bfsAdmissionType;
    @XmlElement(name = "bfs_decision_for_discharge", namespace = "http://www.forum-datenaustausch.ch/invoice", required = true)
    protected BfsDataType bfsDecisionForDischarge;
    @XmlElement(name = "bfs_residence_after_discharge", namespace = "http://www.forum-datenaustausch.ch/invoice", required = true)
    protected BfsDataType bfsResidenceAfterDischarge;
    @XmlElement(name = "case_detail", namespace = "http://www.forum-datenaustausch.ch/invoice")
    protected List<CaseDetailType> caseDetail;
    @XmlAttribute(name = "hospitalization_date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar hospitalizationDate;
    @XmlAttribute(name = "treatment_days", required = true)
    protected Duration treatmentDays;
    @XmlAttribute(name = "hospitalization_type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String hospitalizationType;
    @XmlAttribute(name = "hospitalization_mode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String hospitalizationMode;
    @XmlAttribute(name = "class")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String clazz;
    @XmlAttribute(name = "section_major")
    protected String sectionMajor;
    @XmlAttribute(name = "has_expense_loading")
    protected Boolean hasExpenseLoading;

    /**
     * Gets the value of the admissionType property.
     * 
     * @return
     *     possible object is
     *     {@link GrouperDataType }
     *     
     */
    public GrouperDataType getAdmissionType() {
        return admissionType;
    }

    /**
     * Sets the value of the admissionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrouperDataType }
     *     
     */
    public void setAdmissionType(GrouperDataType value) {
        this.admissionType = value;
    }

    /**
     * Gets the value of the dischargeType property.
     * 
     * @return
     *     possible object is
     *     {@link GrouperDataType }
     *     
     */
    public GrouperDataType getDischargeType() {
        return dischargeType;
    }

    /**
     * Sets the value of the dischargeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrouperDataType }
     *     
     */
    public void setDischargeType(GrouperDataType value) {
        this.dischargeType = value;
    }

    /**
     * Gets the value of the providerType property.
     * 
     * @return
     *     possible object is
     *     {@link GrouperDataType }
     *     
     */
    public GrouperDataType getProviderType() {
        return providerType;
    }

    /**
     * Sets the value of the providerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrouperDataType }
     *     
     */
    public void setProviderType(GrouperDataType value) {
        this.providerType = value;
    }

    /**
     * Gets the value of the bfsResidenceBeforeAdmission property.
     * 
     * @return
     *     possible object is
     *     {@link BfsDataType }
     *     
     */
    public BfsDataType getBfsResidenceBeforeAdmission() {
        return bfsResidenceBeforeAdmission;
    }

    /**
     * Sets the value of the bfsResidenceBeforeAdmission property.
     * 
     * @param value
     *     allowed object is
     *     {@link BfsDataType }
     *     
     */
    public void setBfsResidenceBeforeAdmission(BfsDataType value) {
        this.bfsResidenceBeforeAdmission = value;
    }

    /**
     * Gets the value of the bfsAdmissionType property.
     * 
     * @return
     *     possible object is
     *     {@link BfsDataType }
     *     
     */
    public BfsDataType getBfsAdmissionType() {
        return bfsAdmissionType;
    }

    /**
     * Sets the value of the bfsAdmissionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BfsDataType }
     *     
     */
    public void setBfsAdmissionType(BfsDataType value) {
        this.bfsAdmissionType = value;
    }

    /**
     * Gets the value of the bfsDecisionForDischarge property.
     * 
     * @return
     *     possible object is
     *     {@link BfsDataType }
     *     
     */
    public BfsDataType getBfsDecisionForDischarge() {
        return bfsDecisionForDischarge;
    }

    /**
     * Sets the value of the bfsDecisionForDischarge property.
     * 
     * @param value
     *     allowed object is
     *     {@link BfsDataType }
     *     
     */
    public void setBfsDecisionForDischarge(BfsDataType value) {
        this.bfsDecisionForDischarge = value;
    }

    /**
     * Gets the value of the bfsResidenceAfterDischarge property.
     * 
     * @return
     *     possible object is
     *     {@link BfsDataType }
     *     
     */
    public BfsDataType getBfsResidenceAfterDischarge() {
        return bfsResidenceAfterDischarge;
    }

    /**
     * Sets the value of the bfsResidenceAfterDischarge property.
     * 
     * @param value
     *     allowed object is
     *     {@link BfsDataType }
     *     
     */
    public void setBfsResidenceAfterDischarge(BfsDataType value) {
        this.bfsResidenceAfterDischarge = value;
    }

    /**
     * Gets the value of the caseDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the caseDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseDetailType }
     * 
     * 
     */
    public List<CaseDetailType> getCaseDetail() {
        if (caseDetail == null) {
            caseDetail = new ArrayList<CaseDetailType>();
        }
        return this.caseDetail;
    }

    /**
     * Gets the value of the hospitalizationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHospitalizationDate() {
        return hospitalizationDate;
    }

    /**
     * Sets the value of the hospitalizationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHospitalizationDate(XMLGregorianCalendar value) {
        this.hospitalizationDate = value;
    }

    /**
     * Gets the value of the treatmentDays property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getTreatmentDays() {
        return treatmentDays;
    }

    /**
     * Sets the value of the treatmentDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setTreatmentDays(Duration value) {
        this.treatmentDays = value;
    }

    /**
     * Gets the value of the hospitalizationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHospitalizationType() {
        if (hospitalizationType == null) {
            return "regular";
        } else {
            return hospitalizationType;
        }
    }

    /**
     * Sets the value of the hospitalizationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHospitalizationType(String value) {
        this.hospitalizationType = value;
    }

    /**
     * Gets the value of the hospitalizationMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHospitalizationMode() {
        if (hospitalizationMode == null) {
            return "cantonal";
        } else {
            return hospitalizationMode;
        }
    }

    /**
     * Sets the value of the hospitalizationMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHospitalizationMode(String value) {
        this.hospitalizationMode = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        if (clazz == null) {
            return "general";
        } else {
            return clazz;
        }
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the sectionMajor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSectionMajor() {
        return sectionMajor;
    }

    /**
     * Sets the value of the sectionMajor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSectionMajor(String value) {
        this.sectionMajor = value;
    }

    /**
     * Gets the value of the hasExpenseLoading property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHasExpenseLoading() {
        if (hasExpenseLoading == null) {
            return true;
        } else {
            return hasExpenseLoading;
        }
    }

    /**
     * Sets the value of the hasExpenseLoading property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasExpenseLoading(Boolean value) {
        this.hasExpenseLoading = value;
    }

}