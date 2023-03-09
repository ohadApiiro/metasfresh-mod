/** Generated Model - DO NOT CHANGE */
package org.compiere.model;

import java.sql.ResultSet;
import java.util.Properties;

/** Generated Model for C_Phonecall_Schedule
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public class X_C_Phonecall_Schedule extends org.compiere.model.PO implements I_C_Phonecall_Schedule, org.compiere.model.I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = -1939826764L;

    /** Standard Constructor */
    public X_C_Phonecall_Schedule (Properties ctx, int C_Phonecall_Schedule_ID, String trxName)
    {
      super (ctx, C_Phonecall_Schedule_ID, trxName);
      /** if (C_Phonecall_Schedule_ID == 0)
        {
			setC_BP_Contact_ID (0);
			setC_BPartner_ID (0);
			setC_BPartner_Location_ID (0);
			setC_Phonecall_Schedule_ID (0);
			setC_Phonecall_Schema_ID (0);
			setC_Phonecall_Schema_Version_ID (0);
			setC_Phonecall_Schema_Version_Line_ID (0);
			setIsCalled (false); // N
			setIsOrdered (false); // N
			setPhonecallDate (new Timestamp( System.currentTimeMillis() ));
			setPhonecallTimeMax (new Timestamp( System.currentTimeMillis() ));
			setPhonecallTimeMin (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Load Constructor */
    public X_C_Phonecall_Schedule (Properties ctx, ResultSet rs, String trxName)
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

	/** Set Kontakt.
		@param C_BP_Contact_ID Kontakt	  */
	@Override
	public void setC_BP_Contact_ID (int C_BP_Contact_ID)
	{
		if (C_BP_Contact_ID < 1) 
			set_Value (COLUMNNAME_C_BP_Contact_ID, null);
		else 
			set_Value (COLUMNNAME_C_BP_Contact_ID, Integer.valueOf(C_BP_Contact_ID));
	}

	/** Get Kontakt.
		@return Kontakt	  */
	@Override
	public int getC_BP_Contact_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BP_Contact_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Geschäftspartner.
		@param C_BPartner_ID 
		Bezeichnet einen Geschäftspartner
	  */
	@Override
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Geschäftspartner.
		@return Bezeichnet einen Geschäftspartner
	  */
	@Override
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Standort.
		@param C_BPartner_Location_ID 
		Identifiziert die (Liefer-) Adresse des Geschäftspartners
	  */
	@Override
	public void setC_BPartner_Location_ID (int C_BPartner_Location_ID)
	{
		if (C_BPartner_Location_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_Location_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_Location_ID, Integer.valueOf(C_BPartner_Location_ID));
	}

	/** Get Standort.
		@return Identifiziert die (Liefer-) Adresse des Geschäftspartners
	  */
	@Override
	public int getC_BPartner_Location_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_Location_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Anrufliste.
		@param C_Phonecall_Schedule_ID Anrufliste	  */
	@Override
	public void setC_Phonecall_Schedule_ID (int C_Phonecall_Schedule_ID)
	{
		if (C_Phonecall_Schedule_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Phonecall_Schedule_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Phonecall_Schedule_ID, Integer.valueOf(C_Phonecall_Schedule_ID));
	}

	/** Get Anrufliste.
		@return Anrufliste	  */
	@Override
	public int getC_Phonecall_Schedule_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Phonecall_Schedule_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public org.compiere.model.I_C_Phonecall_Schema getC_Phonecall_Schema()
	{
		return get_ValueAsPO(COLUMNNAME_C_Phonecall_Schema_ID, org.compiere.model.I_C_Phonecall_Schema.class);
	}

	@Override
	public void setC_Phonecall_Schema(org.compiere.model.I_C_Phonecall_Schema C_Phonecall_Schema)
	{
		set_ValueFromPO(COLUMNNAME_C_Phonecall_Schema_ID, org.compiere.model.I_C_Phonecall_Schema.class, C_Phonecall_Schema);
	}

	/** Set Anruf Planung.
		@param C_Phonecall_Schema_ID Anruf Planung	  */
	@Override
	public void setC_Phonecall_Schema_ID (int C_Phonecall_Schema_ID)
	{
		if (C_Phonecall_Schema_ID < 1) 
			set_Value (COLUMNNAME_C_Phonecall_Schema_ID, null);
		else 
			set_Value (COLUMNNAME_C_Phonecall_Schema_ID, Integer.valueOf(C_Phonecall_Schema_ID));
	}

	/** Get Anruf Planung.
		@return Anruf Planung	  */
	@Override
	public int getC_Phonecall_Schema_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Phonecall_Schema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public org.compiere.model.I_C_Phonecall_Schema_Version getC_Phonecall_Schema_Version()
	{
		return get_ValueAsPO(COLUMNNAME_C_Phonecall_Schema_Version_ID, org.compiere.model.I_C_Phonecall_Schema_Version.class);
	}

	@Override
	public void setC_Phonecall_Schema_Version(org.compiere.model.I_C_Phonecall_Schema_Version C_Phonecall_Schema_Version)
	{
		set_ValueFromPO(COLUMNNAME_C_Phonecall_Schema_Version_ID, org.compiere.model.I_C_Phonecall_Schema_Version.class, C_Phonecall_Schema_Version);
	}

	/** Set Anruf Planung Version.
		@param C_Phonecall_Schema_Version_ID Anruf Planung Version	  */
	@Override
	public void setC_Phonecall_Schema_Version_ID (int C_Phonecall_Schema_Version_ID)
	{
		if (C_Phonecall_Schema_Version_ID < 1) 
			set_Value (COLUMNNAME_C_Phonecall_Schema_Version_ID, null);
		else 
			set_Value (COLUMNNAME_C_Phonecall_Schema_Version_ID, Integer.valueOf(C_Phonecall_Schema_Version_ID));
	}

	/** Get Anruf Planung Version.
		@return Anruf Planung Version	  */
	@Override
	public int getC_Phonecall_Schema_Version_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Phonecall_Schema_Version_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public org.compiere.model.I_C_Phonecall_Schema_Version_Line getC_Phonecall_Schema_Version_Line()
	{
		return get_ValueAsPO(COLUMNNAME_C_Phonecall_Schema_Version_Line_ID, org.compiere.model.I_C_Phonecall_Schema_Version_Line.class);
	}

	@Override
	public void setC_Phonecall_Schema_Version_Line(org.compiere.model.I_C_Phonecall_Schema_Version_Line C_Phonecall_Schema_Version_Line)
	{
		set_ValueFromPO(COLUMNNAME_C_Phonecall_Schema_Version_Line_ID, org.compiere.model.I_C_Phonecall_Schema_Version_Line.class, C_Phonecall_Schema_Version_Line);
	}

	/** Set Anruf Planung Version Position.
		@param C_Phonecall_Schema_Version_Line_ID Anruf Planung Version Position	  */
	@Override
	public void setC_Phonecall_Schema_Version_Line_ID (int C_Phonecall_Schema_Version_Line_ID)
	{
		if (C_Phonecall_Schema_Version_Line_ID < 1) 
			set_Value (COLUMNNAME_C_Phonecall_Schema_Version_Line_ID, null);
		else 
			set_Value (COLUMNNAME_C_Phonecall_Schema_Version_Line_ID, Integer.valueOf(C_Phonecall_Schema_Version_Line_ID));
	}

	/** Get Anruf Planung Version Position.
		@return Anruf Planung Version Position	  */
	@Override
	public int getC_Phonecall_Schema_Version_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Phonecall_Schema_Version_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Anruf getätigt.
		@param IsCalled Anruf getätigt	  */
	@Override
	public void setIsCalled (boolean IsCalled)
	{
		set_Value (COLUMNNAME_IsCalled, Boolean.valueOf(IsCalled));
	}

	/** Get Anruf getätigt.
		@return Anruf getätigt	  */
	@Override
	public boolean isCalled () 
	{
		Object oo = get_Value(COLUMNNAME_IsCalled);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Auftrag erteilt.
		@param IsOrdered Auftrag erteilt	  */
	@Override
	public void setIsOrdered (boolean IsOrdered)
	{
		set_Value (COLUMNNAME_IsOrdered, Boolean.valueOf(IsOrdered));
	}

	/** Get Auftrag erteilt.
		@return Auftrag erteilt	  */
	@Override
	public boolean isOrdered () 
	{
		Object oo = get_Value(COLUMNNAME_IsOrdered);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Telefon.
		@param Phone 
		Beschreibt eine Telefon Nummer
	  */
	@Override
	public void setPhone (java.lang.String Phone)
	{
		throw new IllegalArgumentException ("Phone is virtual column");	}

	/** Get Telefon.
		@return Beschreibt eine Telefon Nummer
	  */
	@Override
	public java.lang.String getPhone () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_Phone);
	}

	/** Set Anrufdatum.
		@param PhonecallDate Anrufdatum	  */
	@Override
	public void setPhonecallDate (java.sql.Timestamp PhonecallDate)
	{
		set_Value (COLUMNNAME_PhonecallDate, PhonecallDate);
	}

	/** Get Anrufdatum.
		@return Anrufdatum	  */
	@Override
	public java.sql.Timestamp getPhonecallDate () 
	{
		return (java.sql.Timestamp)get_Value(COLUMNNAME_PhonecallDate);
	}

	/** Set Erreichbar bis.
		@param PhonecallTimeMax Erreichbar bis	  */
	@Override
	public void setPhonecallTimeMax (java.sql.Timestamp PhonecallTimeMax)
	{
		set_Value (COLUMNNAME_PhonecallTimeMax, PhonecallTimeMax);
	}

	/** Get Erreichbar bis.
		@return Erreichbar bis	  */
	@Override
	public java.sql.Timestamp getPhonecallTimeMax () 
	{
		return (java.sql.Timestamp)get_Value(COLUMNNAME_PhonecallTimeMax);
	}

	/** Set Erreichbar von.
		@param PhonecallTimeMin Erreichbar von	  */
	@Override
	public void setPhonecallTimeMin (java.sql.Timestamp PhonecallTimeMin)
	{
		set_Value (COLUMNNAME_PhonecallTimeMin, PhonecallTimeMin);
	}

	/** Get Erreichbar von.
		@return Erreichbar von	  */
	@Override
	public java.sql.Timestamp getPhonecallTimeMin () 
	{
		return (java.sql.Timestamp)get_Value(COLUMNNAME_PhonecallTimeMin);
	}

	/** Set Kundenbetreuer.
		@param SalesRep_ID Kundenbetreuer	  */
	@Override
	public void setSalesRep_ID (int SalesRep_ID)
	{
		if (SalesRep_ID < 1) 
			set_Value (COLUMNNAME_SalesRep_ID, null);
		else 
			set_Value (COLUMNNAME_SalesRep_ID, Integer.valueOf(SalesRep_ID));
	}

	/** Get Kundenbetreuer.
		@return Kundenbetreuer	  */
	@Override
	public int getSalesRep_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SalesRep_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}