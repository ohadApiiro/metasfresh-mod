package de.metas.money.grossprofit;

import java.time.LocalDate;

import javax.annotation.Nullable;

import de.metas.bpartner.BPartnerId;
import de.metas.money.Money;
import de.metas.payment.paymentterm.PaymentTermId;
import de.metas.product.ProductId;
import de.metas.quantity.Quantity;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

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

@Value
@Builder
public class CalculateProfitPriceActualRequest
{
	@NonNull
	BPartnerId bPartnerId;

	@NonNull
	ProductId productId;

	@NonNull
	LocalDate date;

	@Nullable
	PaymentTermId paymentTermId;

	@NonNull
	Money baseAmount;

	@NonNull
	Quantity quantity;
}
