/** Generated Model - DO NOT CHANGE */
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

/** Generated Model for C_BPartner_Product_Stats
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public class X_C_BPartner_Product_Stats extends org.compiere.model.PO implements I_C_BPartner_Product_Stats, org.compiere.model.I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1330595114L;

    /** Standard Constructor */
    public X_C_BPartner_Product_Stats (Properties ctx, int C_BPartner_Product_Stats_ID, String trxName)
    {
      super (ctx, C_BPartner_Product_Stats_ID, trxName);
      /** if (C_BPartner_Product_Stats_ID == 0)
        {
			setC_BPartner_ID (0);
			setC_BPartner_Product_Stats_ID (0);
			setM_Product_ID (0);
        } */
    }

    /** Load Constructor */
    public X_C_BPartner_Product_Stats (Properties ctx, ResultSet rs, String trxName)
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

	/** Set Geschäftspartner Produkt Statistik.
		@param C_BPartner_Product_Stats_ID Geschäftspartner Produkt Statistik	  */
	@Override
	public void setC_BPartner_Product_Stats_ID (int C_BPartner_Product_Stats_ID)
	{
		if (C_BPartner_Product_Stats_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_Product_Stats_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_Product_Stats_ID, Integer.valueOf(C_BPartner_Product_Stats_ID));
	}

	/** Get Geschäftspartner Produkt Statistik.
		@return Geschäftspartner Produkt Statistik	  */
	@Override
	public int getC_BPartner_Product_Stats_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_Product_Stats_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Letzter Wareneingang.
		@param LastReceiptDate Letzter Wareneingang	  */
	@Override
	public void setLastReceiptDate (java.sql.Timestamp LastReceiptDate)
	{
		set_Value (COLUMNNAME_LastReceiptDate, LastReceiptDate);
	}

	/** Get Letzter Wareneingang.
		@return Letzter Wareneingang	  */
	@Override
	public java.sql.Timestamp getLastReceiptDate () 
	{
		return (java.sql.Timestamp)get_Value(COLUMNNAME_LastReceiptDate);
	}

	@Override
	public org.compiere.model.I_C_Invoice getLastSales_Invoice() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_LastSales_Invoice_ID, org.compiere.model.I_C_Invoice.class);
	}

	@Override
	public void setLastSales_Invoice(org.compiere.model.I_C_Invoice LastSales_Invoice)
	{
		set_ValueFromPO(COLUMNNAME_LastSales_Invoice_ID, org.compiere.model.I_C_Invoice.class, LastSales_Invoice);
	}

	/** Set Letzte Debitoren Rechnung.
		@param LastSales_Invoice_ID Letzte Debitoren Rechnung	  */
	@Override
	public void setLastSales_Invoice_ID (int LastSales_Invoice_ID)
	{
		if (LastSales_Invoice_ID < 1) 
			set_Value (COLUMNNAME_LastSales_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_LastSales_Invoice_ID, Integer.valueOf(LastSales_Invoice_ID));
	}

	/** Get Letzte Debitoren Rechnung.
		@return Letzte Debitoren Rechnung	  */
	@Override
	public int getLastSales_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LastSales_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Last Sales Invoice Date.
		@param LastSalesInvoiceDate Last Sales Invoice Date	  */
	@Override
	public void setLastSalesInvoiceDate (java.sql.Timestamp LastSalesInvoiceDate)
	{
		set_Value (COLUMNNAME_LastSalesInvoiceDate, LastSalesInvoiceDate);
	}

	/** Get Last Sales Invoice Date.
		@return Last Sales Invoice Date	  */
	@Override
	public java.sql.Timestamp getLastSalesInvoiceDate () 
	{
		return (java.sql.Timestamp)get_Value(COLUMNNAME_LastSalesInvoiceDate);
	}

	/** Set Letzter VK.
		@param LastSalesPrice 
		letzter Verkaufspreis
	  */
	@Override
	public void setLastSalesPrice (java.math.BigDecimal LastSalesPrice)
	{
		set_Value (COLUMNNAME_LastSalesPrice, LastSalesPrice);
	}

	/** Get Letzter VK.
		@return letzter Verkaufspreis
	  */
	@Override
	public java.math.BigDecimal getLastSalesPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LastSalesPrice);
		if (bd == null)
			 return BigDecimal.ZERO;
		return bd;
	}

	@Override
	public org.compiere.model.I_C_Currency getLastSalesPrice_Currency() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_LastSalesPrice_Currency_ID, org.compiere.model.I_C_Currency.class);
	}

	@Override
	public void setLastSalesPrice_Currency(org.compiere.model.I_C_Currency LastSalesPrice_Currency)
	{
		set_ValueFromPO(COLUMNNAME_LastSalesPrice_Currency_ID, org.compiere.model.I_C_Currency.class, LastSalesPrice_Currency);
	}

	/** Set Letzter VK Währung.
		@param LastSalesPrice_Currency_ID 
		Letzter Verkaufspreis Währung
	  */
	@Override
	public void setLastSalesPrice_Currency_ID (int LastSalesPrice_Currency_ID)
	{
		if (LastSalesPrice_Currency_ID < 1) 
			set_Value (COLUMNNAME_LastSalesPrice_Currency_ID, null);
		else 
			set_Value (COLUMNNAME_LastSalesPrice_Currency_ID, Integer.valueOf(LastSalesPrice_Currency_ID));
	}

	/** Get Letzter VK Währung.
		@return Letzter Verkaufspreis Währung
	  */
	@Override
	public int getLastSalesPrice_Currency_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LastSalesPrice_Currency_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Letzte Lieferung.
		@param LastShipDate Letzte Lieferung	  */
	@Override
	public void setLastShipDate (java.sql.Timestamp LastShipDate)
	{
		set_Value (COLUMNNAME_LastShipDate, LastShipDate);
	}

	/** Get Letzte Lieferung.
		@return Letzte Lieferung	  */
	@Override
	public java.sql.Timestamp getLastShipDate () 
	{
		return (java.sql.Timestamp)get_Value(COLUMNNAME_LastShipDate);
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
}