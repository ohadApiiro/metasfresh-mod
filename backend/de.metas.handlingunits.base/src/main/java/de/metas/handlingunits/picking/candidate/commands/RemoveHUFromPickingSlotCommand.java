package de.metas.handlingunits.picking.candidate.commands;

import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import de.metas.handlingunits.HuId;
import de.metas.handlingunits.picking.IHUPickingSlotBL;
import de.metas.handlingunits.picking.PickingCandidate;
import de.metas.handlingunits.picking.PickingCandidateRepository;
import de.metas.picking.api.PickingSlotId;
import de.metas.util.Services;
import lombok.Builder;
import lombok.NonNull;

/*
 * #%L
 * de.metas.handlingunits.base
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

public class RemoveHUFromPickingSlotCommand
{
	private final IHUPickingSlotBL huPickingSlotBL = Services.get(IHUPickingSlotBL.class);
	private final PickingCandidateRepository pickingCandidateRepository;

	private final HuId huId;

	@Builder
	private RemoveHUFromPickingSlotCommand(
			@NonNull final PickingCandidateRepository pickingCandidateRepository,
			@NonNull final HuId huId)
	{
		this.pickingCandidateRepository = pickingCandidateRepository;
		this.huId = huId;
	}

	public void perform()
	{
		final List<PickingCandidate> candidates = retrievePickingCandidates();
		final Set<PickingSlotId> pickingSlotIds = PickingCandidate.extractPickingSlotIds(candidates);

		pickingCandidateRepository.deletePickingCandidates(candidates);
		huPickingSlotBL.releasePickingSlotsIfPossible(pickingSlotIds);

	}

	private List<PickingCandidate> retrievePickingCandidates()
	{
		return pickingCandidateRepository.getByHUIds(ImmutableSet.of(huId));
	}

}
