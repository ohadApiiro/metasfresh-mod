package de.metas.shipper.gateway.dhl.model;


/** Generated Interface for DHL_Shipper_Config
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public interface I_DHL_Shipper_Config 
{

    /** TableName=DHL_Shipper_Config */
    public static final String Table_Name = "DHL_Shipper_Config";

    /** AD_Table_ID=541411 */
//    public static final int Table_ID = org.compiere.model.MTable.getTable_ID(Table_Name);

//    org.compiere.util.KeyNamePair Model = new org.compiere.util.KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 7 - System - Client - Org
     */
//    java.math.BigDecimal accessLevel = java.math.BigDecimal.valueOf(7);

    /** Load Meta Data */

	/**
	 * Set Kontonummer.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setAccountNumber (java.lang.String AccountNumber);

	/**
	 * Get Kontonummer.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getAccountNumber();

    /** Column definition for AccountNumber */
    public static final org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object> COLUMN_AccountNumber = new org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object>(I_DHL_Shipper_Config.class, "AccountNumber", null);
    /** Column name AccountNumber */
    public static final String COLUMNNAME_AccountNumber = "AccountNumber";

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
	 * Set Anwendungs-ID.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setapplicationID (java.lang.String applicationID);

	/**
	 * Get Anwendungs-ID.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getapplicationID();

    /** Column definition for applicationID */
    public static final org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object> COLUMN_applicationID = new org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object>(I_DHL_Shipper_Config.class, "applicationID", null);
    /** Column name applicationID */
    public static final String COLUMNNAME_applicationID = "applicationID";

	/**
	 * Set Anwendungs-Token.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setApplicationToken (java.lang.String ApplicationToken);

	/**
	 * Get Anwendungs-Token.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getApplicationToken();

    /** Column definition for ApplicationToken */
    public static final org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object> COLUMN_ApplicationToken = new org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object>(I_DHL_Shipper_Config.class, "ApplicationToken", null);
    /** Column name ApplicationToken */
    public static final String COLUMNNAME_ApplicationToken = "ApplicationToken";

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
    public static final org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object> COLUMN_Created = new org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object>(I_DHL_Shipper_Config.class, "Created", null);
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
	 * Set DHL API URL.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setdhl_api_url (java.lang.String dhl_api_url);

	/**
	 * Get DHL API URL.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getdhl_api_url();

    /** Column definition for dhl_api_url */
    public static final org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object> COLUMN_dhl_api_url = new org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object>(I_DHL_Shipper_Config.class, "dhl_api_url", null);
    /** Column name dhl_api_url */
    public static final String COLUMNNAME_dhl_api_url = "dhl_api_url";

	/**
	 * Set Dhl_LenghtUOM_ID.
	 *
	 * <br>Type: Table
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setDhl_LenghtUOM_ID (int Dhl_LenghtUOM_ID);

	/**
	 * Get Dhl_LenghtUOM_ID.
	 *
	 * <br>Type: Table
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public int getDhl_LenghtUOM_ID();

    /** Column name Dhl_LenghtUOM_ID */
    public static final String COLUMNNAME_Dhl_LenghtUOM_ID = "Dhl_LenghtUOM_ID";

	/**
	 * Set DHL Shipper Configuration.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setDHL_Shipper_Config_ID (int DHL_Shipper_Config_ID);

	/**
	 * Get DHL Shipper Configuration.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getDHL_Shipper_Config_ID();

    /** Column definition for DHL_Shipper_Config_ID */
    public static final org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object> COLUMN_DHL_Shipper_Config_ID = new org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object>(I_DHL_Shipper_Config.class, "DHL_Shipper_Config_ID", null);
    /** Column name DHL_Shipper_Config_ID */
    public static final String COLUMNNAME_DHL_Shipper_Config_ID = "DHL_Shipper_Config_ID";

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
    public static final org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object> COLUMN_IsActive = new org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object>(I_DHL_Shipper_Config.class, "IsActive", null);
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
    public static final org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, org.compiere.model.I_M_Shipper> COLUMN_M_Shipper_ID = new org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, org.compiere.model.I_M_Shipper>(I_DHL_Shipper_Config.class, "M_Shipper_ID", org.compiere.model.I_M_Shipper.class);
    /** Column name M_Shipper_ID */
    public static final String COLUMNNAME_M_Shipper_ID = "M_Shipper_ID";

	/**
	 * Set Unterschrift.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setSignature (java.lang.String Signature);

	/**
	 * Get Unterschrift.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getSignature();

    /** Column definition for Signature */
    public static final org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object> COLUMN_Signature = new org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object>(I_DHL_Shipper_Config.class, "Signature", null);
    /** Column name Signature */
    public static final String COLUMNNAME_Signature = "Signature";

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
    public static final org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object> COLUMN_Updated = new org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object>(I_DHL_Shipper_Config.class, "Updated", null);
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

	/**
	 * Set Nutzer-ID/Login.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setUserName (java.lang.String UserName);

	/**
	 * Get Nutzer-ID/Login.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getUserName();

    /** Column definition for UserName */
    public static final org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object> COLUMN_UserName = new org.adempiere.model.ModelColumn<I_DHL_Shipper_Config, Object>(I_DHL_Shipper_Config.class, "UserName", null);
    /** Column name UserName */
    public static final String COLUMNNAME_UserName = "UserName";
}
