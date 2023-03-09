/** Generated Model - DO NOT CHANGE */
package org.compiere.model;

import java.sql.ResultSet;
import java.util.Properties;

/** Generated Model for AD_Attachment_Log
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public class X_AD_Attachment_Log extends org.compiere.model.PO implements I_AD_Attachment_Log, org.compiere.model.I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = -33447347L;

    /** Standard Constructor */
    public X_AD_Attachment_Log (Properties ctx, int AD_Attachment_Log_ID, String trxName)
    {
      super (ctx, AD_Attachment_Log_ID, trxName);
      /** if (AD_Attachment_Log_ID == 0)
        {
			setAD_Attachment_Log_ID (0);
			setAD_Table_ID (0);
			setFileName (null);
			setRecord_ID (0);
			setType (null);
        } */
    }

    /** Load Constructor */
    public X_AD_Attachment_Log (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }


    /** Load Meta Data */
    @Override
    protected org.compiere.model.POInfo initPO (Properties ctx)
    {
      org.compiere.model.POInfo poi = org.compiere.model.POInfo.getPOInfo (ctx, Table_Name, get_TrxName());
      return poi;
    }

	@Override
	public org.compiere.model.I_AD_Attachment getAD_Attachment() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_AD_Attachment_ID, org.compiere.model.I_AD_Attachment.class);
	}

	@Override
	public void setAD_Attachment(org.compiere.model.I_AD_Attachment AD_Attachment)
	{
		set_ValueFromPO(COLUMNNAME_AD_Attachment_ID, org.compiere.model.I_AD_Attachment.class, AD_Attachment);
	}

	/** Set Anlage.
		@param AD_Attachment_ID 
		Anlage zum Eintrag
	  */
	@Override
	public void setAD_Attachment_ID (int AD_Attachment_ID)
	{
		if (AD_Attachment_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AD_Attachment_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_Attachment_ID, Integer.valueOf(AD_Attachment_ID));
	}

	/** Get Anlage.
		@return Anlage zum Eintrag
	  */
	@Override
	public int getAD_Attachment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Attachment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Attachment Log.
		@param AD_Attachment_Log_ID Attachment Log	  */
	@Override
	public void setAD_Attachment_Log_ID (int AD_Attachment_Log_ID)
	{
		if (AD_Attachment_Log_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AD_Attachment_Log_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_Attachment_Log_ID, Integer.valueOf(AD_Attachment_Log_ID));
	}

	/** Get Attachment Log.
		@return Attachment Log	  */
	@Override
	public int getAD_Attachment_Log_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Attachment_Log_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_AD_Table_ID, org.compiere.model.I_AD_Table.class);
	}

	@Override
	public void setAD_Table(org.compiere.model.I_AD_Table AD_Table)
	{
		set_ValueFromPO(COLUMNNAME_AD_Table_ID, org.compiere.model.I_AD_Table.class, AD_Table);
	}

	/** Set DB-Tabelle.
		@param AD_Table_ID 
		Database Table information
	  */
	@Override
	public void setAD_Table_ID (int AD_Table_ID)
	{
		if (AD_Table_ID < 1) 
			set_Value (COLUMNNAME_AD_Table_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
	}

	/** Get DB-Tabelle.
		@return Database Table information
	  */
	@Override
	public int getAD_Table_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Content type.
		@param ContentType Content type	  */
	@Override
	public void setContentType (java.lang.String ContentType)
	{
		set_Value (COLUMNNAME_ContentType, ContentType);
	}

	/** Get Content type.
		@return Content type	  */
	@Override
	public java.lang.String getContentType () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_ContentType);
	}

	/** Set Beschreibung.
		@param Description Beschreibung	  */
	@Override
	public void setDescription (java.lang.String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Beschreibung.
		@return Beschreibung	  */
	@Override
	public java.lang.String getDescription () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_Description);
	}

	/** Set File Name.
		@param FileName 
		Name of the local file or URL
	  */
	@Override
	public void setFileName (java.lang.String FileName)
	{
		set_Value (COLUMNNAME_FileName, FileName);
	}

	/** Get File Name.
		@return Name of the local file or URL
	  */
	@Override
	public java.lang.String getFileName () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_FileName);
	}

	/** Set Datensatz-ID.
		@param Record_ID 
		Direct internal record ID
	  */
	@Override
	public void setRecord_ID (int Record_ID)
	{
		if (Record_ID < 0) 
			set_Value (COLUMNNAME_Record_ID, null);
		else 
			set_Value (COLUMNNAME_Record_ID, Integer.valueOf(Record_ID));
	}

	/** Get Datensatz-ID.
		@return Direct internal record ID
	  */
	@Override
	public int getRecord_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Record_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tags.
		@param Tags Tags	  */
	@Override
	public void setTags (java.lang.String Tags)
	{
		set_Value (COLUMNNAME_Tags, Tags);
	}

	/** Get Tags.
		@return Tags	  */
	@Override
	public java.lang.String getTags () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_Tags);
	}

	/** 
	 * Type AD_Reference_ID=540751
	 * Reference name: AD_AttachmentEntry_Type
	 */
	public static final int TYPE_AD_Reference_ID=540751;
	/** Data = D */
	public static final String TYPE_Data = "D";
	/** URL = U */
	public static final String TYPE_URL = "U";
	/** Set Art.
		@param Type Art	  */
	@Override
	public void setType (java.lang.String Type)
	{

		set_ValueNoCheck (COLUMNNAME_Type, Type);
	}

	/** Get Art.
		@return Art	  */
	@Override
	public java.lang.String getType () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_Type);
	}

	/** Set URL.
		@param URL 
		Full URL address - e.g. http://www.adempiere.org
	  */
	@Override
	public void setURL (java.lang.String URL)
	{
		set_Value (COLUMNNAME_URL, URL);
	}

	/** Get URL.
		@return Full URL address - e.g. http://www.adempiere.org
	  */
	@Override
	public java.lang.String getURL () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_URL);
	}
}