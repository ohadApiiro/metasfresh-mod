package org.compiere.model;


/** Generated Interface for M_BannedManufacturer
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public interface I_M_BannedManufacturer 
{

    /** TableName=M_BannedManufacturer */
    public static final String Table_Name = "M_BannedManufacturer";

    /** AD_Table_ID=540992 */
//    public static final int Table_ID = org.compiere.model.MTable.getTable_ID(Table_Name);

//    org.compiere.util.KeyNamePair Model = new org.compiere.util.KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org
     */
//    java.math.BigDecimal accessLevel = java.math.BigDecimal.valueOf(3);

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

	public org.compiere.model.I_AD_Client getAD_Client();

    /** Column definition for AD_Client_ID */
    public static final org.adempiere.model.ModelColumn<I_M_BannedManufacturer, org.compiere.model.I_AD_Client> COLUMN_AD_Client_ID = new org.adempiere.model.ModelColumn<I_M_BannedManufacturer, org.compiere.model.I_AD_Client>(I_M_BannedManufacturer.class, "AD_Client_ID", org.compiere.model.I_AD_Client.class);
    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/**
	 * Set Sektion.
	 * Organisatorische Einheit des Mandanten
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setAD_Org_ID (int AD_Org_ID);

	/**
	 * Get Sektion.
	 * Organisatorische Einheit des Mandanten
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getAD_Org_ID();

	public org.compiere.model.I_AD_Org getAD_Org();

	public void setAD_Org(org.compiere.model.I_AD_Org AD_Org);

    /** Column definition for AD_Org_ID */
    public static final org.adempiere.model.ModelColumn<I_M_BannedManufacturer, org.compiere.model.I_AD_Org> COLUMN_AD_Org_ID = new org.adempiere.model.ModelColumn<I_M_BannedManufacturer, org.compiere.model.I_AD_Org>(I_M_BannedManufacturer.class, "AD_Org_ID", org.compiere.model.I_AD_Org.class);
    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/**
	 * Set Geschäftspartner.
	 * Bezeichnet einen Geschäftspartner
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/**
	 * Get Geschäftspartner.
	 * Bezeichnet einen Geschäftspartner
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getC_BPartner_ID();

	public org.compiere.model.I_C_BPartner getC_BPartner();

	public void setC_BPartner(org.compiere.model.I_C_BPartner C_BPartner);

    /** Column definition for C_BPartner_ID */
    public static final org.adempiere.model.ModelColumn<I_M_BannedManufacturer, org.compiere.model.I_C_BPartner> COLUMN_C_BPartner_ID = new org.adempiere.model.ModelColumn<I_M_BannedManufacturer, org.compiere.model.I_C_BPartner>(I_M_BannedManufacturer.class, "C_BPartner_ID", org.compiere.model.I_C_BPartner.class);
    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

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
    public static final org.adempiere.model.ModelColumn<I_M_BannedManufacturer, Object> COLUMN_Created = new org.adempiere.model.ModelColumn<I_M_BannedManufacturer, Object>(I_M_BannedManufacturer.class, "Created", null);
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

    /** Column definition for CreatedBy */
    public static final org.adempiere.model.ModelColumn<I_M_BannedManufacturer, org.compiere.model.I_AD_User> COLUMN_CreatedBy = new org.adempiere.model.ModelColumn<I_M_BannedManufacturer, org.compiere.model.I_AD_User>(I_M_BannedManufacturer.class, "CreatedBy", org.compiere.model.I_AD_User.class);
    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/**
	 * Set Exclusion From Sale Reason.
	 *
	 * <br>Type: String
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setExclusionFromSaleReason (java.lang.String ExclusionFromSaleReason);

	/**
	 * Get Exclusion From Sale Reason.
	 *
	 * <br>Type: String
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public java.lang.String getExclusionFromSaleReason();

    /** Column definition for ExclusionFromSaleReason */
    public static final org.adempiere.model.ModelColumn<I_M_BannedManufacturer, Object> COLUMN_ExclusionFromSaleReason = new org.adempiere.model.ModelColumn<I_M_BannedManufacturer, Object>(I_M_BannedManufacturer.class, "ExclusionFromSaleReason", null);
    /** Column name ExclusionFromSaleReason */
    public static final String COLUMNNAME_ExclusionFromSaleReason = "ExclusionFromSaleReason";

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
    public static final org.adempiere.model.ModelColumn<I_M_BannedManufacturer, Object> COLUMN_IsActive = new org.adempiere.model.ModelColumn<I_M_BannedManufacturer, Object>(I_M_BannedManufacturer.class, "IsActive", null);
    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/**
	 * Set Banned Manufacturer .
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setM_BannedManufacturer_ID (int M_BannedManufacturer_ID);

	/**
	 * Get Banned Manufacturer .
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getM_BannedManufacturer_ID();

    /** Column definition for M_BannedManufacturer_ID */
    public static final org.adempiere.model.ModelColumn<I_M_BannedManufacturer, Object> COLUMN_M_BannedManufacturer_ID = new org.adempiere.model.ModelColumn<I_M_BannedManufacturer, Object>(I_M_BannedManufacturer.class, "M_BannedManufacturer_ID", null);
    /** Column name M_BannedManufacturer_ID */
    public static final String COLUMNNAME_M_BannedManufacturer_ID = "M_BannedManufacturer_ID";

	/**
	 * Set Hersteller.
	 * Hersteller des Produktes
	 *
	 * <br>Type: Table
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setManufacturer_ID (int Manufacturer_ID);

	/**
	 * Get Hersteller.
	 * Hersteller des Produktes
	 *
	 * <br>Type: Table
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getManufacturer_ID();

	public org.compiere.model.I_C_BPartner getManufacturer();

	public void setManufacturer(org.compiere.model.I_C_BPartner Manufacturer);

    /** Column definition for Manufacturer_ID */
    public static final org.adempiere.model.ModelColumn<I_M_BannedManufacturer, org.compiere.model.I_C_BPartner> COLUMN_Manufacturer_ID = new org.adempiere.model.ModelColumn<I_M_BannedManufacturer, org.compiere.model.I_C_BPartner>(I_M_BannedManufacturer.class, "Manufacturer_ID", org.compiere.model.I_C_BPartner.class);
    /** Column name Manufacturer_ID */
    public static final String COLUMNNAME_Manufacturer_ID = "Manufacturer_ID";

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
    public static final org.adempiere.model.ModelColumn<I_M_BannedManufacturer, Object> COLUMN_Updated = new org.adempiere.model.ModelColumn<I_M_BannedManufacturer, Object>(I_M_BannedManufacturer.class, "Updated", null);
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

    /** Column definition for UpdatedBy */
    public static final org.adempiere.model.ModelColumn<I_M_BannedManufacturer, org.compiere.model.I_AD_User> COLUMN_UpdatedBy = new org.adempiere.model.ModelColumn<I_M_BannedManufacturer, org.compiere.model.I_AD_User>(I_M_BannedManufacturer.class, "UpdatedBy", org.compiere.model.I_AD_User.class);
    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";
}
