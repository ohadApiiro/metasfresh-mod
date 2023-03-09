package de.metas.contracts.flatrate.process;

import org.adempiere.model.InterfaceWrapperHelper;
import org.compiere.model.MTable;
import org.compiere.util.Env;

import de.metas.contracts.Contracts_Constants;
import de.metas.contracts.flatrate.interfaces.I_C_OLCand;
import de.metas.contracts.subscription.ISubscriptionBL;
import de.metas.impex.api.IInputDataSourceDAO;
import de.metas.impex.model.I_AD_InputDataSource;
import de.metas.process.IProcessPrecondition;
import de.metas.process.IProcessPreconditionsContext;
import de.metas.process.JavaProcess;
import de.metas.process.ProcessPreconditionsResolution;
import de.metas.util.Check;
import de.metas.util.Services;

public class C_Flatrate_Term_Create_From_OLCand extends JavaProcess implements IProcessPrecondition
{

	@Override
	protected void prepare()
	{
		// nothing to do
	}

	@Override
	protected String doIt() throws Exception
	{
		final ISubscriptionBL subscriptionBL = Services.get(ISubscriptionBL.class);

		if (getRecord_ID() > 0)
		{
			Check.assume(getTable_ID() == MTable.getTable_ID(I_C_OLCand.Table_Name), "Process is called for C_OLCands");

			final I_C_OLCand olCand = InterfaceWrapperHelper.create(getCtx(), getRecord_ID(), I_C_OLCand.class, get_TrxName());
			subscriptionBL.createTermForOLCand(getCtx(), olCand, getPinstanceId(), true, get_TrxName());
			addLog("@C_OLCand_ID@ " + olCand.getC_OLCand_ID() + " @Processed@");
		}
		else
		{
			final int counter = subscriptionBL.createMissingTermsForOLCands(getCtx(), true, getPinstanceId(), get_TrxName());
			addLog("@Processed@ " + counter + " @C_OLCand_ID@");
		}

		return "@Success@";
	}

	/**
	 * Method returns true if the given gridTab is a {@link I_C_OLCand} with the correct data destination.
	 *
	 * @param gridTab
	 */
	@Override
	public ProcessPreconditionsResolution checkPreconditionsApplicable(final IProcessPreconditionsContext context)
	{
		if (!I_C_OLCand.Table_Name.equals(context.getTableName()))
		{
			return ProcessPreconditionsResolution.reject();
		}

		if(context.isNoSelection())
		{
			return ProcessPreconditionsResolution.rejectBecauseNoSelection();
		}


		final I_C_OLCand olCand = context.getSelectedModel(I_C_OLCand.class);
		if(olCand.isError())
		{
			return ProcessPreconditionsResolution.reject("line has errors");
		}

		final IInputDataSourceDAO inputDataSourceDAO = Services.get(IInputDataSourceDAO.class);

		final I_AD_InputDataSource dest = inputDataSourceDAO.retrieveInputDataSource(Env.getCtx(), Contracts_Constants.DATA_DESTINATION_INTERNAL_NAME, false, get_TrxName());
		if (dest == null)
		{
			return ProcessPreconditionsResolution.rejectWithInternalReason("no input data source found");
		}
		if (dest.getAD_InputDataSource_ID() != olCand.getAD_DataDestination_ID())
		{
			return ProcessPreconditionsResolution.rejectWithInternalReason("input data source not matching");
		}

		return ProcessPreconditionsResolution.accept();
	}

}
