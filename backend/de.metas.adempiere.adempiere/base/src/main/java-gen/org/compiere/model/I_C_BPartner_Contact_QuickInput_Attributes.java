package org.compiere.model;

import org.adempiere.model.ModelColumn;

/** Generated Interface for C_BPartner_Contact_QuickInput_Attributes
 *  @author metasfresh (generated) 
 */
@SuppressWarnings("unused")
public interface I_C_BPartner_Contact_QuickInput_Attributes 
{

	String Table_Name = "C_BPartner_Contact_QuickInput_Attributes";

//	/** AD_Table_ID=541704 */
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
	 * Set Attribute.
	 *
	 * <br>Type: List
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setAttribute (java.lang.String Attribute);

	/**
	 * Get Attribute.
	 *
	 * <br>Type: List
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.lang.String getAttribute();

	ModelColumn<I_C_BPartner_Contact_QuickInput_Attributes, Object> COLUMN_Attribute = new ModelColumn<>(I_C_BPartner_Contact_QuickInput_Attributes.class, "Attribute", null);
	String COLUMNNAME_Attribute = "Attribute";

	/**
	 * Set Contact QuickInput Attributes.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setC_BPartner_Contact_QuickInput_Attributes_ID (int C_BPartner_Contact_QuickInput_Attributes_ID);

	/**
	 * Get Contact QuickInput Attributes.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getC_BPartner_Contact_QuickInput_Attributes_ID();

	ModelColumn<I_C_BPartner_Contact_QuickInput_Attributes, Object> COLUMN_C_BPartner_Contact_QuickInput_Attributes_ID = new ModelColumn<>(I_C_BPartner_Contact_QuickInput_Attributes.class, "C_BPartner_Contact_QuickInput_Attributes_ID", null);
	String COLUMNNAME_C_BPartner_Contact_QuickInput_Attributes_ID = "C_BPartner_Contact_QuickInput_Attributes_ID";

	/**
	 * Set Contact.
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setC_BPartner_Contact_QuickInput_ID (int C_BPartner_Contact_QuickInput_ID);

	/**
	 * Get Contact.
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getC_BPartner_Contact_QuickInput_ID();

	org.compiere.model.I_C_BPartner_Contact_QuickInput getC_BPartner_Contact_QuickInput();

	void setC_BPartner_Contact_QuickInput(org.compiere.model.I_C_BPartner_Contact_QuickInput C_BPartner_Contact_QuickInput);

	ModelColumn<I_C_BPartner_Contact_QuickInput_Attributes, org.compiere.model.I_C_BPartner_Contact_QuickInput> COLUMN_C_BPartner_Contact_QuickInput_ID = new ModelColumn<>(I_C_BPartner_Contact_QuickInput_Attributes.class, "C_BPartner_Contact_QuickInput_ID", org.compiere.model.I_C_BPartner_Contact_QuickInput.class);
	String COLUMNNAME_C_BPartner_Contact_QuickInput_ID = "C_BPartner_Contact_QuickInput_ID";

	/**
	 * Get Created.
	 * Date this record was created
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.sql.Timestamp getCreated();

	ModelColumn<I_C_BPartner_Contact_QuickInput_Attributes, Object> COLUMN_Created = new ModelColumn<>(I_C_BPartner_Contact_QuickInput_Attributes.class, "Created", null);
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

	ModelColumn<I_C_BPartner_Contact_QuickInput_Attributes, Object> COLUMN_IsActive = new ModelColumn<>(I_C_BPartner_Contact_QuickInput_Attributes.class, "IsActive", null);
	String COLUMNNAME_IsActive = "IsActive";

	/**
	 * Get Updated.
	 * Date this record was updated
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.sql.Timestamp getUpdated();

	ModelColumn<I_C_BPartner_Contact_QuickInput_Attributes, Object> COLUMN_Updated = new ModelColumn<>(I_C_BPartner_Contact_QuickInput_Attributes.class, "Updated", null);
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
