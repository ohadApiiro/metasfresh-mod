package de.metas.invoicecandidate.spi.impl.aggregator.standard;

import static de.metas.util.Check.fail;
import static de.metas.common.util.CoalesceUtil.coalesce;
import static org.adempiere.model.InterfaceWrapperHelper.isNull;

import java.math.BigDecimal;

/*
 * #%L
 * de.metas.swat.base
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

import java.util.Set;

import org.adempiere.util.lang.ObjectUtils;
import org.compiere.model.I_M_InOutLine;

import com.google.common.collect.ImmutableSet;

import de.metas.inout.IInOutBL;
import de.metas.invoice.service.IMatchInvDAO;
import de.metas.invoicecandidate.InvoiceCandidateId;
import de.metas.invoicecandidate.api.IInvoiceLineAggregationRequest;
import de.metas.invoicecandidate.api.IInvoiceLineAttribute;
import de.metas.invoicecandidate.model.I_C_InvoiceCandidate_InOutLine;
import de.metas.invoicecandidate.model.I_C_Invoice_Candidate;
import de.metas.money.CurrencyId;
import de.metas.pricing.InvoicableQtyBasedOn;
import de.metas.product.ProductId;
import de.metas.quantity.StockQtyAndUOMQty;
import de.metas.quantity.StockQtyAndUOMQtys;
import de.metas.uom.UomId;
import de.metas.util.Services;
import lombok.Getter;
import lombok.NonNull;

public final class InvoiceCandidateWithInOutLine
{
	// services
	private final transient IInOutBL inOutBL = Services.get(IInOutBL.class);
	private final transient IMatchInvDAO matchInvDAO = Services.get(IMatchInvDAO.class);

	private final I_C_Invoice_Candidate ic;
	private final I_C_InvoiceCandidate_InOutLine iciol;
	private final Set<IInvoiceLineAttribute> invoiceLineAttributes;
	private final boolean allocateRemainingQty;

	@Getter
	private final ProductId productId;

	@Getter
	private final UomId icUomId;

	@Getter
	private final CurrencyId currencyId;

	@Getter
	private final InvoiceCandidateId invoicecandidateId;

	public InvoiceCandidateWithInOutLine(@NonNull final IInvoiceLineAggregationRequest request)
	{
		this.ic = request.getC_Invoice_Candidate();
		this.iciol = request.getC_InvoiceCandidate_InOutLine();
		this.allocateRemainingQty = request.isAllocateRemainingQty();
		this.invoiceLineAttributes = ImmutableSet.copyOf(request.getInvoiceLineAttributes());

		this.invoicecandidateId = InvoiceCandidateId.ofRepoId(ic.getC_Invoice_Candidate_ID());
		this.productId = ProductId.ofRepoId(ic.getM_Product_ID());
		this.icUomId = UomId.ofRepoId(ic.getC_UOM_ID());
		this.currencyId = CurrencyId.ofRepoId(ic.getC_Currency_ID());
	}

	@Override
	public String toString()
	{
		return ObjectUtils.toString(this);
	}

	/** @return invoice candidate; never return <code>null</code> */
	public I_C_Invoice_Candidate getC_Invoice_Candidate()
	{
		return ic;
	}

	/** @return shipment/receipt line; could be <code>null</code> */
	public I_M_InOutLine getM_InOutLine()
	{
		if (iciol == null)
		{
			return null;
		}
		final I_M_InOutLine inOutLine = iciol.getM_InOutLine();
		if (inOutLine == null)
		{
			return null;
		}
		return inOutLine;
	}

	public StockQtyAndUOMQty getQtysAlreadyInvoiced()
	{
		final StockQtyAndUOMQty zero = StockQtyAndUOMQtys.createZero(productId, icUomId);
		if (iciol == null)
		{
			return zero;
		}

		return matchInvDAO.retrieveQtysInvoiced(iciol.getM_InOutLine(), zero);
	}

	public StockQtyAndUOMQty getQtysAlreadyShipped()
	{
		final I_M_InOutLine inOutLine = getM_InOutLine();
		if (inOutLine == null)
		{
			return StockQtyAndUOMQtys.createZero(productId, icUomId);
		}

		final InvoicableQtyBasedOn invoicableQtyBasedOn = InvoicableQtyBasedOn.fromRecordString(ic.getInvoicableQtyBasedOn());
		final BigDecimal uomQty;

		if (!isNull(iciol, I_C_InvoiceCandidate_InOutLine.COLUMNNAME_QtyDeliveredInUOM_Override))
		{
			uomQty = iciol.getQtyDeliveredInUOM_Override();
		}
		else
		{
			switch (invoicableQtyBasedOn)
			{
				case CatchWeight:
					uomQty = coalesce(iciol.getQtyDeliveredInUOM_Catch(), iciol.getQtyDeliveredInUOM_Nominal());
					break;
				case NominalWeight:
					uomQty = iciol.getQtyDeliveredInUOM_Nominal();
					break;
				default:
					fail("Unexpected invoicableQtyBasedOn={}", invoicableQtyBasedOn);
					uomQty = null;
					break;
			}
		}

		final BigDecimal stockQty = inOutLine.getMovementQty();
		final StockQtyAndUOMQty deliveredQty = StockQtyAndUOMQtys
				.create(
						stockQty, productId,
						uomQty, UomId.ofRepoId(iciol.getC_UOM_ID()));

		if (inOutBL.isReturnMovementType(inOutLine.getM_InOut().getMovementType()))
		{
			return deliveredQty.negate();
		}
		return deliveredQty;
	}

	public boolean isShipped()
	{
		return getM_InOutLine() != null;
	}

	public I_C_InvoiceCandidate_InOutLine getC_InvoiceCandidate_InOutLine()
	{
		return iciol;
	}

	public Set<IInvoiceLineAttribute> getInvoiceLineAttributes()
	{
		return invoiceLineAttributes;
	}

	/**
	 * Specify if, when the aggregation is done and if {@link #getC_InvoiceCandidate_InOutLine()} is not <code>null</code> the full remaining <code>QtyToInvoice</code> of the invoice candidate shall
	 * be allocated to the <code>icIol</code>'s invoice line, or not. If <code>false</code>, then the maximum qty to be allocated is the delivered qty.
	 * <p>
	 * Note that in each aggregation, we assume that there is exactly one request with {@link #isAllocateRemainingQty()} = <code>true</code>, in order to make sure that the invoice candidate's
	 * qtyToInvoice is actually invoiced.
	 */
	public boolean isAllocateRemainingQty()
	{
		return allocateRemainingQty;
	}
}
