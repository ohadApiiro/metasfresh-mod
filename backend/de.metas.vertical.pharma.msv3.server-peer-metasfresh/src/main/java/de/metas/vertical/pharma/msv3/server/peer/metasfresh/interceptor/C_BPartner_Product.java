package de.metas.vertical.pharma.msv3.server.peer.metasfresh.interceptor;

import org.adempiere.ad.modelvalidator.annotations.Interceptor;
import org.adempiere.ad.modelvalidator.annotations.ModelChange;
import org.adempiere.ad.trx.api.ITrxListenerManager.TrxEventTiming;
import org.adempiere.ad.trx.api.ITrxManager;
import org.adempiere.exceptions.FillMandatoryException;
import org.adempiere.model.InterfaceWrapperHelper;
import org.compiere.Adempiere;
import org.compiere.model.I_C_BPartner_Product;
import org.compiere.model.ModelValidator;
import org.springframework.stereotype.Component;

import de.metas.bpartner.BPartnerId;
import de.metas.product.ProductId;
import de.metas.util.Check;
import de.metas.util.Services;
import de.metas.vertical.pharma.msv3.server.peer.metasfresh.services.MSV3StockAvailabilityService;
import lombok.NonNull;

/*
 * #%L
 * metasfresh-pharma.msv3.server-peer-metasfresh
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

@Interceptor(I_C_BPartner_Product.class)
@Component
public class C_BPartner_Product
{

	@ModelChange(timings = { ModelValidator.TYPE_BEFORE_NEW, ModelValidator.TYPE_BEFORE_CHANGE })
	public void validate(final I_C_BPartner_Product bpartnerProduct)
	{
		if (!bpartnerProduct.isExcludedFromSale())
		{
			return;
		}

		if (Check.isEmpty(bpartnerProduct.getExclusionFromSaleReason(), true))
		{
			throw new FillMandatoryException(I_C_BPartner_Product.COLUMNNAME_ExclusionFromSaleReason);
		}
	}

	@ModelChange(timings = ModelValidator.TYPE_AFTER_NEW)
	public void onAfterNew(final I_C_BPartner_Product bpartnerProduct)
	{
		if (!isExcludedFromSaleToCustomer(bpartnerProduct))
		{
			return;
		}

		final MSV3StockAvailabilityService stockAvailabilityService = getStockAvailabilityService();
		final ProductId productId = ProductId.ofRepoId(bpartnerProduct.getM_Product_ID());
		final BPartnerId newBPartnerId = BPartnerId.ofRepoIdOrNull(bpartnerProduct.getC_BPartner_ID());
		final BPartnerId oldBPartnerId = null;
		runAfterCommit(() -> stockAvailabilityService.publishProductExcludeAddedOrChanged(productId, newBPartnerId, oldBPartnerId));
	}

	@ModelChange(timings = ModelValidator.TYPE_AFTER_CHANGE, //
			ifColumnsChanged = { I_C_BPartner_Product.COLUMNNAME_IsActive, I_C_BPartner_Product.COLUMNNAME_IsExcludedFromSale, I_C_BPartner_Product.COLUMNNAME_C_BPartner_ID })
	public void onAfterChanged(final I_C_BPartner_Product bpartnerProduct)
	{
		final I_C_BPartner_Product bpartnerProductOld = InterfaceWrapperHelper.createOld(bpartnerProduct, I_C_BPartner_Product.class);
		final boolean wasExcludedFromSale = isExcludedFromSaleToCustomer(bpartnerProductOld);
		final boolean isExcludedFromSale = isExcludedFromSaleToCustomer(bpartnerProduct);
		if (!wasExcludedFromSale && !isExcludedFromSale)
		{
			return;
		}

		final MSV3StockAvailabilityService stockAvailabilityService = getStockAvailabilityService();
		final ProductId productId = ProductId.ofRepoId(bpartnerProduct.getM_Product_ID());
		final BPartnerId newBPartnerId = BPartnerId.ofRepoIdOrNull(bpartnerProduct.getC_BPartner_ID());
		final BPartnerId oldBPartnerId = BPartnerId.ofRepoIdOrNull(bpartnerProductOld.getC_BPartner_ID());
		if (isExcludedFromSale)
		{
			runAfterCommit(() -> stockAvailabilityService.publishProductExcludeAddedOrChanged(productId, newBPartnerId, oldBPartnerId));
		}
		else
		{
			runAfterCommit(() -> stockAvailabilityService.publishProductExcludeDeleted(productId, newBPartnerId, oldBPartnerId));
		}
	}

	@ModelChange(timings = ModelValidator.TYPE_AFTER_DELETE)
	public void onAfterDeleted(final I_C_BPartner_Product bpartnerProduct)
	{
		final I_C_BPartner_Product bpartnerProductOld = InterfaceWrapperHelper.createOld(bpartnerProduct, I_C_BPartner_Product.class);

		final MSV3StockAvailabilityService stockAvailabilityService = getStockAvailabilityService();
		final ProductId productId = ProductId.ofRepoId(bpartnerProduct.getM_Product_ID());
		final BPartnerId newBPartnerId = BPartnerId.ofRepoIdOrNull(bpartnerProduct.getC_BPartner_ID());
		final BPartnerId oldBPartnerId = BPartnerId.ofRepoIdOrNull(bpartnerProductOld.getC_BPartner_ID());
		runAfterCommit(() -> stockAvailabilityService.publishProductExcludeDeleted(productId, newBPartnerId, oldBPartnerId));
	}

	private static boolean isExcludedFromSaleToCustomer(final I_C_BPartner_Product bpartnerProduct)
	{
		return bpartnerProduct.isActive() && bpartnerProduct.isExcludedFromSale();
	}

	private MSV3StockAvailabilityService getStockAvailabilityService()
	{
		return Adempiere.getBean(MSV3StockAvailabilityService.class);
	}

	private void runAfterCommit(@NonNull final Runnable runnable)
	{
		Services.get(ITrxManager.class)
				.getCurrentTrxListenerManagerOrAutoCommit()
				.newEventListener(TrxEventTiming.AFTER_COMMIT)
				.registerHandlingMethod(trx -> runnable.run());
	}
}
