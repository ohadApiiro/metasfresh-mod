package de.metas.storage.spi.hu.impl;

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


import java.math.BigDecimal;

import org.adempiere.mm.attributes.api.IAttributeSet;
import org.adempiere.util.lang.ObjectUtils;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.I_C_UOM;
import org.compiere.model.I_M_Attribute;
import org.compiere.model.I_M_Locator;

import com.google.common.annotations.VisibleForTesting;

import de.metas.handlingunits.IHandlingUnitsBL;
import de.metas.handlingunits.attribute.storage.IAttributeStorage;
import de.metas.handlingunits.model.I_M_HU;
import de.metas.handlingunits.model.I_M_HU_Storage;
import de.metas.product.IProductBL;
import de.metas.product.ProductId;
import de.metas.quantity.Quantity;
import de.metas.storage.IStorageRecord;
import de.metas.storage.spi.hu.IHUStorageBL;
import de.metas.uom.IUOMConversionBL;
import de.metas.uom.UOMConversionContext;
import de.metas.util.Check;
import de.metas.util.Services;
import lombok.NonNull;

public final class HUStorageRecord implements IStorageRecord
{
	public static HUStorageRecord cast(final IStorageRecord storageRecord)
	{
		return (HUStorageRecord)storageRecord;
	}

	// services
	private final transient IProductBL productBL = Services.get(IProductBL.class);
	private final transient IUOMConversionBL uomConversionBL = Services.get(IUOMConversionBL.class);

	private final String id;
	private final HUStorageRecord_HUPart huPart;
	private final ProductId productId;
	private final Quantity qtyOnHand;
	private String _summary;

	@VisibleForTesting
	public HUStorageRecord(
			@NonNull final HUStorageRecord_HUPart huPart,
			@NonNull final I_M_HU_Storage huStorage)
	{
		Check.assumeNotNull(huPart, "huPart not null");
		Check.assumeNotNull(huStorage, "huStorage not null");

		id = I_M_HU_Storage.Table_Name + "#" + huStorage.getM_HU_Storage_ID();
		this.huPart = huPart;

		productId = ProductId.ofRepoId(huStorage.getM_Product_ID());

		//
		// Get QtyOnHand from HU Storage
		final Quantity qtyOnHandSrc = new Quantity(huStorage.getQty(), IHUStorageBL.extractUOM(huStorage));
		// ... and convert it to product's storage UOM
		final I_C_UOM productUOM = productBL.getStockUOM(productId);
		final UOMConversionContext uomConversionCtx = UOMConversionContext.of(productId);
		qtyOnHand = uomConversionBL.convertQuantityTo(qtyOnHandSrc, uomConversionCtx, productUOM);
	}

	@Override
	public String toString()
	{
		return ObjectUtils.toString(this);
	}

	@Override
	public String getSummary()
	{
		if (_summary == null)
		{
			_summary = buildSummary();
		}
		return _summary;
	}

	private String buildSummary()
	{
		final IHandlingUnitsBL handlingUnitsBL = Services.get(IHandlingUnitsBL.class);

		final StringBuilder summary = new StringBuilder();
		final I_M_HU vhu = huPart.getM_HU(); // we assume this is the VHU
		final I_M_HU tuHU = handlingUnitsBL.getTransportUnitHU(vhu);
		final I_M_HU luHU = tuHU == null ? null : handlingUnitsBL.getLoadingUnitHU(tuHU);

		summary.append("@M_LU_HU_ID@: ").append(handlingUnitsBL.getDisplayName(luHU));
		summary.append("\n@M_TU_HU_ID@: ").append(handlingUnitsBL.getDisplayName(tuHU));
		summary.append("\n@VHU_ID@: ").append(handlingUnitsBL.getDisplayName(vhu));

		final I_C_BPartner bpartner = IHandlingUnitsBL.extractBPartnerOrNull(vhu);
		if (bpartner != null && bpartner.getC_BPartner_ID() > 0)
		{
			summary.append("\n@C_BPartner_ID@: ").append(bpartner.getValue()).append("_").append(bpartner.getName());
		}

		final String productName = Services.get(IProductBL.class).getProductValueAndName(productId);
		summary.append("\n@M_Product_ID@: ").append(productName);

		// Append attributes
		final IAttributeStorage huAttributes = huPart.getAttributes();
		for (final I_M_Attribute attribute : huAttributes.getAttributes())
		{
			final Object value = huAttributes.getValue(attribute);
			// skip null attributes
			if (value == null)
			{
				continue;
			}
			summary.append("\n").append(attribute.getName()).append(": ").append(value);
		}

		summary.append("\n@QtyOnHand@: ").append(qtyOnHand);

		return summary.toString();
	}

	@Override
	public String getId()
	{
		return id;
	}

	@Override
	public ProductId getProductId()
	{
		return productId;
	}

	@Override
	public I_M_Locator getLocator()
	{
		return huPart.getM_Locator();
	}

	@Override
	public I_C_BPartner getC_BPartner()
	{
		return huPart.getC_BPartner();
	}

	@Override
	public IAttributeSet getAttributes()
	{
		return huPart.getAttributes();
	}

	@Override
	public BigDecimal getQtyOnHand()
	{
		return qtyOnHand.toBigDecimal();
	}

	public I_M_HU getVHU()
	{
		return huPart.getM_HU();
	}
}
