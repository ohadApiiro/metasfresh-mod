/*
 * #%L
 * de.metas.business
 * %%
 * Copyright (C) 2021 metas GmbH
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

package de.metas.remittanceadvice;

import de.metas.bpartner.BPartnerId;
import de.metas.invoice.InvoiceId;
import de.metas.product.ProductId;
import de.metas.tax.api.TaxId;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class RemittanceAdviceLineServiceFee
{
	BPartnerId serviceBPartnerId;
	ProductId serviceProductId;
	InvoiceId serviceFeeInvoiceId;
	TaxId serviceFeeTaxId;
	BigDecimal serviceVatRate;

}