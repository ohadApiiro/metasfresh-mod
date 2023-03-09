/*
 * #%L
 * de.metas.business
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

package de.metas.project.workorder.project;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import de.metas.calendar.util.CalendarDateRange;
import de.metas.product.ResourceId;
import de.metas.project.ProjectId;
import de.metas.project.workorder.calendar.WOProjectCalendarQuery;
import de.metas.project.workorder.calendar.WOProjectResourceCalendarQuery;
import de.metas.project.workorder.resource.WOProjectResource;
import de.metas.project.workorder.resource.WOProjectResourceId;
import de.metas.project.workorder.resource.WOProjectResourceRepository;
import de.metas.project.workorder.resource.WOProjectResources;
import de.metas.project.workorder.resource.WOProjectResourcesCollection;
import de.metas.project.workorder.step.WOProjectStep;
import de.metas.project.workorder.step.WOProjectStepId;
import de.metas.project.workorder.step.WOProjectStepRepository;
import de.metas.project.workorder.step.WOProjectSteps;
import de.metas.util.InSetPredicate;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.UnaryOperator;

@Service
public class WOProjectService
{
	private final WOProjectRepository woProjectRepository;
	private final WOProjectResourceRepository woProjectResourceRepository;
	private final WOProjectStepRepository woProjectStepRepository;

	public WOProjectService(
			final WOProjectRepository woProjectRepository,
			final WOProjectResourceRepository woProjectResourceRepository,
			final WOProjectStepRepository woProjectStepRepository)
	{
		this.woProjectRepository = woProjectRepository;
		this.woProjectResourceRepository = woProjectResourceRepository;
		this.woProjectStepRepository = woProjectStepRepository;
	}

	@NonNull
	public WOProject getById(@NonNull final ProjectId projectId)
	{
		return woProjectRepository.getById(projectId);
	}

	@NonNull
	public List<WOProject> getAllActiveProjects(@NonNull final Set<ProjectId> projectIds)
	{
		return woProjectRepository.getAllActiveProjectsByProjectCalendarQuery(WOProjectCalendarQuery.builder()
				.projectIds(InSetPredicate.only(projectIds))
				.build());
	}

	@NonNull
	public ImmutableSet<ProjectId> getActiveProjectIds(@NonNull final WOProjectCalendarQuery query)
	{
		return woProjectRepository.getActiveProjectIdsByProjectCalendarQuery(query);
	}

	@NonNull
	public ImmutableList<WOProjectResource> getResources(@NonNull final WOProjectResourceCalendarQuery query)
	{
		final InSetPredicate<WOProjectResourceId> projectResourceIds = woProjectResourceRepository.getProjectResourceIdsPredicate(query);
		if (projectResourceIds.isNone())
		{
			return ImmutableList.of();
		}

		return woProjectResourceRepository.getByIds(projectResourceIds);
	}

	public WOProjectResources getResourcesByProjectId(@NonNull final ProjectId projectId)
	{
		return woProjectResourceRepository.getByProjectId(projectId);
	}

	public ImmutableSet<ResourceId> getResourceIdsByProjectResourceIds(@NonNull final Set<WOProjectResourceId> projectResourceIds)
	{
		return woProjectResourceRepository.getResourceIdsByProjectResourceIds(projectResourceIds);
	}

	public WOProjectSteps getStepsByProjectId(@NonNull final ProjectId projectId)
	{
		return woProjectStepRepository.getStepsByProjectId(projectId);
	}

	public ImmutableList<WOProjectStep> getStepsByIds(@NonNull final Set<WOProjectStepId> stepIds)
	{
		return woProjectStepRepository.getByIds(stepIds);
	}

	public void updateStepsDateRange(@NonNull final Set<WOProjectStepId> projectStepIds)
	{
		if (projectStepIds.isEmpty())
		{
			return;
		}

		final ImmutableSet<ProjectId> projectIds = projectStepIds.stream().map(WOProjectStepId::getProjectId).collect(ImmutableSet.toImmutableSet());
		final WOProjectResourcesCollection resourcesByProjectId = woProjectResourceRepository.getByProjectIds(projectIds);

		final HashMap<WOProjectStepId, CalendarDateRange> stepDateRanges = new HashMap<>();
		for (final WOProjectStepId projectStepId : projectStepIds)
		{
			final ImmutableList<CalendarDateRange> resourceDateRanges = resourcesByProjectId
					.getByProjectId(projectStepId.getProjectId())
					.streamByStepId(projectStepId)
					.map(WOProjectResource::getDateRange)
					.filter(Objects::nonNull)
					.distinct()
					.collect(ImmutableList.toImmutableList());

			if (!resourceDateRanges.isEmpty())
			{
				final CalendarDateRange stepDateRange = CalendarDateRange.span(resourceDateRanges);
				stepDateRanges.put(projectStepId, stepDateRange);
			}
		}

		woProjectStepRepository.updateStepDateRanges(stepDateRanges);
	}

	public void updateProjectResourcesByIds(
			@NonNull final Set<WOProjectResourceId> projectResourceIds,
			@NonNull final UnaryOperator<WOProjectResource> mapper)
	{
		woProjectResourceRepository.updateProjectResourcesByIds(projectResourceIds, mapper);
	}
}
