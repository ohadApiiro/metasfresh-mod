package de.metas.vertical.creditscore.creditpass.model;


/** Generated Interface for CS_Creditpass_BP_Group
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public interface I_CS_Creditpass_BP_Group 
{

    /** TableName=CS_Creditpass_BP_Group */
	String Table_Name = "CS_Creditpass_BP_Group";

    /** AD_Table_ID=541198 */
//    public static final int Table_ID = org.compiere.model.MTable.getTable_ID(Table_Name);

//    org.compiere.util.KeyNamePair Model = new org.compiere.util.KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org
     */
//    java.math.BigDecimal accessLevel = java.math.BigDecimal.valueOf(3);

    /** Load Meta Data */
    /** Column definition for AD_Client_ID */
	org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, org.compiere.model.I_AD_Client> COLUMN_AD_Client_ID = new org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, org.compiere.model.I_AD_Client>(I_CS_Creditpass_BP_Group.class, "AD_Client_ID", org.compiere.model.I_AD_Client.class);
    /** Column name AD_Client_ID */
	String COLUMNNAME_AD_Client_ID = "AD_Client_ID";
    /** Column definition for AD_Org_ID */
	org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, org.compiere.model.I_AD_Org> COLUMN_AD_Org_ID = new org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, org.compiere.model.I_AD_Org>(I_CS_Creditpass_BP_Group.class, "AD_Org_ID", org.compiere.model.I_AD_Org.class);
    /** Column name AD_Org_ID */
	String COLUMNNAME_AD_Org_ID = "AD_Org_ID";
    /** Column definition for C_BP_Group_ID */
	org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, org.compiere.model.I_C_BP_Group> COLUMN_C_BP_Group_ID = new org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, org.compiere.model.I_C_BP_Group>(I_CS_Creditpass_BP_Group.class, "C_BP_Group_ID", org.compiere.model.I_C_BP_Group.class);
    /** Column name C_BP_Group_ID */
	String COLUMNNAME_C_BP_Group_ID = "C_BP_Group_ID";
    /** Column definition for Created */
	org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, Object> COLUMN_Created = new org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, Object>(I_CS_Creditpass_BP_Group.class, "Created", null);
    /** Column name Created */
	String COLUMNNAME_Created = "Created";
    /** Column definition for CreatedBy */
	org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, org.compiere.model.I_AD_User> COLUMN_CreatedBy = new org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, org.compiere.model.I_AD_User>(I_CS_Creditpass_BP_Group.class, "CreatedBy", org.compiere.model.I_AD_User.class);
    /** Column name CreatedBy */
	String COLUMNNAME_CreatedBy = "CreatedBy";
    /** Column definition for CS_Creditpass_BP_Group_ID */
	org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, Object> COLUMN_CS_Creditpass_BP_Group_ID = new org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, Object>(I_CS_Creditpass_BP_Group.class, "CS_Creditpass_BP_Group_ID", null);
    /** Column name CS_Creditpass_BP_Group_ID */
	String COLUMNNAME_CS_Creditpass_BP_Group_ID = "CS_Creditpass_BP_Group_ID";
    /** Column definition for CS_Creditpass_Config_ID */
	org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, de.metas.vertical.creditscore.creditpass.model.I_CS_Creditpass_Config> COLUMN_CS_Creditpass_Config_ID = new org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, de.metas.vertical.creditscore.creditpass.model.I_CS_Creditpass_Config>(I_CS_Creditpass_BP_Group.class, "CS_Creditpass_Config_ID", de.metas.vertical.creditscore.creditpass.model.I_CS_Creditpass_Config.class);
    /** Column name CS_Creditpass_Config_ID */
	String COLUMNNAME_CS_Creditpass_Config_ID = "CS_Creditpass_Config_ID";
    /** Column definition for IsActive */
	org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, Object> COLUMN_IsActive = new org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, Object>(I_CS_Creditpass_BP_Group.class, "IsActive", null);
    /** Column name IsActive */
	String COLUMNNAME_IsActive = "IsActive";
    /** Column definition for Updated */
	org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, Object> COLUMN_Updated = new org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, Object>(I_CS_Creditpass_BP_Group.class, "Updated", null);
    /** Column name Updated */
	String COLUMNNAME_Updated = "Updated";
    /** Column definition for UpdatedBy */
	org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, org.compiere.model.I_AD_User> COLUMN_UpdatedBy = new org.adempiere.model.ModelColumn<I_CS_Creditpass_BP_Group, org.compiere.model.I_AD_User>(I_CS_Creditpass_BP_Group.class, "UpdatedBy", org.compiere.model.I_AD_User.class);
    /** Column name UpdatedBy */
	String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/**
	 * Get Mandant.
	 * Mandant für diese Installation.
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getAD_Client_ID();

	org.compiere.model.I_AD_Client getAD_Client();

	/**
	 * Get Sektion.
	 * Organisatorische Einheit des Mandanten
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getAD_Org_ID();

	/**
	 * Set Sektion.
	 * Organisatorische Einheit des Mandanten
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setAD_Org_ID(int AD_Org_ID);

	org.compiere.model.I_AD_Org getAD_Org();

	void setAD_Org(org.compiere.model.I_AD_Org AD_Org);

	/**
	 * Get Geschäftspartnergruppe.
	 * Geschäftspartnergruppe
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getC_BP_Group_ID();

	/**
	 * Set Geschäftspartnergruppe.
	 * Geschäftspartnergruppe
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setC_BP_Group_ID(int C_BP_Group_ID);

	org.compiere.model.I_C_BP_Group getC_BP_Group();

	void setC_BP_Group(org.compiere.model.I_C_BP_Group C_BP_Group);

	/**
	 * Get Erstellt.
	 * Datum, an dem dieser Eintrag erstellt wurde
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.sql.Timestamp getCreated();

	/**
	 * Get Erstellt durch.
	 * Nutzer, der diesen Eintrag erstellt hat
	 *
	 * <br>Type: Table
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getCreatedBy();

	/**
	 * Get CS Creditpass business partner group.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getCS_Creditpass_BP_Group_ID();

	/**
	 * Set CS Creditpass business partner group.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setCS_Creditpass_BP_Group_ID(int CS_Creditpass_BP_Group_ID);

	/**
	 * Get Creditpass Einstellung.
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getCS_Creditpass_Config_ID();

	/**
	 * Set Creditpass Einstellung.
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setCS_Creditpass_Config_ID(int CS_Creditpass_Config_ID);

	de.metas.vertical.creditscore.creditpass.model.I_CS_Creditpass_Config getCS_Creditpass_Config();

	void setCS_Creditpass_Config(de.metas.vertical.creditscore.creditpass.model.I_CS_Creditpass_Config CS_Creditpass_Config);

	/**
	 * Set Aktiv.
	 * Der Eintrag ist im System aktiv
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setIsActive(boolean IsActive);

	/**
	 * Get Aktiv.
	 * Der Eintrag ist im System aktiv
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	boolean isActive();

	/**
	 * Get Aktualisiert.
	 * Datum, an dem dieser Eintrag aktualisiert wurde
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.sql.Timestamp getUpdated();

	/**
	 * Get Aktualisiert durch.
	 * Nutzer, der diesen Eintrag aktualisiert hat
	 *
	 * <br>Type: Table
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getUpdatedBy();
}
