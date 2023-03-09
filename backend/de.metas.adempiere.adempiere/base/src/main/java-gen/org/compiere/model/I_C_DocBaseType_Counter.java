package org.compiere.model;


/** Generated Interface for C_DocBaseType_Counter
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public interface I_C_DocBaseType_Counter 
{

    /** TableName=C_DocBaseType_Counter */
    public static final String Table_Name = "C_DocBaseType_Counter";

    /** AD_Table_ID=540773 */
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
    public static final org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, org.compiere.model.I_AD_Client> COLUMN_AD_Client_ID = new org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, org.compiere.model.I_AD_Client>(I_C_DocBaseType_Counter.class, "AD_Client_ID", org.compiere.model.I_AD_Client.class);
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
    public static final org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, org.compiere.model.I_AD_Org> COLUMN_AD_Org_ID = new org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, org.compiere.model.I_AD_Org>(I_C_DocBaseType_Counter.class, "AD_Org_ID", org.compiere.model.I_AD_Org.class);
    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/**
	 * Set C_DocBaseType_Counter.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setC_DocBaseType_Counter_ID (int C_DocBaseType_Counter_ID);

	/**
	 * Get C_DocBaseType_Counter.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getC_DocBaseType_Counter_ID();

    /** Column definition for C_DocBaseType_Counter_ID */
    public static final org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, Object> COLUMN_C_DocBaseType_Counter_ID = new org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, Object>(I_C_DocBaseType_Counter.class, "C_DocBaseType_Counter_ID", null);
    /** Column name C_DocBaseType_Counter_ID */
    public static final String COLUMNNAME_C_DocBaseType_Counter_ID = "C_DocBaseType_Counter_ID";

	/**
	 * Set Counter_DocBaseType.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setCounter_DocBaseType (java.lang.String Counter_DocBaseType);

	/**
	 * Get Counter_DocBaseType.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getCounter_DocBaseType();

    /** Column definition for Counter_DocBaseType */
    public static final org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, Object> COLUMN_Counter_DocBaseType = new org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, Object>(I_C_DocBaseType_Counter.class, "Counter_DocBaseType", null);
    /** Column name Counter_DocBaseType */
    public static final String COLUMNNAME_Counter_DocBaseType = "Counter_DocBaseType";

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
    public static final org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, Object> COLUMN_Created = new org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, Object>(I_C_DocBaseType_Counter.class, "Created", null);
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
    public static final org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, org.compiere.model.I_AD_User> COLUMN_CreatedBy = new org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, org.compiere.model.I_AD_User>(I_C_DocBaseType_Counter.class, "CreatedBy", org.compiere.model.I_AD_User.class);
    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/**
	 * Set Document BaseType.
	 * Logical type of document
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setDocBaseType (java.lang.String DocBaseType);

	/**
	 * Get Document BaseType.
	 * Logical type of document
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getDocBaseType();

    /** Column definition for DocBaseType */
    public static final org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, Object> COLUMN_DocBaseType = new org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, Object>(I_C_DocBaseType_Counter.class, "DocBaseType", null);
    /** Column name DocBaseType */
    public static final String COLUMNNAME_DocBaseType = "DocBaseType";

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
    public static final org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, Object> COLUMN_IsActive = new org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, Object>(I_C_DocBaseType_Counter.class, "IsActive", null);
    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

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
    public static final org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, Object> COLUMN_Updated = new org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, Object>(I_C_DocBaseType_Counter.class, "Updated", null);
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
    public static final org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, org.compiere.model.I_AD_User> COLUMN_UpdatedBy = new org.adempiere.model.ModelColumn<I_C_DocBaseType_Counter, org.compiere.model.I_AD_User>(I_C_DocBaseType_Counter.class, "UpdatedBy", org.compiere.model.I_AD_User.class);
    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";
}
