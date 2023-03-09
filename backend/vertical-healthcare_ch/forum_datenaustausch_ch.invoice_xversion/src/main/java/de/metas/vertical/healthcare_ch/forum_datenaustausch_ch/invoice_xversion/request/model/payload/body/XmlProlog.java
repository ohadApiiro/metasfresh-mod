package de.metas.vertical.healthcare_ch.forum_datenaustausch_ch.invoice_xversion.request.model.payload.body;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import javax.annotation.Nullable;

import de.metas.vertical.healthcare_ch.forum_datenaustausch_ch.invoice_xversion.request.model.payload.body.prolog.XmlSoftware;
import de.metas.vertical.healthcare_ch.forum_datenaustausch_ch.invoice_xversion.request.model.payload.body.prolog.XmlSoftware.SoftwareMod;

/*
 * #%L
 * vertical-healthcare_ch.invoice_gateway.forum_datenaustausch_ch.invoice_commons
 * %%
 * Copyright (C) 2018 metas GmbH
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

@Value
@Builder(toBuilder = true)
public class XmlProlog
{
	/** "package" */
	@Nullable
	XmlSoftware pkg;

	@NonNull
	XmlSoftware generator;

	public XmlProlog withMod(@Nullable PrologMod prologMod)
	{
		if (prologMod == null)
		{
			return this;
		}

		return toBuilder()
				.pkg(pkg.withMod(prologMod.getPkgMod()))
				.pkg(generator.withMod(prologMod.getGeneratorMod()))
				.build();
	}

	@Value
	@Builder
	public static class PrologMod
	{
		@Nullable
		SoftwareMod pkgMod;

		@Nullable
		SoftwareMod generatorMod;
	}
}
