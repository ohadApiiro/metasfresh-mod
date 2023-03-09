package de.metas.materialtracking.process;

/*
 * #%L
 * de.metas.materialtracking
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

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.exceptions.FillMandatoryException;
import org.eevolution.model.I_PP_Order;

import de.metas.materialtracking.IMaterialTrackingDAO;
import de.metas.materialtracking.IMaterialTrackingPPOrderBL;
import de.metas.materialtracking.model.I_M_Material_Tracking;
import de.metas.materialtracking.qualityBasedInvoicing.IMaterialTrackingDocuments;
import de.metas.materialtracking.qualityBasedInvoicing.IQualityBasedInvoicingDAO;
import de.metas.materialtracking.qualityBasedInvoicing.impl.PPOrderQualityCalculator;
import de.metas.process.IProcessPrecondition;
import de.metas.process.IProcessPreconditionsContext;
import de.metas.process.JavaProcess;
import de.metas.util.Services;
import de.metas.process.ProcessPreconditionsResolution;
import lombok.NonNull;

/**
 * Updates all Quality Inspection orders which are linked to the material tracking on which given quality inspection order it is.
 *
 */
public class PP_Order_UpdateQualityFields
		extends JavaProcess
		implements IProcessPrecondition
{
	// Services
	private final IMaterialTrackingDAO materialTrackingDAO = Services.get(IMaterialTrackingDAO.class);
	private final IQualityBasedInvoicingDAO qualityBasedInvoicingDAO = Services.get(IQualityBasedInvoicingDAO.class);

	// Parameters
	private int p_PP_Order_ID;

	@Override
	public ProcessPreconditionsResolution checkPreconditionsApplicable(@NonNull final IProcessPreconditionsContext context)
	{
		if (context.isNoSelection())
		{
			return ProcessPreconditionsResolution.rejectBecauseNoSelection();
		}
		if (context.isMoreThanOneSelected())
		{
			return ProcessPreconditionsResolution.rejectBecauseNotSingleSelection();
		}

		final IMaterialTrackingPPOrderBL materialTrackingPPOrderBL = Services.get(IMaterialTrackingPPOrderBL.class);

		boolean qualityInspection = materialTrackingPPOrderBL.isQualityInspection(context.getSingleSelectedRecordId());
		if(!qualityInspection)
		{
			return ProcessPreconditionsResolution.rejectWithInternalReason("Selected PP_Order is not a quality inspection");
		}

		return ProcessPreconditionsResolution.accept();
	}

	@Override
	protected void prepare()
	{
		if (I_PP_Order.Table_Name.equals(getTableName()))
		{
			p_PP_Order_ID = getRecord_ID();
		}
	}

	@Override
	protected String doIt() throws Exception
	{
		final I_M_Material_Tracking materialTracking = getM_Material_Tracking();

		final IMaterialTrackingDocuments materialTrackingDocuments = qualityBasedInvoicingDAO.retrieveMaterialTrackingDocuments(materialTracking);

		final PPOrderQualityCalculator calculator = new PPOrderQualityCalculator();
		calculator.update(materialTrackingDocuments);

		return MSG_OK;
	}

	private I_M_Material_Tracking getM_Material_Tracking()
	{
		if (p_PP_Order_ID <= 0)
		{
			throw new FillMandatoryException(I_PP_Order.COLUMNNAME_PP_Order_ID);
		}

		final I_PP_Order ppOrder = getRecord(I_PP_Order.class);

		// note that a quality inspection has at most one material-tracking
		final I_M_Material_Tracking materialTracking = materialTrackingDAO.retrieveSingleMaterialTrackingForModel(ppOrder);
		if (materialTracking == null)
		{
			throw new AdempiereException("@NotFound@ @M_Material_Tracking_ID@"
					+ "\n @PP_Order_ID@: " + ppOrder);
		}

		return materialTracking;
	}
}
