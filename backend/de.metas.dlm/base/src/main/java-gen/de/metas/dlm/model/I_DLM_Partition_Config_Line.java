package de.metas.dlm.model;

/**
 * Generated Interface for DLM_Partition_Config_Line
 * 
 * @author Adempiere (generated)
 */
@SuppressWarnings("javadoc")
public interface I_DLM_Partition_Config_Line
{

	/** TableName=DLM_Partition_Config_Line */
	public static final String Table_Name = "DLM_Partition_Config_Line";

	/** AD_Table_ID=540790 */
	// public static final int Table_ID = org.compiere.model.MTable.getTable_ID(Table_Name);

	// org.compiere.util.KeyNamePair Model = new org.compiere.util.KeyNamePair(Table_ID, Table_Name);

	/**
	 * AccessLevel = 7 - System - Client - Org
	 */
	// java.math.BigDecimal accessLevel = java.math.BigDecimal.valueOf(7);

	/** Load Meta Data */

	/**
	 * Get Mandant.
	 * Mandant für diese Installation.
	 *
	 * <br>
	 * Type: TableDir
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public int getAD_Client_ID();

	public org.compiere.model.I_AD_Client getAD_Client();

	/** Column definition for AD_Client_ID */
	public static final org.adempiere.model.ModelColumn<I_DLM_Partition_Config_Line, org.compiere.model.I_AD_Client> COLUMN_AD_Client_ID = new org.adempiere.model.ModelColumn<>(I_DLM_Partition_Config_Line.class, "AD_Client_ID", org.compiere.model.I_AD_Client.class);
	/** Column name AD_Client_ID */
	public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/**
	 * Set Sektion.
	 * Organisatorische Einheit des Mandanten
	 *
	 * <br>
	 * Type: TableDir
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public void setAD_Org_ID(int AD_Org_ID);

	/**
	 * Get Sektion.
	 * Organisatorische Einheit des Mandanten
	 *
	 * <br>
	 * Type: TableDir
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public int getAD_Org_ID();

	public org.compiere.model.I_AD_Org getAD_Org();

	public void setAD_Org(org.compiere.model.I_AD_Org AD_Org);

	/** Column definition for AD_Org_ID */
	public static final org.adempiere.model.ModelColumn<I_DLM_Partition_Config_Line, org.compiere.model.I_AD_Org> COLUMN_AD_Org_ID = new org.adempiere.model.ModelColumn<>(I_DLM_Partition_Config_Line.class, "AD_Org_ID", org.compiere.model.I_AD_Org.class);
	/** Column name AD_Org_ID */
	public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/**
	 * Get Erstellt.
	 * Datum, an dem dieser Eintrag erstellt wurde
	 *
	 * <br>
	 * Type: DateTime
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public java.sql.Timestamp getCreated();

	/** Column definition for Created */
	public static final org.adempiere.model.ModelColumn<I_DLM_Partition_Config_Line, Object> COLUMN_Created = new org.adempiere.model.ModelColumn<>(I_DLM_Partition_Config_Line.class, "Created", null);
	/** Column name Created */
	public static final String COLUMNNAME_Created = "Created";

	/**
	 * Get Erstellt durch.
	 * Nutzer, der diesen Eintrag erstellt hat
	 *
	 * <br>
	 * Type: Table
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public int getCreatedBy();

	/** Column definition for CreatedBy */
	public static final org.adempiere.model.ModelColumn<I_DLM_Partition_Config_Line, org.compiere.model.I_AD_User> COLUMN_CreatedBy = new org.adempiere.model.ModelColumn<>(I_DLM_Partition_Config_Line.class, "CreatedBy", org.compiere.model.I_AD_User.class);
	/** Column name CreatedBy */
	public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/**
	 * Set Beschreibung.
	 *
	 * <br>
	 * Type: Text
	 * <br>
	 * Mandatory: false
	 * <br>
	 * Virtual Column: false
	 */
	public void setDescription(java.lang.String Description);

	/**
	 * Get Beschreibung.
	 *
	 * <br>
	 * Type: Text
	 * <br>
	 * Mandatory: false
	 * <br>
	 * Virtual Column: false
	 */
	public java.lang.String getDescription();

	/** Column definition for Description */
	public static final org.adempiere.model.ModelColumn<I_DLM_Partition_Config_Line, Object> COLUMN_Description = new org.adempiere.model.ModelColumn<>(I_DLM_Partition_Config_Line.class, "Description", null);
	/** Column name Description */
	public static final String COLUMNNAME_Description = "Description";

	/**
	 * Set DLM Partitionierungskonfiguration.
	 *
	 * <br>
	 * Type: Search
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public void setDLM_Partition_Config_ID(int DLM_Partition_Config_ID);

	/**
	 * Get DLM Partitionierungskonfiguration.
	 *
	 * <br>
	 * Type: Search
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public int getDLM_Partition_Config_ID();

	public de.metas.dlm.model.I_DLM_Partition_Config getDLM_Partition_Config();

	public void setDLM_Partition_Config(de.metas.dlm.model.I_DLM_Partition_Config DLM_Partition_Config);

	/** Column definition for DLM_Partition_Config_ID */
	public static final org.adempiere.model.ModelColumn<I_DLM_Partition_Config_Line, de.metas.dlm.model.I_DLM_Partition_Config> COLUMN_DLM_Partition_Config_ID = new org.adempiere.model.ModelColumn<>(I_DLM_Partition_Config_Line.class, "DLM_Partition_Config_ID", de.metas.dlm.model.I_DLM_Partition_Config.class);
	/** Column name DLM_Partition_Config_ID */
	public static final String COLUMNNAME_DLM_Partition_Config_ID = "DLM_Partition_Config_ID";

	/**
	 * Set DLM Partitionierungskonfigzeile.
	 *
	 * <br>
	 * Type: ID
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public void setDLM_Partition_Config_Line_ID(int DLM_Partition_Config_Line_ID);

	/**
	 * Get DLM Partitionierungskonfigzeile.
	 *
	 * <br>
	 * Type: ID
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public int getDLM_Partition_Config_Line_ID();

	/** Column definition for DLM_Partition_Config_Line_ID */
	public static final org.adempiere.model.ModelColumn<I_DLM_Partition_Config_Line, Object> COLUMN_DLM_Partition_Config_Line_ID = new org.adempiere.model.ModelColumn<>(I_DLM_Partition_Config_Line.class, "DLM_Partition_Config_Line_ID", null);
	/** Column name DLM_Partition_Config_Line_ID */
	public static final String COLUMNNAME_DLM_Partition_Config_Line_ID = "DLM_Partition_Config_Line_ID";

	/**
	 * Set Referenzierende Tabelle.
	 *
	 * <br>
	 * Type: Search
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public void setDLM_Referencing_Table_ID(int DLM_Referencing_Table_ID);

	/**
	 * Get Referenzierende Tabelle.
	 *
	 * <br>
	 * Type: Search
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public int getDLM_Referencing_Table_ID();

	public org.compiere.model.I_AD_Table getDLM_Referencing_Table();

	public void setDLM_Referencing_Table(org.compiere.model.I_AD_Table DLM_Referencing_Table);

	/** Column definition for DLM_Referencing_Table_ID */
	public static final org.adempiere.model.ModelColumn<I_DLM_Partition_Config_Line, org.compiere.model.I_AD_Table> COLUMN_DLM_Referencing_Table_ID = new org.adempiere.model.ModelColumn<>(I_DLM_Partition_Config_Line.class, "DLM_Referencing_Table_ID", org.compiere.model.I_AD_Table.class);
	/** Column name DLM_Referencing_Table_ID */
	public static final String COLUMNNAME_DLM_Referencing_Table_ID = "DLM_Referencing_Table_ID";

	/**
	 * Set Aktiv.
	 * Der Eintrag ist im System aktiv
	 *
	 * <br>
	 * Type: YesNo
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public void setIsActive(boolean IsActive);

	/**
	 * Get Aktiv.
	 * Der Eintrag ist im System aktiv
	 *
	 * <br>
	 * Type: YesNo
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public boolean isActive();

	/** Column definition for IsActive */
	public static final org.adempiere.model.ModelColumn<I_DLM_Partition_Config_Line, Object> COLUMN_IsActive = new org.adempiere.model.ModelColumn<>(I_DLM_Partition_Config_Line.class, "IsActive", null);
	/** Column name IsActive */
	public static final String COLUMNNAME_IsActive = "IsActive";

	/**
	 * Set DLM aktiviert.
	 * Die Datensätze einer Tabelle mit aktiviertem DLM können vom System unterschiedlichen DLM-Levels zugeordnet werden
	 *
	 * <br>
	 * Type: YesNo
	 * <br>
	 * Mandatory: false
	 * <br>
	 * Virtual Column: true
	 * 
	 * @deprecated Please don't use it because this is a virtual column
	 */
	@Deprecated
	public void setIsDLM(boolean IsDLM);

	/**
	 * Get DLM aktiviert.
	 * Die Datensätze einer Tabelle mit aktiviertem DLM können vom System unterschiedlichen DLM-Levels zugeordnet werden
	 *
	 * <br>
	 * Type: YesNo
	 * <br>
	 * Mandatory: false
	 * <br>
	 * Virtual Column: true
	 */
	public boolean isDLM();

	/** Column definition for IsDLM */
	public static final org.adempiere.model.ModelColumn<I_DLM_Partition_Config_Line, Object> COLUMN_IsDLM = new org.adempiere.model.ModelColumn<>(I_DLM_Partition_Config_Line.class, "IsDLM", null);
	/** Column name IsDLM */
	public static final String COLUMNNAME_IsDLM = "IsDLM";

	/**
	 * Get Aktualisiert.
	 * Datum, an dem dieser Eintrag aktualisiert wurde
	 *
	 * <br>
	 * Type: DateTime
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public java.sql.Timestamp getUpdated();

	/** Column definition for Updated */
	public static final org.adempiere.model.ModelColumn<I_DLM_Partition_Config_Line, Object> COLUMN_Updated = new org.adempiere.model.ModelColumn<>(I_DLM_Partition_Config_Line.class, "Updated", null);
	/** Column name Updated */
	public static final String COLUMNNAME_Updated = "Updated";

	/**
	 * Get Aktualisiert durch.
	 * Nutzer, der diesen Eintrag aktualisiert hat
	 *
	 * <br>
	 * Type: Table
	 * <br>
	 * Mandatory: true
	 * <br>
	 * Virtual Column: false
	 */
	public int getUpdatedBy();

	/** Column definition for UpdatedBy */
	public static final org.adempiere.model.ModelColumn<I_DLM_Partition_Config_Line, org.compiere.model.I_AD_User> COLUMN_UpdatedBy = new org.adempiere.model.ModelColumn<>(I_DLM_Partition_Config_Line.class, "UpdatedBy", org.compiere.model.I_AD_User.class);
	/** Column name UpdatedBy */
	public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";
}
