package org.adempiere.mm.attributes.api.impl;

import static org.adempiere.model.InterfaceWrapperHelper.newInstance;
import static org.adempiere.model.InterfaceWrapperHelper.save;
import static org.assertj.core.api.Assertions.assertThat;

import org.adempiere.mm.attributes.AttributeId;
import org.adempiere.mm.attributes.AttributeListValue;
import org.adempiere.mm.attributes.AttributeSetInstanceId;
import org.adempiere.mm.attributes.api.AttributeConstants;
import org.adempiere.mm.attributes.api.IAttributeSetInstanceBL;
import org.adempiere.test.AdempiereTestHelper;
import org.compiere.model.I_M_Attribute;
import org.compiere.model.I_M_AttributeInstance;
import org.compiere.model.I_M_AttributeSetInstance;
import org.compiere.model.X_M_Attribute;
import org.eevolution.model.I_DD_OrderLine;
import org.eevolution.model.I_PP_Order;
import org.eevolution.model.I_PP_Order_BOMLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.metas.material.event.commons.AttributesKey;
import de.metas.material.event.commons.ProductDescriptor;
import de.metas.util.Services;
import lombok.NonNull;

/*
 * #%L
 * de.metas.business
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

public class ModelProductDescriptorExtractorUsingAttributeSetInstanceFactoryTest
{
	private static final int PRODUCT_ID = 20;
	private ModelProductDescriptorExtractorUsingAttributeSetInstanceFactory factory;

	private AttributeListValue attributeValue1;
	private AttributeListValue attributeValue2;
	private AttributeListValue attributeValue3;

	@BeforeEach
	public void init()
	{
		AdempiereTestHelper.get().init();
		factory = new ModelProductDescriptorExtractorUsingAttributeSetInstanceFactory();
	}

	@Test
	public void createProductDescriptor_PP_Order_no_ASI_result_to_NONE()
	{
		final I_PP_Order ppOrder = newInstance(I_PP_Order.class);
		ppOrder.setM_Product_ID(20);

		final ProductDescriptor productDescriptor = factory.createProductDescriptor(ppOrder);
		assertThat(productDescriptor).isNotNull();
		assertThat(productDescriptor.getProductId()).isEqualTo(20);
		assertThat(productDescriptor.getAttributeSetInstanceId()).isEqualTo(AttributeConstants.M_AttributeSetInstance_ID_None);
		assertThat(productDescriptor.getStorageAttributesKey()).isEqualTo(AttributesKey.NONE);
	}

	@Test
	public void createProductDescriptor_PP_Order_with_ASI()
	{
		final I_M_AttributeSetInstance asi = createASI();

		final I_PP_Order ppOrder = newInstance(I_PP_Order.class);
		ppOrder.setM_Product_ID(PRODUCT_ID);
		ppOrder.setM_AttributeSetInstance_ID(asi.getM_AttributeSetInstance_ID());

		final ProductDescriptor productDescriptor = factory.createProductDescriptor(ppOrder);

		assertProductDescriptorMatchesProductAndASI(productDescriptor, asi);
	}

	@Test
	public void createProductDescriptor_PP_Order_BOMLine_with_ASI()
	{
		final I_M_AttributeSetInstance asi = createASI();

		final I_PP_Order_BOMLine ppOrderBomLine = newInstance(I_PP_Order_BOMLine.class);
		ppOrderBomLine.setM_Product_ID(PRODUCT_ID);
		ppOrderBomLine.setM_AttributeSetInstance_ID(asi.getM_AttributeSetInstance_ID());

		final ProductDescriptor productDescriptor = factory.createProductDescriptor(ppOrderBomLine);

		assertProductDescriptorMatchesProductAndASI(productDescriptor, asi);
	}

	@Test
	public void createProductDescriptor_DD_OrderLine_with_ASI()
	{
		final I_M_AttributeSetInstance asi = createASI();

		final I_DD_OrderLine ddOrderLine = newInstance(I_DD_OrderLine.class);
		ddOrderLine.setM_Product_ID(PRODUCT_ID);
		ddOrderLine.setM_AttributeSetInstance_ID(asi.getM_AttributeSetInstance_ID());

		final ProductDescriptor productDescriptor = factory.createProductDescriptor(ddOrderLine);

		assertProductDescriptorMatchesProductAndASI(productDescriptor, asi);
	}

	private void assertProductDescriptorMatchesProductAndASI(
			@NonNull final ProductDescriptor productDescriptor,
			@NonNull final I_M_AttributeSetInstance asi)
	{
		assertThat(productDescriptor.getProductId()).isEqualTo(20);
		assertThat(productDescriptor.getAttributeSetInstanceId()).isEqualTo(asi.getM_AttributeSetInstance_ID());

		final AttributesKey storageAttributesKeyExpected = AttributesKey.ofAttributeValueIds(attributeValue1.getId(), attributeValue3.getId());
		assertThat(productDescriptor.getStorageAttributesKey()).isEqualTo(storageAttributesKeyExpected);
	}

	private I_M_AttributeSetInstance createASI()
	{
		final AttributesTestHelper attributesTestHelper = new AttributesTestHelper();

		final I_M_Attribute attribute1 = attributesTestHelper.createM_Attribute("testAttrib1", X_M_Attribute.ATTRIBUTEVALUETYPE_List, true);
		attribute1.setIsStorageRelevant(true);
		save(attribute1);

		final I_M_Attribute attribute2 = attributesTestHelper.createM_Attribute("testAttrib2", X_M_Attribute.ATTRIBUTEVALUETYPE_List, true);
		attribute2.setIsStorageRelevant(false);
		save(attribute2);

		final I_M_Attribute attribute3 = attributesTestHelper.createM_Attribute("testAttrib3", X_M_Attribute.ATTRIBUTEVALUETYPE_List, true);
		attribute3.setIsStorageRelevant(true);
		save(attribute3);

		attributeValue1 = attributesTestHelper.createM_AttributeValue(attribute1, "value1");
		attributeValue2 = attributesTestHelper.createM_AttributeValue(attribute2, "value2");
		attributeValue3 = attributesTestHelper.createM_AttributeValue(attribute3, "value3");

		final I_M_AttributeSetInstance asi = newInstance(I_M_AttributeSetInstance.class);
		save(asi);

		final IAttributeSetInstanceBL attributeSetInstanceBL = Services.get(IAttributeSetInstanceBL.class);

		final AttributeSetInstanceId asiId = AttributeSetInstanceId.ofRepoId(asi.getM_AttributeSetInstance_ID());

		final I_M_AttributeInstance ai1 = attributeSetInstanceBL.getCreateAttributeInstance(asiId, AttributeId.ofRepoId(attribute1.getM_Attribute_ID()));
		ai1.setM_AttributeValue_ID(attributeValue1.getId().getRepoId());
		ai1.setValue("value1");
		save(ai1);
		final I_M_AttributeInstance ai2 = attributeSetInstanceBL.getCreateAttributeInstance(asiId, AttributeId.ofRepoId(attribute2.getM_Attribute_ID()));
		ai2.setM_AttributeValue_ID(attributeValue2.getId().getRepoId());
		ai2.setValue("value2");
		save(ai2);
		final I_M_AttributeInstance ai3 = attributeSetInstanceBL.getCreateAttributeInstance(asiId, AttributeId.ofRepoId(attribute3.getM_Attribute_ID()));
		ai3.setM_AttributeValue_ID(attributeValue3.getId().getRepoId());
		ai3.setValue("value3");
		save(ai3);

		return asi;
	}
}
