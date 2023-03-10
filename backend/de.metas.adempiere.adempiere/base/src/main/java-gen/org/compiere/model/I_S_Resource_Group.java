package org.compiere.model;

import org.adempiere.model.ModelColumn;

import javax.annotation.Nullable;

/** Generated Interface for S_Resource_Group
 *  @author metasfresh (generated) 
 */
@SuppressWarnings("unused")
public interface I_S_Resource_Group 
{

	String Table_Name = "S_Resource_Group";

//	/** AD_Table_ID=542153 */
//	int Table_ID = org.compiere.model.MTable.getTable_ID(Table_Name);


	/**
	 * Get Client.
	 * Client/Tenant for this installation.
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getAD_Client_ID();

	String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/**
	 * Set Organisation.
	 * Organisational entity within client
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setAD_Org_ID (int AD_Org_ID);

	/**
	 * Get Organisation.
	 * Organisational entity within client
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getAD_Org_ID();

	String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/**
	 * Get Created.
	 * Date this record was created
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.sql.Timestamp getCreated();

	ModelColumn<I_S_Resource_Group, Object> COLUMN_Created = new ModelColumn<>(I_S_Resource_Group.class, "Created", null);
	String COLUMNNAME_Created = "Created";

	/**
	 * Get Created By.
	 * User who created this records
	 *
	 * <br>Type: Table
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getCreatedBy();

	String COLUMNNAME_CreatedBy = "CreatedBy";

	/**
	 * Set Description.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setDescription (@Nullable java.lang.String Description);

	/**
	 * Get Description.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.lang.String getDescription();

	ModelColumn<I_S_Resource_Group, Object> COLUMN_Description = new ModelColumn<>(I_S_Resource_Group.class, "Description", null);
	String COLUMNNAME_Description = "Description";

	/**
	 * Set Duration Unit.
	 * Unit of Duration
	 *
	 * <br>Type: List
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setDurationUnit (java.lang.String DurationUnit);

	/**
	 * Get Duration Unit.
	 * Unit of Duration
	 *
	 * <br>Type: List
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.lang.String getDurationUnit();

	ModelColumn<I_S_Resource_Group, Object> COLUMN_DurationUnit = new ModelColumn<>(I_S_Resource_Group.class, "DurationUnit", null);
	String COLUMNNAME_DurationUnit = "DurationUnit";

	/**
	 * Set Active.
	 * The record is active in the system
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setIsActive (boolean IsActive);

	/**
	 * Get Active.
	 * The record is active in the system
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	boolean isActive();

	ModelColumn<I_S_Resource_Group, Object> COLUMN_IsActive = new ModelColumn<>(I_S_Resource_Group.class, "IsActive", null);
	String COLUMNNAME_IsActive = "IsActive";

	/**
	 * Set Product Category.
	 * Category of a Product
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setM_Product_Category_ID (int M_Product_Category_ID);

	/**
	 * Get Product Category.
	 * Category of a Product
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getM_Product_Category_ID();

	String COLUMNNAME_M_Product_Category_ID = "M_Product_Category_ID";

	/**
	 * Set Name.
	 *
	 * <br>Type: String
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setName (java.lang.String Name);

	/**
	 * Get Name.
	 *
	 * <br>Type: String
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.lang.String getName();

	ModelColumn<I_S_Resource_Group, Object> COLUMN_Name = new ModelColumn<>(I_S_Resource_Group.class, "Name", null);
	String COLUMNNAME_Name = "Name";

	/**
	 * Set Resource Group.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setS_Resource_Group_ID (int S_Resource_Group_ID);

	/**
	 * Get Resource Group.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getS_Resource_Group_ID();

	ModelColumn<I_S_Resource_Group, Object> COLUMN_S_Resource_Group_ID = new ModelColumn<>(I_S_Resource_Group.class, "S_Resource_Group_ID", null);
	String COLUMNNAME_S_Resource_Group_ID = "S_Resource_Group_ID";

	/**
	 * Get Updated.
	 * Date this record was updated
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.sql.Timestamp getUpdated();

	ModelColumn<I_S_Resource_Group, Object> COLUMN_Updated = new ModelColumn<>(I_S_Resource_Group.class, "Updated", null);
	String COLUMNNAME_Updated = "Updated";

	/**
	 * Get Updated By.
	 * User who updated this records
	 *
	 * <br>Type: Table
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getUpdatedBy();

	String COLUMNNAME_UpdatedBy = "UpdatedBy";
}
