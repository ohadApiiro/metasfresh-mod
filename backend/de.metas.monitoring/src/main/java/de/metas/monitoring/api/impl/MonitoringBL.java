package de.metas.monitoring.api.impl;

/*
 * #%L
 * de.metas.monitoring
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


import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import de.metas.monitoring.exception.MonitoringException;

public class MonitoringBL extends AbstractMonitoringBL
{

	@Override
	protected void registerJMX(final String jmxName, final Meter meter)
	{
		final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		final JMXMeterMBean jmxMeter = new JMXMeter(meter);

		final ObjectName name;
		try
		{
			name = new ObjectName(jmxName);
		}
		catch (MalformedObjectNameException e)
		{
			throw new MonitoringException("Unable to create jmx ObjectName", e);
		}

		try
		{
			synchronized (mbs)
			{
				if (!mbs.isRegistered(name))
				{
					mbs.registerMBean(jmxMeter, name);
				}
			}
		}
		catch (InstanceAlreadyExistsException e)
		{
			throw new MonitoringException("Unable to register mbean", e);
		}
		catch (MBeanRegistrationException e)
		{
			throw new MonitoringException("Unable to register mbean", e);
		}
		catch (NotCompliantMBeanException e)
		{
			throw new MonitoringException("Unable to register mbean", e);
		}
	}
}
