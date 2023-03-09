package de.metas.pricing.interceptor;

import org.adempiere.ad.modelvalidator.IModelValidationEngine;
import org.adempiere.ad.modelvalidator.annotations.Init;
import org.adempiere.ad.modelvalidator.annotations.Interceptor;
import org.adempiere.model.CopyRecordFactory;
import org.compiere.model.I_M_DiscountSchema;
import org.springframework.stereotype.Component;

import de.metas.pricing.DiscountSchemaPOCopyRecordSupport;

/*
 * #%L
 * de.metas.business
 * %%
 * Copyright (C) 2019 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */
@Interceptor(I_M_DiscountSchema.class)
@Component
public class M_DiscountSchema
{
	@Init
	public void init(final IModelValidationEngine engine)
	{
		CopyRecordFactory.enableForTableName(I_M_DiscountSchema.Table_Name);

		CopyRecordFactory.registerCopyRecordSupport(I_M_DiscountSchema.Table_Name, DiscountSchemaPOCopyRecordSupport.class);
	}
}
