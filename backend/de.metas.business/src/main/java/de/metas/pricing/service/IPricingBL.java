package de.metas.pricing.service;

/*
 * #%L
 * de.metas.adempiere.adempiere.base
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

import java.math.BigDecimal;
import java.util.Set;

import de.metas.bpartner.BPartnerId;
import de.metas.lang.SOTrx;
import de.metas.location.CountryId;
import de.metas.organization.OrgId;
import de.metas.pricing.IEditablePricingContext;
import de.metas.pricing.IPricingContext;
import de.metas.pricing.IPricingResult;
import de.metas.pricing.limit.IPriceLimitRule;
import de.metas.pricing.limit.PriceLimitRuleContext;
import de.metas.pricing.limit.PriceLimitRuleResult;
import de.metas.pricing.rules.IPricingRule;
import de.metas.product.ProductId;
import de.metas.quantity.Quantity;
import de.metas.util.ISingletonService;

public interface IPricingBL extends ISingletonService
{

	/**
	 * Error message for setting product price to both scale and attribute.
	 */
	String PRODUCTPRICE_FLAG_ERROR = "de.metas.pricing.flagError";

	/**
	 * Creates an editable pricing context
	 */
	IEditablePricingContext createPricingContext();

	/**
	 * Creates and editable pricing context, initialized with given values.
	 *
	 * @param C_UOM_ID the uom of the given {@code qty}.
	 * @deprecated please use {@link #createInitialContext(OrgId, ProductId, BPartnerId, Quantity, SOTrx)} instead.
	 */
	@Deprecated
	IEditablePricingContext createInitialContext(int AD_Org_ID, int M_Product_ID, int C_BPartner_ID, int C_UOM_ID, BigDecimal qty, boolean isSOTrx);

	IEditablePricingContext createInitialContext(OrgId orgId, ProductId productId, BPartnerId bPartnerId, Quantity quantity, SOTrx soTrx);

	IPricingResult calculatePrice(IPricingContext pricingCtx);

	/**
	 * Creates an initial {@link IPricingResult}. Copies some of the given <code>pricingCtx</code>'s properties to the pricing result.
	 *
	 * This result will be updated later by {@link IPricingRule}s
	 */
	IPricingResult createInitialResult(IPricingContext pricingCtx);

	void registerPriceLimitRule(IPriceLimitRule rule);

	PriceLimitRuleResult computePriceLimit(PriceLimitRuleContext context);

	Set<CountryId> getPriceLimitCountryIds();
}
