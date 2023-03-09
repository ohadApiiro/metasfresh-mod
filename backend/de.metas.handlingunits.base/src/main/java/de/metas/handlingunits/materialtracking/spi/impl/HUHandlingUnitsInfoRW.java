package de.metas.handlingunits.materialtracking.spi.impl;

/*
 * #%L
 * de.metas.handlingunits.base
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */


import de.metas.handlingunits.model.I_M_HU_PI;
import de.metas.materialtracking.IHandlingUnitsInfoWritableQty;

/*package */class HUHandlingUnitsInfoRW extends HUHandlingUnitsInfo implements IHandlingUnitsInfoWritableQty
{

	/* package */HUHandlingUnitsInfoRW(I_M_HU_PI tuPI, int qtyTU)
	{
		super(tuPI, qtyTU, true);
	}

	@Override
	public void setQtyTU(int qtyTU)
	{
		setQtyTUInner(qtyTU);
	}
}
