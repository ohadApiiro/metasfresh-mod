/*
 * #%L
 * de-metas-common-rest_api
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

package de.metas.common.rest_api.v2.project.workorder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;
import de.metas.common.rest_api.common.JsonExternalId;
import de.metas.common.rest_api.common.JsonMetasfreshId;
import de.metas.common.rest_api.v2.SyncAdvise;
import de.metas.common.util.CoalesceUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

import static de.metas.common.rest_api.v2.SwaggerDocConstants.PROJECT_IDENTIFIER_DOC;

@Getter
@ToString
@EqualsAndHashCode
public class JsonWorkOrderProjectUpsertRequest
{
	@ApiModelProperty(position = 10,
			required = true,
			value = PROJECT_IDENTIFIER_DOC) //
	@Setter
	String identifier;

	@ApiModelProperty(required = true)
	@Setter
	JsonMetasfreshId projectTypeId;

	@ApiModelProperty(required = true)
	@Setter
	SyncAdvise syncAdvise;

	String value;

	@ApiModelProperty(hidden = true)
	boolean valueSet;

	String name;

	@ApiModelProperty(hidden = true)
	boolean nameSet;

	JsonMetasfreshId priceListVersionId;

	@ApiModelProperty(hidden = true)
	boolean priceListVersionIdSet;

	String currencyCode;

	@ApiModelProperty(hidden = true)
	boolean currencyCodeSet;

	JsonMetasfreshId salesRepId;

	@ApiModelProperty(hidden = true)
	boolean salesRepIdSet;

	String description;

	@ApiModelProperty(hidden = true)
	boolean descriptionSet;

	LocalDate dateContract;

	@ApiModelProperty(hidden = true)
	boolean dateContractSet;

	LocalDate dateFinish;

	@ApiModelProperty(hidden = true)
	boolean dateFinishSet;

	JsonMetasfreshId bpartnerId;

	@ApiModelProperty(hidden = true)
	boolean bpartnerIdSet;

	@ApiModelProperty("Translates to `C_Project.C_Project_Reference_Ext`.")
	String projectReferenceExt;

	@ApiModelProperty(hidden = true)
	boolean projectReferenceExtSet;

	JsonExternalId externalId;

	@ApiModelProperty(hidden = true)
	boolean externalIdSet;
	
	JsonMetasfreshId projectParentId;

	@ApiModelProperty(hidden = true)
	boolean projectParentIdSet;

	@ApiModelProperty(required = true)
	String orgCode;

	@ApiModelProperty(hidden = true)
	boolean orgCodeSet;

	@ApiModelProperty(value = "If not specified but required (e.g. because a new project is created), then `true` is assumed")
	Boolean isActive;

	@ApiModelProperty(hidden = true)
	boolean activeSet;

	String bpartnerDepartment;

	@ApiModelProperty(hidden = true)
	boolean bpartnerDepartmentSet;

	private String woOwner;

	@ApiModelProperty(hidden = true)
	private boolean woOwnerSet;

	private String poReference;

	@ApiModelProperty(hidden = true)
	private boolean poReferenceSet;

	private LocalDate bpartnerTargetDate;

	@ApiModelProperty(hidden = true)
	private boolean bpartnerTargetDateSet;

	private LocalDate woProjectCreatedDate;

	@ApiModelProperty(hidden = true)
	private boolean woProjectCreatedDateSet;

	private LocalDate dateOfProvisionByBPartner;

	@ApiModelProperty(hidden = true)
	private boolean dateOfProvisionByBPartnerSet;

	private List<JsonWorkOrderStepUpsertItemRequest> steps = ImmutableList.of();

	private List<JsonWorkOrderObjectUnderTestUpsertItemRequest> objectsUnderTest = ImmutableList.of();

	public void setValue(final String value)
	{
		this.value = value;
		this.valueSet = true;
	}

	public void setName(final String name)
	{
		this.name = name;
		this.nameSet = true;
	}

	public void setPriceListVersionId(final JsonMetasfreshId priceListVersionId)
	{
		this.priceListVersionId = priceListVersionId;
		this.priceListVersionIdSet = true;
	}

	public void setCurrencyCode(final String currencyCode)
	{
		this.currencyCode = currencyCode;
		this.currencyCodeSet = true;
	}

	public void setSalesRepId(final JsonMetasfreshId salesRepId)
	{
		this.salesRepId = salesRepId;
		this.salesRepIdSet = true;
	}

	public void setDescription(final String description)
	{
		this.description = description;
		this.descriptionSet = true;
	}

	public void setDateContract(final LocalDate dateContract)
	{
		this.dateContract = dateContract;
		this.dateContractSet = true;
	}

	public void setDateFinish(final LocalDate dateFinish)
	{
		this.dateFinish = dateFinish;
		this.dateFinishSet = true;
	}

	public void setBpartnerId(final JsonMetasfreshId bpartnerId)
	{
		this.bpartnerId = bpartnerId;
		this.bpartnerIdSet = true;
	}

	public void setProjectReferenceExt(final String projectReferenceExt)
	{
		this.projectReferenceExt = projectReferenceExt;
		this.projectReferenceExtSet = true;
	}

	public void setExternalId(final JsonExternalId externalId)
	{
		this.externalId = externalId;
		this.externalIdSet = true;
	}
		
	public void setProjectParentId(final JsonMetasfreshId projectParentId)
	{
		this.projectParentId = projectParentId;
		this.projectParentIdSet = true;
	}

	public void setOrgCode(final String orgCode)
	{
		this.orgCode = orgCode;
		this.orgCodeSet = true;
	}

	public void setIsActive(final Boolean active)
	{
		isActive = active;
		this.activeSet = true;
	}

	public void setSteps(final List<JsonWorkOrderStepUpsertItemRequest> steps)
	{
		this.steps = CoalesceUtil.coalesceNotNull(steps, ImmutableList.of());
	}

	public void setBpartnerDepartment(final String bpartnerDepartment)
	{
		this.bpartnerDepartment = bpartnerDepartment;
		this.bpartnerDepartmentSet = true;
	}

	public void setWoOwner(final String woOwner)
	{
		this.woOwner = woOwner;
		this.woOwnerSet = true;
	}

	public void setPoReference(final String poReference)
	{
		this.poReference = poReference;
		this.poReferenceSet = true;
	}

	public void setBpartnerTargetDate(final LocalDate bpartnerTargetDate)
	{
		this.bpartnerTargetDate = bpartnerTargetDate;
		this.bpartnerTargetDateSet = true;
	}

	public void setWoProjectCreatedDate(final LocalDate woProjectCreatedDate)
	{
		this.woProjectCreatedDate = woProjectCreatedDate;
		this.woProjectCreatedDateSet = true;
	}

	public void setDateOfProvisionByBPartner(final LocalDate dateOfProvisionByBPartner)
	{
		this.dateOfProvisionByBPartner = dateOfProvisionByBPartner;
		this.dateOfProvisionByBPartnerSet = true;
	}

	public void setObjectsUnderTest(final List<JsonWorkOrderObjectUnderTestUpsertItemRequest> objectsUnderTest)
	{
		this.objectsUnderTest = CoalesceUtil.coalesceNotNull(objectsUnderTest, ImmutableList.of());
	}

	@JsonIgnore
	@NonNull
	public <T> T mapProjectIdentifier(@NonNull final Function<String,T> mappingFunction)
	{
		return mappingFunction.apply(identifier);
	}
}