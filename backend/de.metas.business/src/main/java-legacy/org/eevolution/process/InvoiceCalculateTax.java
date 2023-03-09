/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution *
 * This program is free software; you can redistribute it and/or modify it *
 * under the terms version 2 of the GNU General Public License as published *
 * by the Free Software Foundation. This program is distributed in the hope *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. *
 * See the GNU General Public License for more details. *
 * You should have received a copy of the GNU General Public License along *
 * with this program; if not, write to the Free Software Foundation, Inc., *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA. *
 * For the text or an alternative of this public license, you may reach us *
 * Copyright (C) 2003-2007 e-Evolution,SC. All Rights Reserved. *
 * Contributor(s): Victor Perez www.e-evolution.com *
 *****************************************************************************/
package org.eevolution.process;

import org.adempiere.exceptions.FillMandatoryException;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.MInvoice;
import org.compiere.model.MPeriod;

import de.metas.acct.api.IFactAcctDAO;
import de.metas.bpartner.service.IBPartnerDAO;
import de.metas.bpartner.service.IBPartnerStatisticsUpdater;
import de.metas.bpartner.service.IBPartnerStatisticsUpdater.BPartnerStatisticsUpdateRequest;
import de.metas.process.JavaProcess;
import de.metas.process.ProcessInfoParameter;
import de.metas.util.Services;

/**
 * Re-calculate Invoice Tax (and unpost the document)
 *
 * @author victor.perez@e-evolution.com, e-Evolution http://www.e-evolution.com
 *         <li>FR [ 2520591 ] Support multiples calendar for Org
 * @see http://sourceforge.net/tracker2/?func=detail&atid=879335&aid=2520591&group_id=176962
 * @author Teo Sarca, www.arhipac.ro
 */
public class InvoiceCalculateTax extends JavaProcess
{
	public static final String PARAM_C_Invoice_ID = "C_Invoice_ID";

	private int p_C_Invoice_ID = 0;

	@Override
	protected void prepare()
	{
		for (final ProcessInfoParameter para : getParametersAsArray())
		{
			final String name = para.getParameterName();
			if (para.getParameter() == null)
			{
				
			}
			else if (name.equals(PARAM_C_Invoice_ID))
			{
				p_C_Invoice_ID = para.getParameterAsInt();
			}
		}

		if (p_C_Invoice_ID <= 0)
		{
			throw new FillMandatoryException(PARAM_C_Invoice_ID);
		}
	}

	@Override
	protected String doIt() throws Exception
	{
		final MInvoice invoice = new MInvoice(getCtx(), p_C_Invoice_ID, get_TrxName());
		recalculateTax(invoice);
		//
		return "@ProcessOK@";
	}

	public static void recalculateTax(final MInvoice invoice)
	{
		final IBPartnerDAO bpartnerDAO = Services.get(IBPartnerDAO.class);
		final I_C_BPartner partner = bpartnerDAO.getById(invoice.getC_BPartner_ID());

		//
		// Delete accounting /UnPost
		MPeriod.testPeriodOpen(invoice.getCtx(), invoice.getDateAcct(), invoice.getC_DocType_ID(), invoice.getAD_Org_ID());
		Services.get(IFactAcctDAO.class).deleteForDocument(invoice);
		//
		// Update Invoice
		invoice.calculateTaxTotal();
		invoice.setPosted(false);
		invoice.saveEx();

		// FRESH-152 Update bpartner stats
		Services.get(IBPartnerStatisticsUpdater.class)
				.updateBPartnerStatistics(BPartnerStatisticsUpdateRequest.builder()
						.bpartnerId(partner.getC_BPartner_ID())
						.build());

	}
}
