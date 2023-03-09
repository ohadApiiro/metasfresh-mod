package de.metas.handlingunits.storage.impl;

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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

import java.math.BigDecimal;
import java.util.Objects;

import org.compiere.model.I_C_UOM;
import org.slf4j.Logger;

import de.metas.handlingunits.IHUCapacityBL;
import de.metas.handlingunits.allocation.IAllocationRequest;
import de.metas.handlingunits.allocation.impl.AllocationUtils;
import de.metas.handlingunits.storage.IProductStorage;
import de.metas.logging.LogManager;
import de.metas.product.ProductId;
import de.metas.quantity.Bucket;
import de.metas.quantity.Capacity;
import de.metas.quantity.Quantity;
import de.metas.uom.IUOMConversionBL;
import de.metas.uom.UOMConversionContext;
import de.metas.util.Check;
import de.metas.util.Services;
import lombok.NonNull;

public abstract class AbstractProductStorage implements IProductStorage
{
	protected final transient Logger logger = LogManager.getLogger(getClass());
	protected final IHUCapacityBL capacityBL = Services.get(IHUCapacityBL.class);

	private Capacity _capacityTotal = null;
	private Bucket _capacity = null;

	/** NOTE: this flag was introduced for backward compatibility (support those storages which does not support considering ForceQtyAllocation) */
	private boolean _considerForceQtyAllocationFromRequest = true;

	protected abstract Capacity retrieveTotalCapacity();

	protected abstract BigDecimal retrieveQtyInitial();

	protected final Capacity getTotalCapacity()
	{
		if (_capacityTotal == null)
		{
			_capacityTotal = retrieveTotalCapacity();
			Check.assumeNotNull(_capacityTotal, "retrieveTotalCapacity() shall not return null");
		}
		return _capacityTotal;
	}

	public final boolean isConsiderForceQtyAllocationFromRequest()
	{
		return _considerForceQtyAllocationFromRequest;
	}

	/** NOTE: this flag was introduced for backward compatibility (support those storages which does not support considering ForceQtyAllocation) */
	@Deprecated
	protected final void setConsiderForceQtyAllocationFromRequest(final boolean considerForceQtyAllocationFromRequest)
	{
		_considerForceQtyAllocationFromRequest = considerForceQtyAllocationFromRequest;
	}

	@Override
	public final boolean isAllowNegativeStorage()
	{
		final Bucket capacity = getCapacity();
		return capacity.isAllowNegativeCapacity();

	}

	private final Bucket getCapacity()
	{
		if (_capacity == null)
		{
			final Capacity capacityTotal = getTotalCapacity();
			final BigDecimal qtyUsedInitial = retrieveQtyInitial();
			_capacity = Bucket.createBucketWithCapacityAndQty(capacityTotal, qtyUsedInitial);
		}
		return _capacity;
	}

	@Override
	public final Quantity getQty()
	{
		final BigDecimal qtyBD = getCapacity().getQty();
		final I_C_UOM uom = getC_UOM();
		return Quantity.of(qtyBD, uom);
	}

	@Override
	public final Quantity getQty(@NonNull final I_C_UOM uom)
	{
		final ProductId productId = getProductId();
		final Quantity qty = getQty();

		final IUOMConversionBL uomConversionBL = Services.get(IUOMConversionBL.class);
		final UOMConversionContext conversionCtx = UOMConversionContext.of(productId);
		return uomConversionBL.convertQuantityTo(qty, conversionCtx, uom);
	}

	@Override
	public String toString()
	{
		return getClass().getSimpleName() + " ["
				+ "capacity=" + (_capacity == null ? "(not loaded yet)" : _capacity.toString())
				+ "]";
	}

	@Override
	public ProductId getProductId()
	{
		return getTotalCapacity().getProductId();
	}

	@Override
	public final I_C_UOM getC_UOM()
	{
		return getTotalCapacity().getC_UOM();
	}

	@Override
	public final BigDecimal getQtyCapacity()
	{
		final Bucket capacity = getCapacity();
		if (capacity.isInfiniteCapacity())
		{
			return Quantity.QTY_INFINITE;
		}
		return capacity.getCapacity();
	}

	@Override
	public final BigDecimal getQtyFree()
	{
		final Bucket capacity = getCapacity();
		if (capacity.isInfiniteCapacity())
		{
			return Quantity.QTY_INFINITE;
		}

		return capacity.getQtyFree();
	}

	@Override
	public final IAllocationRequest addQty(final IAllocationRequest request)
	{
		if (!isEligible(request))
		{
			return AllocationUtils.createZeroQtyRequest(request);
		}

		final Bucket capacity = getCapacity();
		final Quantity qtyToAdd = request.getQuantity();
		final Boolean allowCapacityOverload = getAllowCapacityOverload(request);
		final Quantity qtyToAddActual = capacity.addQty(qtyToAdd, allowCapacityOverload);

		final IAllocationRequest requestActual = AllocationUtils.createQtyRequest(request, qtyToAddActual);
		return requestActual;
	}

	protected Boolean getAllowCapacityOverload(final IAllocationRequest request)
	{
		if (isConsiderForceQtyAllocationFromRequest() && request.isForceQtyAllocation())
		{
			return true;
		}
		else
		{
			return null; // use default
		}
	}

	@Override
	public final IAllocationRequest removeQty(final IAllocationRequest request)
	{
		if (!isEligible(request))
		{
			return AllocationUtils.createZeroQtyRequest(request);
		}

		final Bucket capacity = getCapacity();
		final Quantity qtyToRemove = request.getQuantity();
		final Boolean allowNegativeCapacityOverride = getAllowNegativeCapacityOverride(request);
		final Quantity qtyToRemoveActual = capacity.removeQty(qtyToRemove, allowNegativeCapacityOverride);

		final IAllocationRequest requestActual = AllocationUtils.createQtyRequest(request, qtyToRemoveActual);
		return requestActual;
	}

	protected Boolean getAllowNegativeCapacityOverride(final IAllocationRequest request)
	{
		if (getCapacity().isInfiniteCapacity()) // 08443: For infinite capacity, disallow negative capacity overrides ()
		{
			return false;
		}
		else if (isConsiderForceQtyAllocationFromRequest() && request.isForceQtyAllocation())
		{
			return true;
		}
		else
		{
			return isAllowNegativeStorage();
		}
	}

	private boolean isEligible(final IAllocationRequest request)
	{
		// NOTE: don't throw exception but just return false,
		// because we have the case where are multiple storages in a pool and each of them are asked if they can fullfill a given request

		return Objects.equals(request.getProductId(), getProductId());
	}

	protected final BigDecimal convertToStorageUOM(final BigDecimal qty, final I_C_UOM uom)
	{
		Check.assumeNotNull(qty, "qty not null");
		Check.assumeNotNull(uom, "uom not null");

		final ProductId productId = getProductId();
		final I_C_UOM storageUOM = getC_UOM();

		final BigDecimal qtyConverted = Services.get(IUOMConversionBL.class)
				.convertQty(productId, qty, uom, storageUOM);

		Check.assumeNotNull(qtyConverted,
				"qtyConverted not null (Qty={}, FromUOM={}, ToUOM={}, Product={}",
				qty, uom, storageUOM);

		return qtyConverted;
	}

	@Override
	public boolean isEmpty()
	{
		return getQty().isZero();
	}

	public boolean isFull()
	{
		final BigDecimal qtyFree = getQtyFree();
		return qtyFree.signum() == 0;
	}

	@Override
	public final void markStaled()
	{
		beforeMarkingStalled();
		_capacity = null;
	}

	/**
	 * This method is called when {@link #markStaled()} is executed, right before resetting the status.
	 *
	 * NOTE: To be implemented by extending classes.
	 */
	protected void beforeMarkingStalled()
	{
		// nothing
	}
}
