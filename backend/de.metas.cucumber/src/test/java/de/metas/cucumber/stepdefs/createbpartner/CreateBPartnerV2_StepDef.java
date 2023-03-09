/*
 * #%L
 * de.metas.cucumber
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

package de.metas.cucumber.stepdefs.createbpartner;

import de.metas.bpartner.service.BPartnerCreditLimitRepository;
import de.metas.bpartner.service.IBPartnerDAO;
import de.metas.common.bpartner.v2.response.JsonResponseBPartner;
import de.metas.common.bpartner.v2.response.JsonResponseComposite;
import de.metas.common.bpartner.v2.response.JsonResponseContact;
import de.metas.common.bpartner.v2.response.JsonResponseLocation;
import de.metas.cucumber.stepdefs.AD_User_StepDefData;
import de.metas.cucumber.stepdefs.C_BPartner_StepDefData;
import de.metas.cucumber.stepdefs.DataTableUtil;
import de.metas.cucumber.stepdefs.context.TestContext;
import de.metas.cucumber.stepdefs.incoterms.C_Incoterms_StepDefData;
import de.metas.cucumber.stepdefs.org.AD_Org_StepDefData;
import de.metas.cucumber.stepdefs.paymentterm.C_PaymentTerm_StepDefData;
import de.metas.cucumber.stepdefs.sectioncode.M_SectionCode_StepDefData;
import de.metas.externalreference.ExternalIdentifier;
import de.metas.rest_api.v2.bpartner.BPartnerEndpointService;
import de.metas.util.Check;
import de.metas.util.Services;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.NonNull;
import org.adempiere.ad.dao.IQueryBL;
import org.adempiere.ad.dao.IQueryBuilder;
import org.assertj.core.api.SoftAssertions;
import org.compiere.SpringContextHolder;
import org.compiere.model.I_AD_Org;
import org.compiere.model.I_AD_User;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.I_C_BPartner_CreditLimit;
import org.compiere.model.I_C_BPartner_Location;
import org.compiere.model.I_C_CreditLimit_Type;
import org.compiere.model.I_C_Incoterms;
import org.compiere.model.I_C_PaymentTerm;
import org.compiere.model.I_M_SectionCode;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static de.metas.cucumber.stepdefs.StepDefConstants.TABLECOLUMN_IDENTIFIER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.compiere.model.I_C_BPartner.COLUMNNAME_C_BPartner_ID;
import static org.compiere.model.I_C_BPartner.COLUMNNAME_IsStorageWarehouse;

public class CreateBPartnerV2_StepDef
{
	private static final String BPARTNER_ENDPOINT_PATH = "api/v2/bpartner";

	private final BPartnerEndpointService bpartnerEndpointService;
	private final C_BPartner_StepDefData bPartnerTable;
	private final AD_User_StepDefData userTable;
	private final M_SectionCode_StepDefData sectionCodeTable;
	private final C_Incoterms_StepDefData incotermsTable;
	private final C_PaymentTerm_StepDefData paymentTermTable;
	private final TestContext testContext;
	private final AD_Org_StepDefData orgTable;

	private final IBPartnerDAO bpartnerDAO = Services.get(IBPartnerDAO.class);
	private final IQueryBL queryBL = Services.get(IQueryBL.class);

	private final BPartnerCreditLimitRepository bPartnerCreditLimitRepository;

	public CreateBPartnerV2_StepDef(
			@NonNull final C_BPartner_StepDefData bPartnerTable,
			@NonNull final AD_User_StepDefData userTable,
			@NonNull final M_SectionCode_StepDefData sectionCodeTable,
			@NonNull final C_Incoterms_StepDefData incotermsTable,
			@NonNull final C_PaymentTerm_StepDefData paymentTermTable,
			@NonNull final TestContext testContext,
			@NonNull final AD_Org_StepDefData orgTable)
	{
		this.bPartnerTable = bPartnerTable;
		this.userTable = userTable;
		this.sectionCodeTable = sectionCodeTable;
		this.incotermsTable = incotermsTable;
		this.paymentTermTable = paymentTermTable;
		this.testContext = testContext;
		this.orgTable = orgTable;
		this.bpartnerEndpointService = SpringContextHolder.instance.getBean(BPartnerEndpointService.class);
		this.bPartnerCreditLimitRepository = SpringContextHolder.instance.getBean(BPartnerCreditLimitRepository.class);
	}

	@Then("^verify that bPartner was (updated|created) for externalIdentifier$")
	public void verify_bPartner_was_created_for_externalIdentifier_v2(@NonNull final String action, @NonNull final DataTable dataTable)
	{
		final List<Map<String, String>> bpartnerTableList = dataTable.asMaps();
		for (final Map<String, String> dataTableRow : bpartnerTableList)
		{
			final SoftAssertions softly = new SoftAssertions();

			final String externalIdentifier = DataTableUtil.extractStringForColumnName(dataTableRow, "externalIdentifier");
			final String code = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.Code");
			final String name = DataTableUtil.extractStringForColumnName(dataTableRow, "Name");
			final String companyName = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.CompanyName");
			final String parentId = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.ParentId");
			final String phone = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.Phone");
			final String language = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.Language");
			final String url = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.Url");
			final String group = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.Group");
			final String vatId = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.VatId");
			final String pricingSystemId = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_M_PricingSystem_ID);
			final Boolean storageWarehouse = DataTableUtil.extractBooleanForColumnNameOr(dataTableRow, "OPT." + COLUMNNAME_IsStorageWarehouse, false);
			final String orgIdentifier = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_AD_Org.COLUMNNAME_AD_Org_ID + "." + TABLECOLUMN_IDENTIFIER);

			final I_AD_Org org = Optional.ofNullable(orgIdentifier)
					.map(orgTable::get)
					.orElse(null);

			final String orgCode = Optional.ofNullable(org)
					.map(I_AD_Org::getValue)
					.orElse(null);

			// persisted value
			final Optional<JsonResponseComposite> persistedResult = bpartnerEndpointService.retrieveBPartner(orgCode, ExternalIdentifier.of(externalIdentifier));

			final JsonResponseBPartner persistedBPartner = persistedResult.get().getBpartner();

			softly.assertThat(persistedBPartner.getName()).isEqualTo(name);
			softly.assertThat(persistedBPartner.getStorageWarehouse()).isEqualTo(storageWarehouse);

			if (Check.isNotBlank(code))
			{
				softly.assertThat(persistedBPartner.getCode()).isEqualTo(code);
			}

			if (Check.isNotBlank(companyName))
			{
				softly.assertThat(persistedBPartner.getCompanyName()).isEqualTo(companyName);
			}

			if (Check.isNotBlank(url))
			{
				softly.assertThat(persistedBPartner.getUrl()).isEqualTo(url);
			}

			if (Check.isNotBlank(vatId))
			{
				softly.assertThat(persistedBPartner.getVatId()).isEqualTo(vatId);
			}

			if (Check.isNotBlank(phone))
			{
				softly.assertThat(persistedBPartner.getPhone()).isEqualTo(phone);
			}

			if (Check.isNotBlank(language))
			{
				softly.assertThat(persistedBPartner.getLanguage()).contains(language);
			}

			if (Check.isNotBlank(group))
			{
				softly.assertThat(persistedBPartner.getGroup()).isEqualTo(group);
			}

			if (Check.isNotBlank(parentId))
			{
				softly.assertThat(persistedBPartner.getParentId().getValue()).isEqualTo(Integer.parseInt(parentId));
			}

			if (Check.isNotBlank(pricingSystemId))
			{
				assertThat(persistedBPartner.getPricingSystemId()).isNotNull();
				assertThat(persistedBPartner.getPricingSystemId().getValue()).isEqualTo(Integer.parseInt(pricingSystemId));
			}

			final I_C_BPartner bPartnerRecord = bpartnerDAO.getById(persistedBPartner.getMetasfreshId().getValue());

			final String createdByIdentifier = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_CreatedBy);
			if (Check.isNotBlank(createdByIdentifier))
			{
				final I_AD_User userRecord = userTable.get(createdByIdentifier);

				softly.assertThat(userRecord).isNotNull();
				softly.assertThat(bPartnerRecord.getCreatedBy()).isEqualTo(userRecord.getAD_User_ID());
			}

			final String sectionCodeIdentifier = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_M_SectionCode_ID + "." + TABLECOLUMN_IDENTIFIER);
			if (Check.isNotBlank(sectionCodeIdentifier))
			{
				final I_M_SectionCode sectionCode = sectionCodeTable.get(sectionCodeIdentifier);

				softly.assertThat(bPartnerRecord.getM_SectionCode_ID()).isEqualTo(sectionCode.getM_SectionCode_ID());
			}

			final String description = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_Description);
			if (Check.isNotBlank(description))
			{
				softly.assertThat(bPartnerRecord.getDescription()).isEqualTo(description);
			}

			final String deliveryRule = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_DeliveryRule);
			if (Check.isNotBlank(deliveryRule))
			{
				softly.assertThat(bPartnerRecord.getDeliveryRule()).isEqualTo(deliveryRule);
			}

			final String deliveryViaRule = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_DeliveryViaRule);
			if (Check.isNotBlank(deliveryViaRule))
			{
				softly.assertThat(bPartnerRecord.getDeliveryViaRule()).isEqualTo(deliveryViaRule);
			}

			final String incotermsCustomerIdentifier = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_C_Incoterms_Customer_ID + "." + TABLECOLUMN_IDENTIFIER);
			if (Check.isNotBlank(incotermsCustomerIdentifier))
			{
				final I_C_Incoterms customerIncoterms = incotermsTable.get(incotermsCustomerIdentifier);

				softly.assertThat(bPartnerRecord.getC_Incoterms_Customer_ID()).isEqualTo(customerIncoterms.getC_Incoterms_ID());
			}

			final String incotermsVendorIdentifier = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_C_Incoterms_Vendor_ID + "." + TABLECOLUMN_IDENTIFIER);
			if (Check.isNotBlank(incotermsVendorIdentifier))
			{
				final I_C_Incoterms vendorIncoterms = incotermsTable.get(incotermsVendorIdentifier);

				softly.assertThat(bPartnerRecord.getC_Incoterms_Vendor_ID()).isEqualTo(vendorIncoterms.getC_Incoterms_ID());
			}

			final String paymentRule = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_PaymentRule);
			if (Check.isNotBlank(paymentRule))
			{
				softly.assertThat(bPartnerRecord.getPaymentRule()).isEqualTo(paymentRule);
			}

			final String paymentRulePO = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_PaymentRulePO);
			if (Check.isNotBlank(paymentRulePO))
			{
				softly.assertThat(bPartnerRecord.getPaymentRulePO()).isEqualTo(paymentRulePO);
			}

			final String customerPaymentTermIdentifier = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_C_PaymentTerm_ID + "." + TABLECOLUMN_IDENTIFIER);
			if (Check.isNotBlank(customerPaymentTermIdentifier))
			{
				final I_C_PaymentTerm customerPaymentTerm = paymentTermTable.get(customerPaymentTermIdentifier);

				softly.assertThat(bPartnerRecord.getC_PaymentTerm_ID()).isEqualTo(customerPaymentTerm.getC_PaymentTerm_ID());
			}

			final String vendorPaymentTermIdentifier = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_PO_PaymentTerm_ID + "." + TABLECOLUMN_IDENTIFIER);
			if (Check.isNotBlank(vendorPaymentTermIdentifier))
			{
				final I_C_PaymentTerm vendorPaymentTerm = paymentTermTable.get(vendorPaymentTermIdentifier);

				softly.assertThat(bPartnerRecord.getPO_PaymentTerm_ID()).isEqualTo(vendorPaymentTerm.getC_PaymentTerm_ID());
			}

			final String sectionGroupPartnerIdentifier = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_Section_Group_Partner_ID + "." + TABLECOLUMN_IDENTIFIER);
			if (Check.isNotBlank(sectionGroupPartnerIdentifier))
			{
				final I_C_BPartner sectionGroupPartner = bPartnerTable.get(sectionGroupPartnerIdentifier);
				softly.assertThat(bPartnerRecord.getSection_Group_Partner_ID()).isEqualTo(sectionGroupPartner.getC_BPartner_ID());
			}

			final Boolean isProspect = DataTableUtil.extractBooleanForColumnNameOrNull(dataTableRow, "OPT." + I_C_BPartner.COLUMNNAME_IsProspect);
			if(isProspect != null)
			{
				softly.assertThat(bPartnerRecord.isProspect()).isEqualTo(isProspect);
			}

			softly.assertAll();

			if (org != null)
			{
				assertThat(bPartnerRecord.getAD_Org_ID()).isEqualTo(org.getAD_Org_ID());
			}

			final String bpartnerIdentifier = DataTableUtil.extractStringForColumnName(dataTableRow, COLUMNNAME_C_BPartner_ID + "." + TABLECOLUMN_IDENTIFIER);
			bPartnerTable.putOrReplace(bpartnerIdentifier, bPartnerRecord);
		}
	}

	@And("^verify that location was (updated|created) for bpartner$")
	public void verify_location_is_created_for_bpartner_v2(@NonNull final String action, @NonNull final DataTable dataTable)
	{
		final List<Map<String, String>> locationsTableList = dataTable.asMaps();
		for (final Map<String, String> dataTableRow : locationsTableList)
		{
			final SoftAssertions softly = new SoftAssertions();

			final String bpartnerIdentifier = DataTableUtil.extractStringForColumnName(dataTableRow, "bpartnerIdentifier");
			final String locationIdentifier = DataTableUtil.extractStringForColumnName(dataTableRow, "locationIdentifier");
			final String address1 = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.Address1");
			final String address2 = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.Address2");
			final String postal = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.Postal");
			final String poBox = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.PoBox");
			final String district = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.District");
			final String region = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.Region");
			final String city = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.City");
			final String countryCode = DataTableUtil.extractStringForColumnName(dataTableRow, "CountryCode");
			final String gln = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.Gln");
			final boolean handoverLocation = DataTableUtil.extractBooleanForColumnNameOr(dataTableRow, "OPT." + I_C_BPartner_Location.COLUMNNAME_IsHandOverLocation, false);
			final boolean remitTo = DataTableUtil.extractBooleanForColumnNameOr(dataTableRow, "OPT." + I_C_BPartner_Location.COLUMNNAME_IsRemitTo, false);
			final boolean replicationLookupDefault = DataTableUtil.extractBooleanForColumnNameOr(dataTableRow, "OPT." + I_C_BPartner_Location.COLUMNNAME_IsReplicationLookupDefault, false);
			final String vatId = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.VATaxId");
			final String sapPaymentMethod = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.SAP_PaymentMethod");

			// persisted value
			final Optional<JsonResponseLocation> persistedResult = bpartnerEndpointService.retrieveBPartnerLocation(
					null, ExternalIdentifier.of(bpartnerIdentifier), ExternalIdentifier.of(locationIdentifier));
			final JsonResponseLocation persistedLocation = persistedResult.get();

			softly.assertThat(persistedLocation.getAddress1()).isEqualTo(address1);
			softly.assertThat(persistedLocation.getAddress2()).isEqualTo(address2);
			softly.assertThat(persistedLocation.getPostal()).isEqualTo(postal);
			softly.assertThat(persistedLocation.getPoBox()).isEqualTo(poBox);
			softly.assertThat(persistedLocation.getRegion()).isEqualTo(region);
			softly.assertThat(persistedLocation.getCountryCode()).isEqualTo(countryCode);
			softly.assertThat(persistedLocation.getCity()).isEqualTo(city);
			softly.assertThat(persistedLocation.getDistrict()).isEqualTo(DataTableUtil.extractValueOrNull(district));
			softly.assertThat(persistedLocation.getGln()).isEqualTo(gln);
			softly.assertThat(persistedLocation.isHandoverLocation()).isEqualTo(handoverLocation);
			softly.assertThat(persistedLocation.isRemitTo()).isEqualTo(remitTo);
			softly.assertThat(persistedLocation.isReplicationLookupDefault()).isEqualTo(replicationLookupDefault);
			softly.assertThat(persistedLocation.getVatId()).isEqualTo(vatId);
			softly.assertThat(persistedLocation.getSapPaymentMethod()).isEqualTo(sapPaymentMethod);

			softly.assertAll();
		}
	}

	@And("^verify that contact was (updated|created|not modified) for bpartner$")
	public void verify_contact_is_created_for_bpartner_v2(@NonNull final String action, @NonNull final DataTable dataTable)
	{
		final List<Map<String, String>> contactsTableList = dataTable.asMaps();
		for (final Map<String, String> dataTableRow : contactsTableList)
		{
			final String bpartnerIdentifier = DataTableUtil.extractStringForColumnName(dataTableRow, "bpartnerIdentifier");
			final String contactIdentifier = DataTableUtil.extractStringForColumnName(dataTableRow, "contactIdentifier");
			final String name = DataTableUtil.extractStringForColumnName(dataTableRow, "Name");
			final String email = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.Email");
			final String fax = DataTableUtil.extractStringOrNullForColumnName(dataTableRow, "OPT.Fax");
			final Boolean isInvoiceEmailEnabled = DataTableUtil.extractBooleanForColumnNameOr(dataTableRow, "OPT.InvoiceEmailEnabled", null);

			// persisted value
			final Optional<JsonResponseContact> persistedResult = bpartnerEndpointService.retrieveBPartnerContact(
					null, ExternalIdentifier.of(bpartnerIdentifier), ExternalIdentifier.of(contactIdentifier));
			final JsonResponseContact persistedContact = persistedResult.get();

			assertThat(persistedContact.getEmail()).isEqualTo(email);
			assertThat(persistedContact.getName()).isEqualTo(name);
			assertThat(persistedContact.getFax()).isEqualTo(fax);
			assertThat(persistedContact.getInvoiceEmailEnabled()).isEqualTo(isInvoiceEmailEnabled);
		}
	}

	@And("build BPartner Endpoint Path and store it in context")
	public void storeEndpointPathInContext(@NonNull final DataTable dataTable)
	{
		final List<Map<String, String>> locationsTableList = dataTable.asMaps();
		for (final Map<String, String> row : locationsTableList)
		{
			final String bpartnerIdentifier = DataTableUtil.extractStringForColumnName(row, COLUMNNAME_C_BPartner_ID + "." + TABLECOLUMN_IDENTIFIER);
			final I_C_BPartner bPartner = bPartnerTable.get(bpartnerIdentifier);

			testContext.setEndpointPath(BPARTNER_ENDPOINT_PATH + "/" + bPartner.getC_BPartner_ID());
		}
	}

	@And("^verify that credit limit was created for bpartner: (.*)$")
	public void verify_credit_limit_is_created_for_bpartner_v2(@NonNull final String bPartnerIdentifier, @NonNull final DataTable dataTable)
	{
		final I_C_BPartner bPartner = bPartnerTable.get(bPartnerIdentifier);
		assertThat(bPartner).isNotNull();

		final List<Map<String, String>> contactsTableList = dataTable.asMaps();
		for (final Map<String, String> dataTableRow : contactsTableList)
		{
			final BigDecimal amount = DataTableUtil.extractBigDecimalForColumnName(dataTableRow, I_C_BPartner_CreditLimit.COLUMNNAME_Amount);
			final String creditLimitTypeName = DataTableUtil.extractStringForColumnName(dataTableRow, I_C_CreditLimit_Type.Table_Name + "." + I_C_CreditLimit_Type.COLUMNNAME_Name);
			final Boolean isActive = DataTableUtil.extractBooleanForColumnName(dataTableRow, I_C_BPartner_CreditLimit.COLUMNNAME_IsActive);
			final Timestamp dateFrom = DataTableUtil.extractDateTimestampForColumnNameOrNull(dataTableRow, "OPT." + I_C_BPartner_CreditLimit.COLUMNNAME_DateFrom);
			final Boolean processed = DataTableUtil.extractBooleanForColumnName(dataTableRow, I_C_BPartner_CreditLimit.COLUMNNAME_Processed);
			final String approvedById = DataTableUtil.extractNullableStringForColumnName(dataTableRow, "OPT." + I_C_BPartner_CreditLimit.COLUMNNAME_ApprovedBy_ID);

			final IQueryBuilder<I_C_BPartner_CreditLimit> queryBuilder = queryBL.createQueryBuilder(I_C_BPartner_CreditLimit.class)
					.addEqualsFilter(I_C_BPartner_CreditLimit.COLUMNNAME_C_BPartner_ID, bPartner.getC_BPartner_ID())
					.addEqualsFilter(I_C_BPartner_CreditLimit.COLUMNNAME_Amount, amount);

			if (dateFrom != null)
			{
				queryBuilder.addEqualsFilter(I_C_BPartner_CreditLimit.COLUMNNAME_DateFrom, dateFrom);
			}

			final Optional<I_C_BPartner_CreditLimit> creditLimit = queryBuilder.create()
					.firstOnlyOptional(I_C_BPartner_CreditLimit.class);

			assertThat(creditLimit).isPresent();

			final I_C_CreditLimit_Type creditLimit_type = bPartnerCreditLimitRepository.getCreditLimitTypeByName(creditLimitTypeName);

			final SoftAssertions softly = new SoftAssertions();
			softly.assertThat(creditLimit.get().getC_CreditLimit_Type_ID()).isEqualTo(creditLimit_type.getC_CreditLimit_Type_ID());
			softly.assertThat(creditLimit.get().isActive()).isEqualTo(isActive);
			softly.assertThat(creditLimit.get().isProcessed()).isEqualTo(processed);

			if (Check.isNotBlank(approvedById))
			{
				final String approvedByAsString = DataTableUtil.nullToken2Null(approvedById);
				if (approvedByAsString != null)
				{
					softly.assertThat(creditLimit.get().getApprovedBy_ID()).isEqualTo(Integer.parseInt(approvedByAsString));
				}
				else
				{
					assertThat(creditLimit.get().getApprovedBy_ID()).isEqualTo(0);
				}
			}

			softly.assertAll();
		}
	}
}
