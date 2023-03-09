package de.metas.rfq.model;


/** Generated Interface for C_RfQ_TopicSubscriberOnly
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public interface I_C_RfQ_TopicSubscriberOnly 
{

    /** TableName=C_RfQ_TopicSubscriberOnly */
    public static final String Table_Name = "C_RfQ_TopicSubscriberOnly";

    /** AD_Table_ID=747 */
//    public static final int Table_ID = org.compiere.model.MTable.getTable_ID(Table_Name);

//    org.compiere.util.KeyNamePair Model = new org.compiere.util.KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 2 - Client
     */
//    java.math.BigDecimal accessLevel = java.math.BigDecimal.valueOf(2);

    /** Load Meta Data */

	/**
	 * Get Mandant.
	 * Client/Tenant for this installation.
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getAD_Client_ID();

	public org.compiere.model.I_AD_Client getAD_Client();

    /** Column definition for AD_Client_ID */
    public static final org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, org.compiere.model.I_AD_Client> COLUMN_AD_Client_ID = new org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, org.compiere.model.I_AD_Client>(I_C_RfQ_TopicSubscriberOnly.class, "AD_Client_ID", org.compiere.model.I_AD_Client.class);
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
    public static final org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, org.compiere.model.I_AD_Org> COLUMN_AD_Org_ID = new org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, org.compiere.model.I_AD_Org>(I_C_RfQ_TopicSubscriberOnly.class, "AD_Org_ID", org.compiere.model.I_AD_Org.class);
    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/**
	 * Set RfQ Subscriber.
	 * Request for Quotation Topic Subscriber
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setC_RfQ_TopicSubscriber_ID (int C_RfQ_TopicSubscriber_ID);

	/**
	 * Get RfQ Subscriber.
	 * Request for Quotation Topic Subscriber
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getC_RfQ_TopicSubscriber_ID();

	public de.metas.rfq.model.I_C_RfQ_TopicSubscriber getC_RfQ_TopicSubscriber();

	public void setC_RfQ_TopicSubscriber(de.metas.rfq.model.I_C_RfQ_TopicSubscriber C_RfQ_TopicSubscriber);

    /** Column definition for C_RfQ_TopicSubscriber_ID */
    public static final org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, de.metas.rfq.model.I_C_RfQ_TopicSubscriber> COLUMN_C_RfQ_TopicSubscriber_ID = new org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, de.metas.rfq.model.I_C_RfQ_TopicSubscriber>(I_C_RfQ_TopicSubscriberOnly.class, "C_RfQ_TopicSubscriber_ID", de.metas.rfq.model.I_C_RfQ_TopicSubscriber.class);
    /** Column name C_RfQ_TopicSubscriber_ID */
    public static final String COLUMNNAME_C_RfQ_TopicSubscriber_ID = "C_RfQ_TopicSubscriber_ID";

	/**
	 * Set RfQ Topic Subscriber Restriction.
	 * Include Subscriber only for certain products or product categories
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setC_RfQ_TopicSubscriberOnly_ID (int C_RfQ_TopicSubscriberOnly_ID);

	/**
	 * Get RfQ Topic Subscriber Restriction.
	 * Include Subscriber only for certain products or product categories
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getC_RfQ_TopicSubscriberOnly_ID();

    /** Column definition for C_RfQ_TopicSubscriberOnly_ID */
    public static final org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, Object> COLUMN_C_RfQ_TopicSubscriberOnly_ID = new org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, Object>(I_C_RfQ_TopicSubscriberOnly.class, "C_RfQ_TopicSubscriberOnly_ID", null);
    /** Column name C_RfQ_TopicSubscriberOnly_ID */
    public static final String COLUMNNAME_C_RfQ_TopicSubscriberOnly_ID = "C_RfQ_TopicSubscriberOnly_ID";

	/**
	 * Get Erstellt.
	 * Date this record was created
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public java.sql.Timestamp getCreated();

    /** Column definition for Created */
    public static final org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, Object> COLUMN_Created = new org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, Object>(I_C_RfQ_TopicSubscriberOnly.class, "Created", null);
    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/**
	 * Get Erstellt durch.
	 * User who created this records
	 *
	 * <br>Type: Table
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getCreatedBy();

    /** Column definition for CreatedBy */
    public static final org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, org.compiere.model.I_AD_User> COLUMN_CreatedBy = new org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, org.compiere.model.I_AD_User>(I_C_RfQ_TopicSubscriberOnly.class, "CreatedBy", org.compiere.model.I_AD_User.class);
    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/**
	 * Set Beschreibung.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setDescription (java.lang.String Description);

	/**
	 * Get Beschreibung.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public java.lang.String getDescription();

    /** Column definition for Description */
    public static final org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, Object> COLUMN_Description = new org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, Object>(I_C_RfQ_TopicSubscriberOnly.class, "Description", null);
    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/**
	 * Set Aktiv.
	 * The record is active in the system
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setIsActive (boolean IsActive);

	/**
	 * Get Aktiv.
	 * The record is active in the system
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public boolean isActive();

    /** Column definition for IsActive */
    public static final org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, Object> COLUMN_IsActive = new org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, Object>(I_C_RfQ_TopicSubscriberOnly.class, "IsActive", null);
    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/**
	 * Set Produkt-Kategorie.
	 * Category of a Product
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setM_Product_Category_ID (int M_Product_Category_ID);

	/**
	 * Get Produkt-Kategorie.
	 * Category of a Product
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public int getM_Product_Category_ID();

	public org.compiere.model.I_M_Product_Category getM_Product_Category();

	public void setM_Product_Category(org.compiere.model.I_M_Product_Category M_Product_Category);

    /** Column definition for M_Product_Category_ID */
    public static final org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, org.compiere.model.I_M_Product_Category> COLUMN_M_Product_Category_ID = new org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, org.compiere.model.I_M_Product_Category>(I_C_RfQ_TopicSubscriberOnly.class, "M_Product_Category_ID", org.compiere.model.I_M_Product_Category.class);
    /** Column name M_Product_Category_ID */
    public static final String COLUMNNAME_M_Product_Category_ID = "M_Product_Category_ID";

	/**
	 * Set Produkt.
	 * Produkt, Leistung, Artikel
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public void setM_Product_ID (int M_Product_ID);

	/**
	 * Get Produkt.
	 * Produkt, Leistung, Artikel
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	public int getM_Product_ID();

	public org.compiere.model.I_M_Product getM_Product();

	public void setM_Product(org.compiere.model.I_M_Product M_Product);

    /** Column definition for M_Product_ID */
    public static final org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, org.compiere.model.I_M_Product> COLUMN_M_Product_ID = new org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, org.compiere.model.I_M_Product>(I_C_RfQ_TopicSubscriberOnly.class, "M_Product_ID", org.compiere.model.I_M_Product.class);
    /** Column name M_Product_ID */
    public static final String COLUMNNAME_M_Product_ID = "M_Product_ID";

	/**
	 * Get Aktualisiert.
	 * Date this record was updated
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public java.sql.Timestamp getUpdated();

    /** Column definition for Updated */
    public static final org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, Object> COLUMN_Updated = new org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, Object>(I_C_RfQ_TopicSubscriberOnly.class, "Updated", null);
    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/**
	 * Get Aktualisiert durch.
	 * User who updated this records
	 *
	 * <br>Type: Table
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getUpdatedBy();

    /** Column definition for UpdatedBy */
    public static final org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, org.compiere.model.I_AD_User> COLUMN_UpdatedBy = new org.adempiere.model.ModelColumn<I_C_RfQ_TopicSubscriberOnly, org.compiere.model.I_AD_User>(I_C_RfQ_TopicSubscriberOnly.class, "UpdatedBy", org.compiere.model.I_AD_User.class);
    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";
}
