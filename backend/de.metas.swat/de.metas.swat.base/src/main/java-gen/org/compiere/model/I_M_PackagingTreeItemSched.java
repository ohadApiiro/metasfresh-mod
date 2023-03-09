/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2007 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.compiere.util.KeyNamePair;

import de.metas.inoutcandidate.model.I_M_ShipmentSchedule;

/** Generated Interface for M_PackagingTreeItemSched
 *  @author Adempiere (generated) 
 *  @version Release 3.5.4a
 */
public interface I_M_PackagingTreeItemSched 
{

    /** TableName=M_PackagingTreeItemSched */
    public static final String Table_Name = "M_PackagingTreeItemSched";

    /** AD_Table_ID=540260 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Mandant.
	  * Mandant fuer diese Installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organisation.
	  * Organisatorische Einheit des Mandanten
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organisation.
	  * Organisatorische Einheit des Mandanten
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Erstellt.
	  * Datum, an dem dieser Eintrag erstellt wurde
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Erstellt durch.
	  * Nutzer, der diesen Eintrag erstellt hat
	  */
	public int getCreatedBy();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Aktiv.
	  * Der Eintrag ist im System aktiv
	  */
	public void setIsActive (boolean IsActive);

	/** Get Aktiv.
	  * Der Eintrag ist im System aktiv
	  */
	public boolean isActive();

    /** Column name M_PackagingTreeItemSched_ID */
    public static final String COLUMNNAME_M_PackagingTreeItemSched_ID = "M_PackagingTreeItemSched_ID";

	/** Set Packaging Tree Item Schedule	  */
	public void setM_PackagingTreeItemSched_ID (int M_PackagingTreeItemSched_ID);

	/** Get Packaging Tree Item Schedule	  */
	public int getM_PackagingTreeItemSched_ID();


	/** Column name M_ShipmentSchedule_ID */
    public static final String COLUMNNAME_M_ShipmentSchedule_ID = "M_ShipmentSchedule_ID";
    
    /** Set M_ShipmentSchedule_ID	  */
	public void setM_ShipmentSchedule_ID (int M_ShipmentSchedule_ID);

	/** Get M_ShipmentSchedule_ID	  */
	public int getM_ShipmentSchedule_ID();

	public I_M_ShipmentSchedule getM_ShipmentSchedule() throws RuntimeException;

    
    /** Column name M_PackagingTreeItem_ID */
    public static final String COLUMNNAME_M_PackagingTreeItem_ID = "M_PackagingTreeItem_ID";

	/** Set Packaging Tree Item	  */
	public void setM_PackagingTreeItem_ID (int M_PackagingTreeItem_ID);

	/** Get Packaging Tree Item	  */
	public int getM_PackagingTreeItem_ID();

	public I_M_PackagingTreeItem getM_PackagingTreeItem() throws RuntimeException;

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Aktualisiert.
	  * Datum, an dem dieser Eintrag aktualisiert wurde
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Aktualisiert durch.
	  * Nutzer, der diesen Eintrag aktualisiert hat
	  */
	public int getUpdatedBy();
	
	 /** Column name Qty */
    public static final String COLUMNNAME_Qty = "Qty";

	/** Set Menge.
	  * Menge
	  */
	public void setQty (BigDecimal Qty);

	/** Get Menge.
	  * Menge
	  */
	public BigDecimal getQty();
}
