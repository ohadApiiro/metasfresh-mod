/*
 * #%L
 * de.metas.shipper.gateway.dpd
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

package de.metas.shipper.gateway.dpd;

import de.metas.shipper.gateway.dpd.model.DpdShipperProduct;
import org.adempiere.test.AdempiereTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Disabled("Makes ACTUAL calls to DPD api and needs auth")
public class IntegrationDEtoDETest
{
	@BeforeEach
	void setUp()
	{
		AdempiereTestHelper.get().init();
	}

	@Test
	@DisplayName("Delivery Order DE -> DE, DPD E12")
	void E12()
	{
		DpdTestHelper.testAllSteps(DpdTestHelper.createDummyDeliveryOrderDEtoDE(DpdShipperProduct.DPD_E12));
	}

	@Test
	@DisplayName("Delivery Order DE -> DE, DPD Classic")
	void Classic()
	{
		DpdTestHelper.testAllSteps(DpdTestHelper.createDummyDeliveryOrderDEtoDE(DpdShipperProduct.DPD_CLASSIC));
	}

	@Test
	@DisplayName("Delivery Order DE -> DE, DPD Express")
	void Express()
	{
		DpdTestHelper.testAllSteps(DpdTestHelper.createDummyDeliveryOrderDEtoDE(DpdShipperProduct.DPD_EXPRESS));
	}
}
