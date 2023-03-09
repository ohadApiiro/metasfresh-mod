/** Generated Model - DO NOT CHANGE */
package de.metas.shipper.gateway.dhl.model;

import java.sql.ResultSet;
import java.util.Properties;

/** Generated Model for DHL_Shipper_Config
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public class X_DHL_Shipper_Config extends org.compiere.model.PO implements I_DHL_Shipper_Config, org.compiere.model.I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = -1933842576L;

    /** Standard Constructor */
    public X_DHL_Shipper_Config (Properties ctx, int DHL_Shipper_Config_ID, String trxName)
    {
      super (ctx, DHL_Shipper_Config_ID, trxName);
      /** if (DHL_Shipper_Config_ID == 0)
        {
			setDHL_Shipper_Config_ID (0);
        } */
    }

    /** Load Constructor */
    public X_DHL_Shipper_Config (Properties ctx, ResultSet rs, String trxName)
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

	/** Set Kontonummer.
		@param AccountNumber Kontonummer	  */
	@Override
	public void setAccountNumber (java.lang.String AccountNumber)
	{
		set_Value (COLUMNNAME_AccountNumber, AccountNumber);
	}

	/** Get Kontonummer.
		@return Kontonummer	  */
	@Override
	public java.lang.String getAccountNumber () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_AccountNumber);
	}

	/** Set Anwendungs-ID.
		@param applicationID Anwendungs-ID	  */
	@Override
	public void setapplicationID (java.lang.String applicationID)
	{
		set_Value (COLUMNNAME_applicationID, applicationID);
	}

	/** Get Anwendungs-ID.
		@return Anwendungs-ID	  */
	@Override
	public java.lang.String getapplicationID () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_applicationID);
	}

	/** Set Anwendungs-Token.
		@param ApplicationToken Anwendungs-Token	  */
	@Override
	public void setApplicationToken (java.lang.String ApplicationToken)
	{
		set_Value (COLUMNNAME_ApplicationToken, ApplicationToken);
	}

	/** Get Anwendungs-Token.
		@return Anwendungs-Token	  */
	@Override
	public java.lang.String getApplicationToken () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_ApplicationToken);
	}

	/** Set DHL API URL.
		@param dhl_api_url DHL API URL	  */
	@Override
	public void setdhl_api_url (java.lang.String dhl_api_url)
	{
		set_Value (COLUMNNAME_dhl_api_url, dhl_api_url);
	}

	/** Get DHL API URL.
		@return DHL API URL	  */
	@Override
	public java.lang.String getdhl_api_url () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_dhl_api_url);
	}

	/** Set Dhl_LenghtUOM_ID.
		@param Dhl_LenghtUOM_ID Dhl_LenghtUOM_ID	  */
	@Override
	public void setDhl_LenghtUOM_ID (int Dhl_LenghtUOM_ID)
	{
		if (Dhl_LenghtUOM_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Dhl_LenghtUOM_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Dhl_LenghtUOM_ID, Integer.valueOf(Dhl_LenghtUOM_ID));
	}

	/** Get Dhl_LenghtUOM_ID.
		@return Dhl_LenghtUOM_ID	  */
	@Override
	public int getDhl_LenghtUOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Dhl_LenghtUOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set DHL Shipper Configuration.
		@param DHL_Shipper_Config_ID DHL Shipper Configuration	  */
	@Override
	public void setDHL_Shipper_Config_ID (int DHL_Shipper_Config_ID)
	{
		if (DHL_Shipper_Config_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_DHL_Shipper_Config_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_DHL_Shipper_Config_ID, Integer.valueOf(DHL_Shipper_Config_ID));
	}

	/** Get DHL Shipper Configuration.
		@return DHL Shipper Configuration	  */
	@Override
	public int getDHL_Shipper_Config_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DHL_Shipper_Config_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public org.compiere.model.I_M_Shipper getM_Shipper()
	{
		return get_ValueAsPO(COLUMNNAME_M_Shipper_ID, org.compiere.model.I_M_Shipper.class);
	}

	@Override
	public void setM_Shipper(org.compiere.model.I_M_Shipper M_Shipper)
	{
		set_ValueFromPO(COLUMNNAME_M_Shipper_ID, org.compiere.model.I_M_Shipper.class, M_Shipper);
	}

	/** Set Lieferweg.
		@param M_Shipper_ID 
		Methode oder Art der Warenlieferung
	  */
	@Override
	public void setM_Shipper_ID (int M_Shipper_ID)
	{
		if (M_Shipper_ID < 1) 
			set_Value (COLUMNNAME_M_Shipper_ID, null);
		else 
			set_Value (COLUMNNAME_M_Shipper_ID, Integer.valueOf(M_Shipper_ID));
	}

	/** Get Lieferweg.
		@return Methode oder Art der Warenlieferung
	  */
	@Override
	public int getM_Shipper_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Shipper_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Unterschrift.
		@param Signature Unterschrift	  */
	@Override
	public void setSignature (java.lang.String Signature)
	{
		set_Value (COLUMNNAME_Signature, Signature);
	}

	/** Get Unterschrift.
		@return Unterschrift	  */
	@Override
	public java.lang.String getSignature () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_Signature);
	}

	/** Set Nutzer-ID/Login.
		@param UserName Nutzer-ID/Login	  */
	@Override
	public void setUserName (java.lang.String UserName)
	{
		set_Value (COLUMNNAME_UserName, UserName);
	}

	/** Get Nutzer-ID/Login.
		@return Nutzer-ID/Login	  */
	@Override
	public java.lang.String getUserName () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_UserName);
	}
}