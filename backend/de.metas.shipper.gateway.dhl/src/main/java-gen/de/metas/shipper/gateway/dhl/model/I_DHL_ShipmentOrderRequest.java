package de.metas.shipper.gateway.dhl.model;


/** Generated Interface for DHL_ShipmentOrderRequest
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public interface I_DHL_ShipmentOrderRequest 
{

    /** TableName=DHL_ShipmentOrderRequest */
    public static final String Table_Name = "DHL_ShipmentOrderRequest";

    /** AD_Table_ID=541420 */
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
	 * Get Erstellt.
	 * Datum, an dem dieser Eintrag erstellt wurde
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public java.sql.Timestamp getCreated();

    /** Column definition for Created */
    public static final org.adempiere.model.ModelColumn<I_DHL_ShipmentOrderRequest, Object> COLUMN_Created = new org.adempiere.model.ModelColumn<I_DHL_ShipmentOrderRequest, Object>(I_DHL_ShipmentOrderRequest.class, "Created", null);
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
	 * Set DHL Shipment Order Request.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public void setDHL_ShipmentOrderRequest_ID (int DHL_ShipmentOrderRequest_ID);

	/**
	 * Get DHL Shipment Order Request.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	public int getDHL_ShipmentOrderRequest_ID();

    /** Column definition for DHL_ShipmentOrderRequest_ID */
    public static final org.adempiere.model.ModelColumn<I_DHL_ShipmentOrderRequest, Object> COLUMN_DHL_ShipmentOrderRequest_ID = new org.adempiere.model.ModelColumn<I_DHL_ShipmentOrderRequest, Object>(I_DHL_ShipmentOrderRequest.class, "DHL_ShipmentOrderRequest_ID", null);
    /** Column name DHL_ShipmentOrderRequest_ID */
    public static final String COLUMNNAME_DHL_ShipmentOrderRequest_ID = "DHL_ShipmentOrderRequest_ID";

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
    public static final org.adempiere.model.ModelColumn<I_DHL_ShipmentOrderRequest, Object> COLUMN_IsActive = new org.adempiere.model.ModelColumn<I_DHL_ShipmentOrderRequest, Object>(I_DHL_ShipmentOrderRequest.class, "IsActive", null);
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
    public static final org.adempiere.model.ModelColumn<I_DHL_ShipmentOrderRequest, Object> COLUMN_Updated = new org.adempiere.model.ModelColumn<I_DHL_ShipmentOrderRequest, Object>(I_DHL_ShipmentOrderRequest.class, "Updated", null);
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
