package org.compiere.grid.ed;

import org.adempiere.warehouse.WarehouseId;

import de.metas.bpartner.BPartnerId;
import de.metas.document.DocTypeId;
import de.metas.lang.SOTrx;
import de.metas.product.ProductId;

/*
 * #%L
 * de.metas.adempiere.adempiere.client
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

public interface IVPAttributeContext
{
	String ATTR_NAME = IVPAttributeContext.class.getName();

	int getWindowNo();

	int getTabNo();

	BPartnerId getBpartnerId();

	ProductId getProductId();

	boolean isSOTrx();

	SOTrx getSoTrx();

	DocTypeId getDocTypeId();

	int getM_Locator_ID();

	WarehouseId getWarehouseId();
}
