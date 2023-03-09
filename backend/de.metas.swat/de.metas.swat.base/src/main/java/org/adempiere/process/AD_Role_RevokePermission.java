/**
 * 
 */
package org.adempiere.process;

/*
 * #%L
 * de.metas.swat.base
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


import org.adempiere.exceptions.FillMandatoryException;
import org.adempiere.service.RolePermRevokeAccess;
import org.compiere.model.MRolePermRequest;

import de.metas.process.JavaProcess;
import de.metas.security.IUserRolePermissionsDAO;
import de.metas.util.Services;

/**
 * Revoke Permission
 * @author Teo Sarca, teo.sarca@gmail.com
 *
 */
public class AD_Role_RevokePermission extends JavaProcess
{
	private int p_AD_Role_PermRequest_ID = -1;
	@Override
	protected void prepare()
	{
		if (getTable_ID() == MRolePermRequest.Table_ID)
		{
			p_AD_Role_PermRequest_ID = getRecord_ID();
		}
	}
	
	@Override
	protected String doIt() throws Exception
	{
		if (p_AD_Role_PermRequest_ID <= 0)
			throw new FillMandatoryException(MRolePermRequest.COLUMNNAME_AD_Role_PermRequest_ID);
		//
		final MRolePermRequest req = new MRolePermRequest(getCtx(), p_AD_Role_PermRequest_ID, get_TrxName());
		
		RolePermRevokeAccess.revokeAccess(req);
		req.saveEx();
		//
		return "Ok";
	}

	@Override
	protected void postProcess(boolean success)
	{
		if (success)
		{
			Services.get(IUserRolePermissionsDAO.class).resetCacheAfterTrxCommit();
		}
	}
}
