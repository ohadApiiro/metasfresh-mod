package de.metas.shipper.gateway.dpd.model;


/** Generated Interface for DPD_StoreOrder
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public interface I_DPD_StoreOrder 
{

    /** TableName=DPD_StoreOrder */
    public static final String Table_Name = "DPD_StoreOrder";

    /** AD_Table_ID=541432 */
//    public static final int Table_ID = org.compiere.model.MTable.getTable_ID(Table_Name);

//    org.compiere.util.KeyNamePair Model = new org.compiere.util.KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 7 - System - Client - Org
     */
//    java.math.BigDecimal accessLevel = java.math.BigDecimal.valueOf(7);

    /** Load Meta Data */

	/**
	 * Get Mandant.
	 * Mandant für diese Installation.
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getAD_Client_ID();

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/**
	 * Set Sektion.
	 * Organisatorische Einheit des Mandanten
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setAD_Org_ID (int AD_Org_ID);

	/**
	 * Get Sektion.
	 * Organisatorische Einheit des Mandanten
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getAD_Org_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/**
	 * Set Luftfrachtbrief.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setawb (java.lang.String awb);

	/**
	 * Get Luftfrachtbrief.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getawb();

    /** Column definition for awb */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_awb = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "awb", null);
    /** Column name awb */
    public static final String COLUMNNAME_awb = "awb";

	/**
	 * Set Geschäftspartner.
	 * Bezeichnet einen Geschäftspartner
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/**
	 * Get Geschäftspartner.
	 * Bezeichnet einen Geschäftspartner
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public int getC_BPartner_ID();

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/**
	 * Set Standort.
	 * Identifiziert die (Liefer-) Adresse des Geschäftspartners
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setC_BPartner_Location_ID (int C_BPartner_Location_ID);

	/**
	 * Get Standort.
	 * Identifiziert die (Liefer-) Adresse des Geschäftspartners
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public int getC_BPartner_Location_ID();

    /** Column name C_BPartner_Location_ID */
    public static final String COLUMNNAME_C_BPartner_Location_ID = "C_BPartner_Location_ID";

	/**
	 * Get Erstellt.
	 * Datum, an dem dieser Eintrag erstellt wurde
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public java.sql.Timestamp getCreated();

    /** Column definition for Created */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_Created = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "Created", null);
    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/**
	 * Get Erstellt durch.
	 * Nutzer, der diesen Eintrag erstellt hat
	 *
	 * <br>Type: Table
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getCreatedBy();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/**
	 * Set Kundenreferenz.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setCustomerReference (java.lang.String CustomerReference);

	/**
	 * Get Kundenreferenz.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getCustomerReference();

    /** Column definition for CustomerReference */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_CustomerReference = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "CustomerReference", null);
    /** Column name CustomerReference */
    public static final String COLUMNNAME_CustomerReference = "CustomerReference";

	/**
	 * Set DPD Auftragsart.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setDpdOrderType (java.lang.String DpdOrderType);

	/**
	 * Get DPD Auftragsart.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getDpdOrderType();

    /** Column definition for DpdOrderType */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_DpdOrderType = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "DpdOrderType", null);
    /** Column name DpdOrderType */
    public static final String COLUMNNAME_DpdOrderType = "DpdOrderType";

	/**
	 * Set DPD Produkt.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setDpdProduct (java.lang.String DpdProduct);

	/**
	 * Get DPD Produkt.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getDpdProduct();

    /** Column definition for DpdProduct */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_DpdProduct = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "DpdProduct", null);
    /** Column name DpdProduct */
    public static final String COLUMNNAME_DpdProduct = "DpdProduct";

	/**
	 * Set DPD StoreOrder.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setDPD_StoreOrder_ID (int DPD_StoreOrder_ID);

	/**
	 * Get DPD StoreOrder.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getDPD_StoreOrder_ID();

    /** Column definition for DPD_StoreOrder_ID */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_DPD_StoreOrder_ID = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "DPD_StoreOrder_ID", null);
    /** Column name DPD_StoreOrder_ID */
    public static final String COLUMNNAME_DPD_StoreOrder_ID = "DPD_StoreOrder_ID";

	/**
	 * Set Aktiv.
	 * Der Eintrag ist im System aktiv
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setIsActive (boolean IsActive);

	/**
	 * Get Aktiv.
	 * Der Eintrag ist im System aktiv
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public boolean isActive();

    /** Column definition for IsActive */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_IsActive = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "IsActive", null);
    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/**
	 * Set Lieferweg.
	 * Methode oder Art der Warenlieferung
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setM_Shipper_ID (int M_Shipper_ID);

	/**
	 * Get Lieferweg.
	 * Methode oder Art der Warenlieferung
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public int getM_Shipper_ID();

	public org.compiere.model.I_M_Shipper getM_Shipper();

	public void setM_Shipper(org.compiere.model.I_M_Shipper M_Shipper);

    /** Column definition for M_Shipper_ID */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, org.compiere.model.I_M_Shipper> COLUMN_M_Shipper_ID = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, org.compiere.model.I_M_Shipper>(I_DPD_StoreOrder.class, "M_Shipper_ID", org.compiere.model.I_M_Shipper.class);
    /** Column name M_Shipper_ID */
    public static final String COLUMNNAME_M_Shipper_ID = "M_Shipper_ID";

	/**
	 * Set Transport Auftrag.
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setM_ShipperTransportation_ID (int M_ShipperTransportation_ID);

	/**
	 * Get Transport Auftrag.
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public int getM_ShipperTransportation_ID();

    /** Column definition for M_ShipperTransportation_ID */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_M_ShipperTransportation_ID = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "M_ShipperTransportation_ID", null);
    /** Column name M_ShipperTransportation_ID */
    public static final String COLUMNNAME_M_ShipperTransportation_ID = "M_ShipperTransportation_ID";

	/**
	 * Set Benachrichtigungsart.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setNotificationChannel (java.lang.String NotificationChannel);

	/**
	 * Get Benachrichtigungsart.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getNotificationChannel();

    /** Column definition for NotificationChannel */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_NotificationChannel = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "NotificationChannel", null);
    /** Column name NotificationChannel */
    public static final String COLUMNNAME_NotificationChannel = "NotificationChannel";

	/**
	 * Set Papierformat.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setPaperFormat (java.lang.String PaperFormat);

	/**
	 * Get Papierformat.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getPaperFormat();

    /** Column definition for PaperFormat */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_PaperFormat = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "PaperFormat", null);
    /** Column name PaperFormat */
    public static final String COLUMNNAME_PaperFormat = "PaperFormat";

	/**
	 * Set Paketscheindaten PDF.
	 *
	 * <br>Type: Binary
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setPdfLabelData (byte[] PdfLabelData);

	/**
	 * Get Paketscheindaten PDF.
	 *
	 * <br>Type: Binary
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public byte[] getPdfLabelData();

    /** Column definition for PdfLabelData */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_PdfLabelData = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "PdfLabelData", null);
    /** Column name PdfLabelData */
    public static final String COLUMNNAME_PdfLabelData = "PdfLabelData";

	/**
	 * Set Datum der Abholung.
	 *
	 * <br>Type: Date
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setPickupDate (java.sql.Timestamp PickupDate);

	/**
	 * Get Datum der Abholung.
	 *
	 * <br>Type: Date
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public java.sql.Timestamp getPickupDate();

    /** Column definition for PickupDate */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_PickupDate = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "PickupDate", null);
    /** Column name PickupDate */
    public static final String COLUMNNAME_PickupDate = "PickupDate";

	/**
	 * Set Tag der Abholung.
	 *
	 * <br>Type: Integer
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setPickupDay (int PickupDay);

	/**
	 * Get Tag der Abholung.
	 *
	 * <br>Type: Integer
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getPickupDay();

    /** Column definition for PickupDay */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_PickupDay = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "PickupDay", null);
    /** Column name PickupDay */
    public static final String COLUMNNAME_PickupDay = "PickupDay";

	/**
	 * Set Abhoung Uhrzeit ab.
	 *
	 * <br>Type: Time
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setPickupTimeFrom (java.sql.Timestamp PickupTimeFrom);

	/**
	 * Get Abhoung Uhrzeit ab.
	 *
	 * <br>Type: Time
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public java.sql.Timestamp getPickupTimeFrom();

    /** Column definition for PickupTimeFrom */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_PickupTimeFrom = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "PickupTimeFrom", null);
    /** Column name PickupTimeFrom */
    public static final String COLUMNNAME_PickupTimeFrom = "PickupTimeFrom";

	/**
	 * Set Abholung Uhrzeit bis.
	 *
	 * <br>Type: Time
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setPickupTimeTo (java.sql.Timestamp PickupTimeTo);

	/**
	 * Get Abholung Uhrzeit bis.
	 *
	 * <br>Type: Time
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public java.sql.Timestamp getPickupTimeTo();

    /** Column definition for PickupTimeTo */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_PickupTimeTo = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "PickupTimeTo", null);
    /** Column name PickupTimeTo */
    public static final String COLUMNNAME_PickupTimeTo = "PickupTimeTo";

	/**
	 * Set Sprache Paketschein.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setPrinterLanguage (java.lang.String PrinterLanguage);

	/**
	 * Get Sprache Paketschein.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getPrinterLanguage();

    /** Column definition for PrinterLanguage */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_PrinterLanguage = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "PrinterLanguage", null);
    /** Column name PrinterLanguage */
    public static final String COLUMNNAME_PrinterLanguage = "PrinterLanguage";

	/**
	 * Set Ort Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setRecipientCity (java.lang.String RecipientCity);

	/**
	 * Get Ort Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getRecipientCity();

    /** Column definition for RecipientCity */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_RecipientCity = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "RecipientCity", null);
    /** Column name RecipientCity */
    public static final String COLUMNNAME_RecipientCity = "RecipientCity";

	/**
	 * Set Land Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setRecipientCountry (java.lang.String RecipientCountry);

	/**
	 * Get Land Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getRecipientCountry();

    /** Column definition for RecipientCountry */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_RecipientCountry = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "RecipientCountry", null);
    /** Column name RecipientCountry */
    public static final String COLUMNNAME_RecipientCountry = "RecipientCountry";

	/**
	 * Set E-Mail-Adresse Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setRecipientEmailAddress (java.lang.String RecipientEmailAddress);

	/**
	 * Get E-Mail-Adresse Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getRecipientEmailAddress();

    /** Column definition for RecipientEmailAddress */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_RecipientEmailAddress = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "RecipientEmailAddress", null);
    /** Column name RecipientEmailAddress */
    public static final String COLUMNNAME_RecipientEmailAddress = "RecipientEmailAddress";

	/**
	 * Set Haus-Nr. Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setRecipientHouseNo (java.lang.String RecipientHouseNo);

	/**
	 * Get Haus-Nr. Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getRecipientHouseNo();

    /** Column definition for RecipientHouseNo */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_RecipientHouseNo = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "RecipientHouseNo", null);
    /** Column name RecipientHouseNo */
    public static final String COLUMNNAME_RecipientHouseNo = "RecipientHouseNo";

	/**
	 * Set Name 1 Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setRecipientName1 (java.lang.String RecipientName1);

	/**
	 * Get Name 1 Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getRecipientName1();

    /** Column definition for RecipientName1 */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_RecipientName1 = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "RecipientName1", null);
    /** Column name RecipientName1 */
    public static final String COLUMNNAME_RecipientName1 = "RecipientName1";

	/**
	 * Set Name 2 Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setRecipientName2 (java.lang.String RecipientName2);

	/**
	 * Get Name 2 Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getRecipientName2();

    /** Column definition for RecipientName2 */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_RecipientName2 = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "RecipientName2", null);
    /** Column name RecipientName2 */
    public static final String COLUMNNAME_RecipientName2 = "RecipientName2";

	/**
	 * Set Telefon Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setRecipientPhone (java.lang.String RecipientPhone);

	/**
	 * Get Telefon Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getRecipientPhone();

    /** Column definition for RecipientPhone */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_RecipientPhone = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "RecipientPhone", null);
    /** Column name RecipientPhone */
    public static final String COLUMNNAME_RecipientPhone = "RecipientPhone";

	/**
	 * Set Straße Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setRecipientStreet (java.lang.String RecipientStreet);

	/**
	 * Get Straße Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getRecipientStreet();

    /** Column definition for RecipientStreet */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_RecipientStreet = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "RecipientStreet", null);
    /** Column name RecipientStreet */
    public static final String COLUMNNAME_RecipientStreet = "RecipientStreet";

	/**
	 * Set PLZ Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setRecipientZipCode (java.lang.String RecipientZipCode);

	/**
	 * Get PLZ Empfänger.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getRecipientZipCode();

    /** Column definition for RecipientZipCode */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_RecipientZipCode = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "RecipientZipCode", null);
    /** Column name RecipientZipCode */
    public static final String COLUMNNAME_RecipientZipCode = "RecipientZipCode";

	/**
	 * Set Ort Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setSenderCity (java.lang.String SenderCity);

	/**
	 * Get Ort Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getSenderCity();

    /** Column definition for SenderCity */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_SenderCity = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "SenderCity", null);
    /** Column name SenderCity */
    public static final String COLUMNNAME_SenderCity = "SenderCity";

	/**
	 * Set Land Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setSenderCountry (java.lang.String SenderCountry);

	/**
	 * Get Land Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getSenderCountry();

    /** Column definition for SenderCountry */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_SenderCountry = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "SenderCountry", null);
    /** Column name SenderCountry */
    public static final String COLUMNNAME_SenderCountry = "SenderCountry";

	/**
	 * Set Haus-Nr. Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setSenderHouseNo (java.lang.String SenderHouseNo);

	/**
	 * Get Haus-Nr. Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getSenderHouseNo();

    /** Column definition for SenderHouseNo */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_SenderHouseNo = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "SenderHouseNo", null);
    /** Column name SenderHouseNo */
    public static final String COLUMNNAME_SenderHouseNo = "SenderHouseNo";

	/**
	 * Set Name 1 Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setSenderName1 (java.lang.String SenderName1);

	/**
	 * Get Name 1 Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getSenderName1();

    /** Column definition for SenderName1 */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_SenderName1 = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "SenderName1", null);
    /** Column name SenderName1 */
    public static final String COLUMNNAME_SenderName1 = "SenderName1";

	/**
	 * Set Name 2 Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setSenderName2 (java.lang.String SenderName2);

	/**
	 * Get Name 2 Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getSenderName2();

    /** Column definition for SenderName2 */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_SenderName2 = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "SenderName2", null);
    /** Column name SenderName2 */
    public static final String COLUMNNAME_SenderName2 = "SenderName2";

	/**
	 * Set Straße Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setSenderStreet (java.lang.String SenderStreet);

	/**
	 * Get Straße Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getSenderStreet();

    /** Column definition for SenderStreet */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_SenderStreet = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "SenderStreet", null);
    /** Column name SenderStreet */
    public static final String COLUMNNAME_SenderStreet = "SenderStreet";

	/**
	 * Set PLZ Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setSenderZipCode (java.lang.String SenderZipCode);

	/**
	 * Get PLZ Absender.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getSenderZipCode();

    /** Column definition for SenderZipCode */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_SenderZipCode = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "SenderZipCode", null);
    /** Column name SenderZipCode */
    public static final String COLUMNNAME_SenderZipCode = "SenderZipCode";

	/**
	 * Set Versandlager.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setSendingDepot (java.lang.String SendingDepot);

	/**
	 * Get Versandlager.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getSendingDepot();

    /** Column definition for SendingDepot */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_SendingDepot = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "SendingDepot", null);
    /** Column name SendingDepot */
    public static final String COLUMNNAME_SendingDepot = "SendingDepot";

	/**
	 * Set Nachverfolgungs-URL.
	 * URL des Spediteurs um Sendungen zu verfolgen
	 *
	 * <br>Type: URL
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setTrackingURL (java.lang.String TrackingURL);

	/**
	 * Get Nachverfolgungs-URL.
	 * URL des Spediteurs um Sendungen zu verfolgen
	 *
	 * <br>Type: URL
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getTrackingURL();

    /** Column definition for TrackingURL */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_TrackingURL = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "TrackingURL", null);
    /** Column name TrackingURL */
    public static final String COLUMNNAME_TrackingURL = "TrackingURL";

	/**
	 * Get Aktualisiert.
	 * Datum, an dem dieser Eintrag aktualisiert wurde
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public java.sql.Timestamp getUpdated();

    /** Column definition for Updated */
    public static final org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object> COLUMN_Updated = new org.adempiere.model.ModelColumn<I_DPD_StoreOrder, Object>(I_DPD_StoreOrder.class, "Updated", null);
    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/**
	 * Get Aktualisiert durch.
	 * Nutzer, der diesen Eintrag aktualisiert hat
	 *
	 * <br>Type: Table
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getUpdatedBy();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";
}
