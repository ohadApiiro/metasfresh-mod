/*
 * #%L
 * de.metas.serviceprovider.base
 * %%
 * Copyright (C) 2022 metas GmbH
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

package de.metas.serviceprovider.effortcontrol;

import de.metas.organization.OrgId;
import de.metas.product.acct.api.ActivityId;
import de.metas.project.ProjectId;
import io.micrometer.core.lang.Nullable;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.Objects;

@Value
@Builder
public class EffortTarget
{
	@NonNull
	OrgId orgId;

	@NonNull
	ActivityId costCenterId;

	@NonNull
	ProjectId projectId;

	public static boolean equals(@Nullable final EffortTarget obj1, @Nullable final EffortTarget obj2)
	{
		return Objects.equals(obj1, obj2);
	}
}

