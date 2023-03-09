package de.metas.costing.interceptors;

import org.adempiere.ad.modelvalidator.annotations.Interceptor;
import org.adempiere.ad.modelvalidator.annotations.ModelChange;
import org.adempiere.service.ClientId;
import org.compiere.model.I_M_Product_Category_Acct;
import org.compiere.model.ModelValidator;

import de.metas.costing.CostingMethod;
import de.metas.costing.ICostElementRepository;
import lombok.NonNull;

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

@Interceptor(I_M_Product_Category_Acct.class)
class M_Product_Category_Acct
{
	private final ICostElementRepository costElementRepository;

	public M_Product_Category_Acct(@NonNull final ICostElementRepository costElementRepository)
	{
		this.costElementRepository = costElementRepository;
	}

	@ModelChange(timings = { ModelValidator.TYPE_AFTER_NEW, ModelValidator.TYPE_AFTER_CHANGE })
	public void checkCosting(final I_M_Product_Category_Acct pca)
	{
		// Create Cost Elements
		final CostingMethod costingMethod = CostingMethod.ofNullableCode(pca.getCostingMethod());
		if (costingMethod != null)
		{
			final ClientId clientId = ClientId.ofRepoId(pca.getAD_Client_ID());
			costElementRepository.getOrCreateMaterialCostElement(clientId, costingMethod);
		}
	}
}
