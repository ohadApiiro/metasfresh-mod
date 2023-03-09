package de.metas.purchasecandidate.purchaseordercreation.remoteorder;

import java.util.Optional;
import java.util.function.Supplier;

import org.compiere.util.Env;
import org.springframework.stereotype.Service;

import de.metas.bpartner.BPartnerId;
import de.metas.organization.OrgId;
import de.metas.util.Check;
import de.metas.vendor.gateway.api.VendorGatewayRegistry;
import de.metas.vendor.gateway.api.VendorGatewayService;
import lombok.NonNull;

/*
 * #%L
 * de.metas.purchasecandidate.base
 * %%
 * Copyright (C) 2017 metas GmbH
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

@Service
public class VendorGatewayInvokerFactory
{
	private final VendorGatewayRegistry vendorGatewayRegistry;

	public VendorGatewayInvokerFactory(@NonNull final VendorGatewayRegistry vendorGatewayRegistry)
	{
		this.vendorGatewayRegistry = vendorGatewayRegistry;
	}

	public VendorGatewayInvoker createForVendorId(@NonNull final BPartnerId vendorId)
	{
		final OrgId orgId = OrgId.ofRepoIdOrNull(Env.getAD_Org_ID(Env.getCtx()));
		Check.errorIf(orgId == null || orgId.isAny(),
				"Missing AD_Org_ID in the current ctx; ctx={}",
				(Supplier<Object[]>)() -> Env.getEntireContext(Env.getCtx()));

		final Optional<VendorGatewayService> vendorGatewayService = vendorGatewayRegistry
				.getSingleVendorGatewayService(vendorId.getRepoId());

		if (vendorGatewayService.isPresent())
		{
			return RealVendorGatewayInvoker.builder()
					.orgId(orgId)
					.vendorId(vendorId)
					.vendorGatewayService(vendorGatewayService.get())
					.build();
		}
		return NullVendorGatewayInvoker.INSTANCE;
	}
}
