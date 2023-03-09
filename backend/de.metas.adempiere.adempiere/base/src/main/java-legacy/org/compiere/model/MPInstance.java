/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.ad.trx.api.ITrx;
import com.google.common.base.MoreObjects;

/**
 *  Process Instance Model
 *
 *  @author Jorg Janke
 *  @version $Id: MPInstance.java,v 1.3 2006/07/30 00:58:36 jjanke Exp $
 *
 * @author Teo Sarca, www.arhipac.ro
 * 		<li>FR [ 2818478 ] Introduce MPInstance.createParameter helper method
 * 			https://sourceforge.net/tracker/?func=detail&aid=2818478&group_id=176962&atid=879335
 */
@Deprecated
public class MPInstance extends X_AD_PInstance
{
	// NOTE: the only reason why we are still keeping it is because we want to enforce TRXNAME_None on load

	/**
	 *
	 */
	private static final long serialVersionUID = -3627385062090630722L;

	public MPInstance(final Properties ctx, final int AD_PInstance_ID, final String trxName_IGNORED)
	{
		super (ctx, AD_PInstance_ID, ITrx.TRXNAME_None);

		// metas: WARN developer if he/she is loading the AD_PInstance using transactions (because that is not allowed)
		// gh #489: I agree with warning the developer, but in DLM, we frequently use this constructor and I neither want this warning to fill the log,
		// nor want an if in there to explicitly deal with this case.
//		if (!Check.equals(ITrx.TRXNAME_None, trxName_IGNORED) && Services.get(IDeveloperModeBL.class).isEnabled())
//		{
//			final AdempiereException ex = new AdempiereException("Warning: AD_PInstance was loaded using trxName '" + trxName_IGNORED + "' while only '" + ITrx.TRXNAME_None + "' is allowed.");
//			log.warn(ex.getLocalizedMessage(), ex);
//		}

		//	New Process
		if (AD_PInstance_ID == 0)
		{
		//	setAD_Process_ID (0);	//	parent
		//	setRecord_ID (0);
			setIsProcessing (false);
		}
	}	//	MPInstance

	public MPInstance(final Properties ctx, final ResultSet rs, final String ignored)
	{
		super(ctx, rs, ITrx.TRXNAME_None);
	}	//	MPInstance

	@Override
	public String toString ()
	{
		return MoreObjects.toStringHelper(this)
				.add("AD_PInstance_ID", getAD_PInstance_ID())
				.add("Result", getResult())
				.add("ErrorMsg", getErrorMsg())
				.toString();
	}	//	toString

	@Override
	protected boolean beforeSave(final boolean newRecord)
	{
		return super.beforeSave(newRecord);
		}
		}
