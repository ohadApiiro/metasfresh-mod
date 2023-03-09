package de.metas.order;

import java.util.List;

import org.compiere.model.I_M_MatchPO;

import de.metas.invoice.InvoiceId;
import de.metas.util.ISingletonService;

/*
 * #%L
 * de.metas.business
 * %%
 * Copyright (C) 2018 metas GmbH
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

public interface IMatchPODAO extends ISingletonService
{
	List<I_M_MatchPO> getByOrderLineAndInvoiceLine(final OrderLineId orderLineId, final int C_InvoiceLine_ID);

	List<I_M_MatchPO> getByOrderLineId(OrderLineId orderLineId);

	List<I_M_MatchPO> getByInvoiceId(final InvoiceId invoiceId);

	List<I_M_MatchPO> getByReceiptId(final int inOutId);
}
