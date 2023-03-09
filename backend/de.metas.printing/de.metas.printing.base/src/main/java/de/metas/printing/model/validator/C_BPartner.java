package de.metas.printing.model.validator;

/*
 * #%L
 * de.metas.printing.base
 * %%
 * Copyright (C) 2015 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

import java.util.Properties;

import org.adempiere.ad.dao.IQueryBL;
import org.adempiere.ad.modelvalidator.annotations.ModelChange;
import org.adempiere.ad.modelvalidator.annotations.Validator;
import org.adempiere.ad.trx.api.ITrx;
import org.adempiere.ad.trx.api.ITrxListenerManager.TrxEventTiming;
import org.adempiere.ad.trx.api.ITrxManager;
import org.adempiere.model.InterfaceWrapperHelper;
import org.compiere.model.IQuery;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.I_C_DocType;
import org.compiere.model.ModelValidator;
import org.compiere.model.X_C_DocType;
import org.slf4j.Logger;

import de.metas.logging.LogManager;
import de.metas.printing.model.I_C_Printing_Queue;
import de.metas.util.Services;

@Validator(I_C_BPartner.class)
public class C_BPartner
{
	private static final transient Logger logger = LogManager.getLogger(C_BPartner.class);

	/**
	 * If the bpartner's <code>DocumentCopies</code> changes, then this method updates all unprocessed C_Printing_Queues which reference the bpartner. The update is performed in a dedicated
	 * transaction, after the MV's current trx is committed.
	 *
	 * @task http://dewiki908/mediawiki/index.php/08958_Druck_Warteschlange_Sortierung_Massendruck_%28103271838939%29
	 */
	@ModelChange(timings = { ModelValidator.TYPE_AFTER_CHANGE }, ifColumnsChanged = I_C_BPartner.COLUMNNAME_DocumentCopies)
	public void setCopiesFromBPartner(final I_C_BPartner bPartner)
	{
		final int documentCopies = bPartner.getDocumentCopies() > 0
				? bPartner.getDocumentCopies()
				: 1; // default

		final ITrxManager trxManager = Services.get(ITrxManager.class);

		trxManager.getTrxListenerManager(InterfaceWrapperHelper.getTrxName(bPartner))
				.newEventListener(TrxEventTiming.AFTER_COMMIT)
				.invokeMethodJustOnce(false) // invoke the handling method on *every* commit, because that's how it was and I can't check now if it's really needed
				.registerHandlingMethod(trx -> {

					final Properties ctx = InterfaceWrapperHelper.getCtx(bPartner);
					final IQueryBL queryBL = Services.get(IQueryBL.class);

					// 08958: for the starts, we only update queue items that reference invoices
					final IQuery<I_C_DocType> invoicedocTypeQuery = queryBL.createQueryBuilder(I_C_DocType.class, ctx, ITrx.TRXNAME_ThreadInherited)
							.addOnlyActiveRecordsFilter()
							.addInArrayOrAllFilter(I_C_DocType.COLUMNNAME_DocBaseType,
									X_C_DocType.DOCBASETYPE_APCreditMemo,
									X_C_DocType.DOCBASETYPE_APInvoice,
									X_C_DocType.DOCBASETYPE_ARCreditMemo,
									X_C_DocType.DOCBASETYPE_ARInvoice,
									X_C_DocType.DOCBASETYPE_ARProFormaInvoice)
							.create();

					final int updatedCount = queryBL.createQueryBuilder(I_C_Printing_Queue.class, ctx, ITrx.TRXNAME_ThreadInherited)
							.addOnlyActiveRecordsFilter()
							.addEqualsFilter(I_C_Printing_Queue.COLUMNNAME_C_BPartner_ID, bPartner.getC_BPartner_ID())
							.addEqualsFilter(I_C_Printing_Queue.COLUMN_Processed, false)
							.addInSubQueryFilter(I_C_Printing_Queue.COLUMNNAME_C_DocType_ID, I_C_DocType.COLUMNNAME_C_DocType_ID, invoicedocTypeQuery)
							.addNotEqualsFilter(I_C_Printing_Queue.COLUMN_Copies, documentCopies)
							.create()
							.updateDirectly()
							.addSetColumnValue(I_C_Printing_Queue.COLUMNNAME_Copies, documentCopies)
							.setExecuteDirectly(true) // just to be sure
							.execute();

					logger.debug("C_BPartner={}: set C_Printing_Queue.Copies={} for {} C_Printing_Queue records",
							new Object[] { bPartner, documentCopies, updatedCount });
				});
	}
}
