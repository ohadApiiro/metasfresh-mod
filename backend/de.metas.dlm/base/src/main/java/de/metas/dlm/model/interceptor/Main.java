package de.metas.dlm.model.interceptor;

import org.adempiere.ad.callout.spi.IProgramaticCalloutProvider;
import org.adempiere.ad.modelvalidator.AbstractModuleInterceptor;
import org.adempiere.ad.modelvalidator.IModelValidationEngine;
import org.adempiere.ad.persistence.po.NoDataFoundHandlers;
import org.adempiere.exceptions.DBException;
import org.adempiere.service.ISysConfigBL;

import de.metas.connection.IConnectionCustomizerService;
import de.metas.dlm.IDLMService;
import de.metas.dlm.connection.DLMPermanentIniCustomizer;
import de.metas.dlm.coordinator.ICoordinatorService;
import de.metas.dlm.coordinator.impl.LastUpdatedInspector;
import de.metas.dlm.exception.DLMReferenceExceptionWrapper;
import de.metas.dlm.po.UnArchiveRecordHandler;
import de.metas.util.Services;

/*
 * #%L
 * metasfresh-dlm
 * %%
 * Copyright (C) 2016 metas GmbH
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

public class Main extends AbstractModuleInterceptor
{
	/**
	 * @task https://github.com/metasfresh/metasfresh/issues/969
	 */
	private static final String SYSCONFIG_DLM_PARTITIONER_INTERCEPTOR_ENABLED = "de.metas.dlm.PartitionerInterceptor.enabled";

	@Override
	protected void registerInterceptors(final IModelValidationEngine engine)
	{
		engine.addModelValidator(DLM_Partition_Config.INSTANCE);
		engine.addModelValidator(DLM_Partition_Config_Line.INSTANCE);

		final ISysConfigBL sysConfigBL = Services.get(ISysConfigBL.class);
		if (sysConfigBL.getBooleanValue(SYSCONFIG_DLM_PARTITIONER_INTERCEPTOR_ENABLED, false))
		{
			// gh #969: only do partitioning if it's enabled
			engine.addModelValidator(PartitionerInterceptor.INSTANCE);
		}
	}

	@Override
	protected void registerCallouts(final IProgramaticCalloutProvider calloutsRegistry)
	{
		calloutsRegistry.registerAnnotatedCallout(DLM_Partition_Config_Reference.INSTANCE);
	}

	@Override
	public void onUserLogin(final int AD_Org_ID, final int AD_Role_ID, final int AD_User_ID)
	{
		DBException.registerExceptionWrapper(DLMReferenceExceptionWrapper.INSTANCE);

		// gh #1411: only register the connection customizer if it was enabled.
		final IDLMService dlmService = Services.get(IDLMService.class);
		if (dlmService.isConnectionCustomizerEnabled(AD_User_ID))
		{
			Services.get(IConnectionCustomizerService.class).registerPermanentCustomizer(DLMPermanentIniCustomizer.INSTANCE);
		}

		Services.get(ICoordinatorService.class).registerInspector(LastUpdatedInspector.INSTANCE);

		// gh #968: register handler to try to get back archived records, if PO could not load them
		NoDataFoundHandlers.get().addHandler(UnArchiveRecordHandler.INSTANCE);
	}
}
