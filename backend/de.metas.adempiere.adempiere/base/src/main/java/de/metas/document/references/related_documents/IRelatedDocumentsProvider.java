/*
 * #%L
 * de.metas.adempiere.adempiere.base
 * %%
 * Copyright (C) 2021 metas GmbH
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

package de.metas.document.references.related_documents;

import lombok.NonNull;
import org.adempiere.ad.element.api.AdWindowId;

import javax.annotation.Nullable;
import java.util.List;

public interface IRelatedDocumentsProvider
{
	/**
	 * @param fromDocument         the fromDocument we need zoom targets for
	 * @param targetWindowId optional target window ID; if specified, only those {@link RelatedDocuments}s will be returned which have this targetWindowId.
	 */
	List<RelatedDocumentsCandidateGroup> retrieveRelatedDocumentsCandidates(
			@NonNull IZoomSource fromDocument,
			@Nullable AdWindowId targetWindowId);
}
