/** Generated Model - DO NOT CHANGE */
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

/** Generated Model for I_DiscountSchema
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public class X_I_DiscountSchema extends org.compiere.model.PO implements I_I_DiscountSchema, org.compiere.model.I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = -302533675L;

    /** Standard Constructor */
    public X_I_DiscountSchema (Properties ctx, int I_DiscountSchema_ID, String trxName)
    {
      super (ctx, I_DiscountSchema_ID, trxName);
      /** if (I_DiscountSchema_ID == 0)
        {
			setI_DiscountSchema_ID (0);
			setI_IsImported (null); // N
			setPricingSystemSurchargeAmt (BigDecimal.ZERO);
			setProcessed (false); // N
        } */
    }

    /** Load Constructor */
    public X_I_DiscountSchema (Properties ctx, ResultSet rs, String trxName)
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
	public org.compiere.model.I_M_PricingSystem getBase_PricingSystem() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_Base_PricingSystem_ID, org.compiere.model.I_M_PricingSystem.class);
	}

	@Override
	public void setBase_PricingSystem(org.compiere.model.I_M_PricingSystem Base_PricingSystem)
	{
		set_ValueFromPO(COLUMNNAME_Base_PricingSystem_ID, org.compiere.model.I_M_PricingSystem.class, Base_PricingSystem);
	}

	/** Set Preissystem.
		@param Base_PricingSystem_ID Preissystem	  */
	@Override
	public void setBase_PricingSystem_ID (int Base_PricingSystem_ID)
	{
		if (Base_PricingSystem_ID < 1) 
			set_Value (COLUMNNAME_Base_PricingSystem_ID, null);
		else 
			set_Value (COLUMNNAME_Base_PricingSystem_ID, Integer.valueOf(Base_PricingSystem_ID));
	}

	/** Get Preissystem.
		@return Preissystem	  */
	@Override
	public int getBase_PricingSystem_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Base_PricingSystem_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Base_PricingSystem_Value.
		@param Base_PricingSystem_Value Base_PricingSystem_Value	  */
	@Override
	public void setBase_PricingSystem_Value (java.lang.String Base_PricingSystem_Value)
	{
		set_Value (COLUMNNAME_Base_PricingSystem_Value, Base_PricingSystem_Value);
	}

	/** Get Base_PricingSystem_Value.
		@return Base_PricingSystem_Value	  */
	@Override
	public java.lang.String getBase_PricingSystem_Value () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_Base_PricingSystem_Value);
	}

	/** Set Geschäftspartner-Schlüssel.
		@param BPartner_Value 
		Suchschlüssel für den Geschäftspartner
	  */
	@Override
	public void setBPartner_Value (java.lang.String BPartner_Value)
	{
		set_Value (COLUMNNAME_BPartner_Value, BPartner_Value);
	}

	/** Get Geschäftspartner-Schlüssel.
		@return Suchschlüssel für den Geschäftspartner
	  */
	@Override
	public java.lang.String getBPartner_Value () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_BPartner_Value);
	}

	/** Set Break Discount %.
		@param BreakDiscount 
		Trade Discount in Percent for the break level
	  */
	@Override
	public void setBreakDiscount (java.math.BigDecimal BreakDiscount)
	{
		set_Value (COLUMNNAME_BreakDiscount, BreakDiscount);
	}

	/** Get Break Discount %.
		@return Trade Discount in Percent for the break level
	  */
	@Override
	public java.math.BigDecimal getBreakDiscount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BreakDiscount);
		if (bd == null)
			 return BigDecimal.ZERO;
		return bd;
	}

	/** Set Mengenstufe.
		@param BreakValue 
		Mindestmenge ab der die Kondition gilt
	  */
	@Override
	public void setBreakValue (java.math.BigDecimal BreakValue)
	{
		set_Value (COLUMNNAME_BreakValue, BreakValue);
	}

	/** Get Mengenstufe.
		@return Mindestmenge ab der die Kondition gilt
	  */
	@Override
	public java.math.BigDecimal getBreakValue () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BreakValue);
		if (bd == null)
			 return BigDecimal.ZERO;
		return bd;
	}

	@Override
	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_C_BPartner_ID, org.compiere.model.I_C_BPartner.class);
	}

	@Override
	public void setC_BPartner(org.compiere.model.I_C_BPartner C_BPartner)
	{
		set_ValueFromPO(COLUMNNAME_C_BPartner_ID, org.compiere.model.I_C_BPartner.class, C_BPartner);
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

	@Override
	public org.compiere.model.I_C_Currency getC_Currency() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_C_Currency_ID, org.compiere.model.I_C_Currency.class);
	}

	@Override
	public void setC_Currency(org.compiere.model.I_C_Currency C_Currency)
	{
		set_ValueFromPO(COLUMNNAME_C_Currency_ID, org.compiere.model.I_C_Currency.class, C_Currency);
	}

	/** Set Währung.
		@param C_Currency_ID 
		Die Währung für diesen Eintrag
	  */
	@Override
	public void setC_Currency_ID (int C_Currency_ID)
	{
		if (C_Currency_ID < 1) 
			set_Value (COLUMNNAME_C_Currency_ID, null);
		else 
			set_Value (COLUMNNAME_C_Currency_ID, Integer.valueOf(C_Currency_ID));
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

	@Override
	public org.compiere.model.I_C_PaymentTerm getC_PaymentTerm() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_C_PaymentTerm_ID, org.compiere.model.I_C_PaymentTerm.class);
	}

	@Override
	public void setC_PaymentTerm(org.compiere.model.I_C_PaymentTerm C_PaymentTerm)
	{
		set_ValueFromPO(COLUMNNAME_C_PaymentTerm_ID, org.compiere.model.I_C_PaymentTerm.class, C_PaymentTerm);
	}

	/** Set Zahlungsbedingung.
		@param C_PaymentTerm_ID 
		Die Bedingungen für die Bezahlung dieses Vorgangs
	  */
	@Override
	public void setC_PaymentTerm_ID (int C_PaymentTerm_ID)
	{
		if (C_PaymentTerm_ID < 1) 
			set_Value (COLUMNNAME_C_PaymentTerm_ID, null);
		else 
			set_Value (COLUMNNAME_C_PaymentTerm_ID, Integer.valueOf(C_PaymentTerm_ID));
	}

	/** Get Zahlungsbedingung.
		@return Die Bedingungen für die Bezahlung dieses Vorgangs
	  */
	@Override
	public int getC_PaymentTerm_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_PaymentTerm_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Rabatt %.
		@param Discount 
		Abschlag in Prozent
	  */
	@Override
	public void setDiscount (java.math.BigDecimal Discount)
	{
		set_Value (COLUMNNAME_Discount, Discount);
	}

	/** Get Rabatt %.
		@return Abschlag in Prozent
	  */
	@Override
	public java.math.BigDecimal getDiscount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Discount);
		if (bd == null)
			 return BigDecimal.ZERO;
		return bd;
	}

	/** Set Discount Schema Import.
		@param I_DiscountSchema_ID Discount Schema Import	  */
	@Override
	public void setI_DiscountSchema_ID (int I_DiscountSchema_ID)
	{
		if (I_DiscountSchema_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_I_DiscountSchema_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_I_DiscountSchema_ID, Integer.valueOf(I_DiscountSchema_ID));
	}

	/** Get Discount Schema Import.
		@return Discount Schema Import	  */
	@Override
	public int getI_DiscountSchema_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_I_DiscountSchema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Import-Fehlermeldung.
		@param I_ErrorMsg 
		Meldungen, die durch den Importprozess generiert wurden
	  */
	@Override
	public void setI_ErrorMsg (java.lang.String I_ErrorMsg)
	{
		set_Value (COLUMNNAME_I_ErrorMsg, I_ErrorMsg);
	}

	/** Get Import-Fehlermeldung.
		@return Meldungen, die durch den Importprozess generiert wurden
	  */
	@Override
	public java.lang.String getI_ErrorMsg () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_I_ErrorMsg);
	}

	/** 
	 * I_IsImported AD_Reference_ID=540745
	 * Reference name: I_IsImported
	 */
	public static final int I_ISIMPORTED_AD_Reference_ID=540745;
	/** NotImported = N */
	public static final String I_ISIMPORTED_NotImported = "N";
	/** Imported = Y */
	public static final String I_ISIMPORTED_Imported = "Y";
	/** ImportFailed = E */
	public static final String I_ISIMPORTED_ImportFailed = "E";
	/** Set Importiert.
		@param I_IsImported 
		Ist dieser Import verarbeitet worden?
	  */
	@Override
	public void setI_IsImported (java.lang.String I_IsImported)
	{

		set_Value (COLUMNNAME_I_IsImported, I_IsImported);
	}

	/** Get Importiert.
		@return Ist dieser Import verarbeitet worden?
	  */
	@Override
	public java.lang.String getI_IsImported () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_I_IsImported);
	}

	@Override
	public org.compiere.model.I_M_DiscountSchema getM_DiscountSchema() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_M_DiscountSchema_ID, org.compiere.model.I_M_DiscountSchema.class);
	}

	@Override
	public void setM_DiscountSchema(org.compiere.model.I_M_DiscountSchema M_DiscountSchema)
	{
		set_ValueFromPO(COLUMNNAME_M_DiscountSchema_ID, org.compiere.model.I_M_DiscountSchema.class, M_DiscountSchema);
	}

	/** Set Rabatt Schema.
		@param M_DiscountSchema_ID 
		Schema um den prozentualen Rabatt zu berechnen
	  */
	@Override
	public void setM_DiscountSchema_ID (int M_DiscountSchema_ID)
	{
		if (M_DiscountSchema_ID < 1) 
			set_Value (COLUMNNAME_M_DiscountSchema_ID, null);
		else 
			set_Value (COLUMNNAME_M_DiscountSchema_ID, Integer.valueOf(M_DiscountSchema_ID));
	}

	/** Get Rabatt Schema.
		@return Schema um den prozentualen Rabatt zu berechnen
	  */
	@Override
	public int getM_DiscountSchema_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_DiscountSchema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public org.compiere.model.I_M_DiscountSchemaBreak getM_DiscountSchemaBreak() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_M_DiscountSchemaBreak_ID, org.compiere.model.I_M_DiscountSchemaBreak.class);
	}

	@Override
	public void setM_DiscountSchemaBreak(org.compiere.model.I_M_DiscountSchemaBreak M_DiscountSchemaBreak)
	{
		set_ValueFromPO(COLUMNNAME_M_DiscountSchemaBreak_ID, org.compiere.model.I_M_DiscountSchemaBreak.class, M_DiscountSchemaBreak);
	}

	/** Set Discount Schema Break.
		@param M_DiscountSchemaBreak_ID 
		Trade Discount Break
	  */
	@Override
	public void setM_DiscountSchemaBreak_ID (int M_DiscountSchemaBreak_ID)
	{
		if (M_DiscountSchemaBreak_ID < 1) 
			set_Value (COLUMNNAME_M_DiscountSchemaBreak_ID, null);
		else 
			set_Value (COLUMNNAME_M_DiscountSchemaBreak_ID, Integer.valueOf(M_DiscountSchemaBreak_ID));
	}

	/** Get Discount Schema Break.
		@return Trade Discount Break
	  */
	@Override
	public int getM_DiscountSchemaBreak_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_DiscountSchemaBreak_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_M_Product_ID, org.compiere.model.I_M_Product.class);
	}

	@Override
	public void setM_Product(org.compiere.model.I_M_Product M_Product)
	{
		set_ValueFromPO(COLUMNNAME_M_Product_ID, org.compiere.model.I_M_Product.class, M_Product);
	}

	/** Set Produkt.
		@param M_Product_ID 
		Produkt, Leistung, Artikel
	  */
	@Override
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_Value (COLUMNNAME_M_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
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

	/** Set Zahlungskonditions-Schlüssel.
		@param PaymentTermValue 
		Suchschlüssel für die Zahlungskondition
	  */
	@Override
	public void setPaymentTermValue (java.lang.String PaymentTermValue)
	{
		set_Value (COLUMNNAME_PaymentTermValue, PaymentTermValue);
	}

	/** Get Zahlungskonditions-Schlüssel.
		@return Suchschlüssel für die Zahlungskondition
	  */
	@Override
	public java.lang.String getPaymentTermValue () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_PaymentTermValue);
	}

	/** Set Preisgrundlage.
		@param PriceBase Preisgrundlage	  */
	@Override
	public void setPriceBase (java.lang.String PriceBase)
	{
		set_Value (COLUMNNAME_PriceBase, PriceBase);
	}

	/** Get Preisgrundlage.
		@return Preisgrundlage	  */
	@Override
	public java.lang.String getPriceBase () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_PriceBase);
	}

	/** Set Festpreis.
		@param PriceStdFixed 
		Festpreis, ohne ggf. zusätzliche Rabatte
	  */
	@Override
	public void setPriceStdFixed (java.math.BigDecimal PriceStdFixed)
	{
		set_Value (COLUMNNAME_PriceStdFixed, PriceStdFixed);
	}

	/** Get Festpreis.
		@return Festpreis, ohne ggf. zusätzliche Rabatte
	  */
	@Override
	public java.math.BigDecimal getPriceStdFixed () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PriceStdFixed);
		if (bd == null)
			 return BigDecimal.ZERO;
		return bd;
	}

	/** Set Preisaufschlag.
		@param PricingSystemSurchargeAmt 
		Aufschlag auf den Preis, der aus dem Preissystem resultieren würde
	  */
	@Override
	public void setPricingSystemSurchargeAmt (java.math.BigDecimal PricingSystemSurchargeAmt)
	{
		set_Value (COLUMNNAME_PricingSystemSurchargeAmt, PricingSystemSurchargeAmt);
	}

	/** Get Preisaufschlag.
		@return Aufschlag auf den Preis, der aus dem Preissystem resultieren würde
	  */
	@Override
	public java.math.BigDecimal getPricingSystemSurchargeAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PricingSystemSurchargeAmt);
		if (bd == null)
			 return BigDecimal.ZERO;
		return bd;
	}

	/** Set Verarbeitet.
		@param Processed 
		Checkbox sagt aus, ob der Beleg verarbeitet wurde. 
	  */
	@Override
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Verarbeitet.
		@return Checkbox sagt aus, ob der Beleg verarbeitet wurde. 
	  */
	@Override
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Produktschlüssel.
		@param ProductValue 
		Schlüssel des Produktes
	  */
	@Override
	public void setProductValue (java.lang.String ProductValue)
	{
		set_Value (COLUMNNAME_ProductValue, ProductValue);
	}

	/** Get Produktschlüssel.
		@return Schlüssel des Produktes
	  */
	@Override
	public java.lang.String getProductValue () 
	{
		return (java.lang.String)get_Value(COLUMNNAME_ProductValue);
	}
}