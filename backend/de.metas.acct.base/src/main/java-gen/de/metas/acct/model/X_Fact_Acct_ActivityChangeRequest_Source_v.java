/** Generated Model - DO NOT CHANGE */
package de.metas.acct.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

/** Generated Model for Fact_Acct_ActivityChangeRequest_Source_v
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public class X_Fact_Acct_ActivityChangeRequest_Source_v extends org.compiere.model.PO implements I_Fact_Acct_ActivityChangeRequest_Source_v, org.compiere.model.I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1033708249L;

    /** Standard Constructor */
    public X_Fact_Acct_ActivityChangeRequest_Source_v (Properties ctx, int Fact_Acct_ActivityChangeRequest_Source_v_ID, String trxName)
    {
      super (ctx, Fact_Acct_ActivityChangeRequest_Source_v_ID, trxName);
      /** if (Fact_Acct_ActivityChangeRequest_Source_v_ID == 0)
        {
        } */
    }

    /** Load Constructor */
    public X_Fact_Acct_ActivityChangeRequest_Source_v (Properties ctx, ResultSet rs, String trxName)
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
	public org.compiere.model.I_C_ElementValue getAccount()
	{
		return get_ValueAsPO(COLUMNNAME_Account_ID, org.compiere.model.I_C_ElementValue.class);
	}

	@Override
	public void setAccount(org.compiere.model.I_C_ElementValue Account)
	{
		set_ValueFromPO(COLUMNNAME_Account_ID, org.compiere.model.I_C_ElementValue.class, Account);
	}

	/** Set Konto.
		@param Account_ID 
		Verwendetes Konto
	  */
	@Override
	public void setAccount_ID (int Account_ID)
	{
		if (Account_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Account_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Account_ID, Integer.valueOf(Account_ID));
	}

	/** Get Konto.
		@return Verwendetes Konto
	  */
	@Override
	public int getAccount_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Account_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public org.compiere.model.I_AD_Table getAD_Table()
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
			set_ValueNoCheck (COLUMNNAME_AD_Table_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
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

	/** Set Haben.
		@param AmtAcctCr 
		Ausgewiesener Forderungsbetrag
	  */
	@Override
	public void setAmtAcctCr (java.math.BigDecimal AmtAcctCr)
	{
		set_ValueNoCheck (COLUMNNAME_AmtAcctCr, AmtAcctCr);
	}

	/** Get Haben.
		@return Ausgewiesener Forderungsbetrag
	  */
	@Override
	public java.math.BigDecimal getAmtAcctCr () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtAcctCr);
		if (bd == null)
			 return BigDecimal.ZERO;
		return bd;
	}

	/** Set Soll.
		@param AmtAcctDr 
		Ausgewiesener Verbindlichkeitsbetrag
	  */
	@Override
	public void setAmtAcctDr (java.math.BigDecimal AmtAcctDr)
	{
		set_ValueNoCheck (COLUMNNAME_AmtAcctDr, AmtAcctDr);
	}

	/** Get Soll.
		@return Ausgewiesener Verbindlichkeitsbetrag
	  */
	@Override
	public java.math.BigDecimal getAmtAcctDr () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtAcctDr);
		if (bd == null)
			 return BigDecimal.ZERO;
		return bd;
	}

	/** Set Ausgangsforderung.
		@param AmtSourceCr 
		Ausgangsbetrag Forderung
	  */
	@Override
	public void setAmtSourceCr (java.math.BigDecimal AmtSourceCr)
	{
		set_ValueNoCheck (COLUMNNAME_AmtSourceCr, AmtSourceCr);
	}

	/** Get Ausgangsforderung.
		@return Ausgangsbetrag Forderung
	  */
	@Override
	public java.math.BigDecimal getAmtSourceCr () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtSourceCr);
		if (bd == null)
			 return BigDecimal.ZERO;
		return bd;
	}

	/** Set Ausgangsverbindlichkeit.
		@param AmtSourceDr 
		Ausgangsbetrag Verbindlichkeit

	  */
	@Override
	public void setAmtSourceDr (java.math.BigDecimal AmtSourceDr)
	{
		set_ValueNoCheck (COLUMNNAME_AmtSourceDr, AmtSourceDr);
	}

	/** Get Ausgangsverbindlichkeit.
		@return Ausgangsbetrag Verbindlichkeit

	  */
	@Override
	public java.math.BigDecimal getAmtSourceDr () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtSourceDr);
		if (bd == null)
			 return BigDecimal.ZERO;
		return bd;
	}

	@Override
	public org.compiere.model.I_C_AcctSchema getC_AcctSchema()
	{
		return get_ValueAsPO(COLUMNNAME_C_AcctSchema_ID, org.compiere.model.I_C_AcctSchema.class);
	}

	@Override
	public void setC_AcctSchema(org.compiere.model.I_C_AcctSchema C_AcctSchema)
	{
		set_ValueFromPO(COLUMNNAME_C_AcctSchema_ID, org.compiere.model.I_C_AcctSchema.class, C_AcctSchema);
	}

	/** Set Buchführungs-Schema.
		@param C_AcctSchema_ID 
		Stammdaten für Buchhaltung
	  */
	@Override
	public void setC_AcctSchema_ID (int C_AcctSchema_ID)
	{
		if (C_AcctSchema_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_AcctSchema_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_AcctSchema_ID, Integer.valueOf(C_AcctSchema_ID));
	}

	/** Get Buchführungs-Schema.
		@return Stammdaten für Buchhaltung
	  */
	@Override
	public int getC_AcctSchema_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_AcctSchema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public org.compiere.model.I_C_Activity getC_Activity()
	{
		return get_ValueAsPO(COLUMNNAME_C_Activity_ID, org.compiere.model.I_C_Activity.class);
	}

	@Override
	public void setC_Activity(org.compiere.model.I_C_Activity C_Activity)
	{
		set_ValueFromPO(COLUMNNAME_C_Activity_ID, org.compiere.model.I_C_Activity.class, C_Activity);
	}

	/** Set Kostenstelle.
		@param C_Activity_ID 
		Kostenstelle
	  */
	@Override
	public void setC_Activity_ID (int C_Activity_ID)
	{
		if (C_Activity_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Activity_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
	}

	/** Get Kostenstelle.
		@return Kostenstelle
	  */
	@Override
	public int getC_Activity_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Activity_ID);
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
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
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

	/** Set Währung.
		@param C_Currency_ID 
		Die Währung für diesen Eintrag
	  */
	@Override
	public void setC_Currency_ID (int C_Currency_ID)
	{
		if (C_Currency_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Currency_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Currency_ID, Integer.valueOf(C_Currency_ID));
	}

	/** Get Währung.
		@return Die Währung für diesen Eintrag
	  */
	@Override
	public int getC_Currency_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Currency_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Belegart.
		@param C_DocType_ID 
		Belegart oder Verarbeitungsvorgaben
	  */
	@Override
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0) 
			set_ValueNoCheck (COLUMNNAME_C_DocType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Belegart.
		@return Belegart oder Verarbeitungsvorgaben
	  */
	@Override
	public int getC_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public org.compiere.model.I_C_Period getC_Period()
	{
		return get_ValueAsPO(COLUMNNAME_C_Period_ID, org.compiere.model.I_C_Period.class);
	}

	@Override
	public void setC_Period(org.compiere.model.I_C_Period C_Period)
	{
		set_ValueFromPO(COLUMNNAME_C_Period_ID, org.compiere.model.I_C_Period.class, C_Period);
	}

	/** Set Periode.
		@param C_Period_ID 
		Periode des Kalenders
	  */
	@Override
	public void setC_Period_ID (int C_Period_ID)
	{
		if (C_Period_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Period_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Period_ID, Integer.valueOf(C_Period_ID));
	}

	/** Get Periode.
		@return Periode des Kalenders
	  */
	@Override
	public int getC_Period_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Period_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Maßeinheit.
		@param C_UOM_ID 
		Maßeinheit
	  */
	@Override
	public void setC_UOM_ID (int C_UOM_ID)
	{
		if (C_UOM_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_UOM_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
	}

	/** Get Maßeinheit.
		@return Maßeinheit
	  */
	@Override
	public int getC_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Buchungsdatum.
		@param DateAcct 
		Accounting Date
	  */
	@Override
	public void setDateAcct (java.sql.Timestamp DateAcct)
	{
		set_ValueNoCheck (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Buchungsdatum.
		@return Accounting Date
	  */
	@Override
	public java.sql.Timestamp getDateAcct () 
	{
		return (java.sql.Timestamp)get_Value(COLUMNNAME_DateAcct);
	}

	/** Set Vorgangsdatum.
		@param DateTrx 
		Vorgangsdatum
	  */
	@Override
	public void setDateTrx (java.sql.Timestamp DateTrx)
	{
		set_ValueNoCheck (COLUMNNAME_DateTrx, DateTrx);
	}

	/** Get Vorgangsdatum.
		@return Vorgangsdatum
	  */
	@Override
	public java.sql.Timestamp getDateTrx () 
	{
		return (java.sql.Timestamp)get_Value(COLUMNNAME_DateTrx);
	}

	/** Set Beschreibung.
		@param Description Beschreibung	  */
	@Override
	public void setDescription (java.lang.String Description)
	{
		set_ValueNoCheck (COLUMNNAME_Description, Description);
	}

	/** Get Beschreibung.
		@return Beschreibung	  */
	@Override
	public java.lang.String getDescription () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_Description);
	}

	/** Set Dokument Basis Typ.
		@param DocBaseType Dokument Basis Typ	  */
	@Override
	public void setDocBaseType (java.lang.String DocBaseType)
	{
		set_ValueNoCheck (COLUMNNAME_DocBaseType, DocBaseType);
	}

	/** Get Dokument Basis Typ.
		@return Dokument Basis Typ	  */
	@Override
	public java.lang.String getDocBaseType () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_DocBaseType);
	}

	/** Set Nr..
		@param DocumentNo 
		Document sequence number of the document
	  */
	@Override
	public void setDocumentNo (java.lang.String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Nr..
		@return Document sequence number of the document
	  */
	@Override
	public java.lang.String getDocumentNo () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_DocumentNo);
	}

	@Override
	public org.compiere.model.I_Fact_Acct getFact_Acct()
	{
		return get_ValueAsPO(COLUMNNAME_Fact_Acct_ID, org.compiere.model.I_Fact_Acct.class);
	}

	@Override
	public void setFact_Acct(org.compiere.model.I_Fact_Acct Fact_Acct)
	{
		set_ValueFromPO(COLUMNNAME_Fact_Acct_ID, org.compiere.model.I_Fact_Acct.class, Fact_Acct);
	}

	/** Set Accounting Fact.
		@param Fact_Acct_ID Accounting Fact	  */
	@Override
	public void setFact_Acct_ID (int Fact_Acct_ID)
	{
		if (Fact_Acct_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Fact_Acct_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Fact_Acct_ID, Integer.valueOf(Fact_Acct_ID));
	}

	/** Get Accounting Fact.
		@return Accounting Fact	  */
	@Override
	public int getFact_Acct_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Fact_Acct_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Kostenstelle ist Pflichtangabe.
		@param IsMandatoryActivity Kostenstelle ist Pflichtangabe	  */
	@Override
	public void setIsMandatoryActivity (boolean IsMandatoryActivity)
	{
		set_ValueNoCheck (COLUMNNAME_IsMandatoryActivity, Boolean.valueOf(IsMandatoryActivity));
	}

	/** Get Kostenstelle ist Pflichtangabe.
		@return Kostenstelle ist Pflichtangabe	  */
	@Override
	public boolean isMandatoryActivity () 
	{
		Object oo = get_Value(COLUMNNAME_IsMandatoryActivity);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Line ID.
		@param Line_ID 
		Transaction line ID (internal)
	  */
	@Override
	public void setLine_ID (int Line_ID)
	{
		if (Line_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Line_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Line_ID, Integer.valueOf(Line_ID));
	}

	/** Get Line ID.
		@return Transaction line ID (internal)
	  */
	@Override
	public int getLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Produkt.
		@param M_Product_ID 
		Produkt, Leistung, Artikel
	  */
	@Override
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Produkt.
		@return Produkt, Leistung, Artikel
	  */
	@Override
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** 
	 * PostingType AD_Reference_ID=125
	 * Reference name: _Posting Type
	 */
	public static final int POSTINGTYPE_AD_Reference_ID=125;
	/** Actual = A */
	public static final String POSTINGTYPE_Actual = "A";
	/** Budget = B */
	public static final String POSTINGTYPE_Budget = "B";
	/** Commitment = E */
	public static final String POSTINGTYPE_Commitment = "E";
	/** Statistical = S */
	public static final String POSTINGTYPE_Statistical = "S";
	/** Reservation = R */
	public static final String POSTINGTYPE_Reservation = "R";
	/** Actual Year End = Y */
	public static final String POSTINGTYPE_ActualYearEnd = "Y";
	/** Set Buchungsart.
		@param PostingType 
		Die Art des gebuchten Betrages dieser Transaktion
	  */
	@Override
	public void setPostingType (java.lang.String PostingType)
	{

		set_ValueNoCheck (COLUMNNAME_PostingType, PostingType);
	}

	/** Get Buchungsart.
		@return Die Art des gebuchten Betrages dieser Transaktion
	  */
	@Override
	public java.lang.String getPostingType () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_PostingType);
	}

	/** Set Menge.
		@param Qty 
		Menge
	  */
	@Override
	public void setQty (java.math.BigDecimal Qty)
	{
		set_ValueNoCheck (COLUMNNAME_Qty, Qty);
	}

	/** Get Menge.
		@return Menge
	  */
	@Override
	public java.math.BigDecimal getQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Qty);
		if (bd == null)
			 return BigDecimal.ZERO;
		return bd;
	}

	/** Set Datensatz-ID.
		@param Record_ID 
		Direct internal record ID
	  */
	@Override
	public void setRecord_ID (int Record_ID)
	{
		if (Record_ID < 0) 
			set_ValueNoCheck (COLUMNNAME_Record_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Record_ID, Integer.valueOf(Record_ID));
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

	/** Set SubLine ID.
		@param SubLine_ID 
		Transaction sub line ID (internal)
	  */
	@Override
	public void setSubLine_ID (int SubLine_ID)
	{
		if (SubLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_SubLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_SubLine_ID, Integer.valueOf(SubLine_ID));
	}

	/** Get SubLine ID.
		@return Transaction sub line ID (internal)
	  */
	@Override
	public int getSubLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SubLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}