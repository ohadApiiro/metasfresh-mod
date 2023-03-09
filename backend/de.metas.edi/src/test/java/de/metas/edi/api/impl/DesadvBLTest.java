package de.metas.edi.api.impl;

import de.metas.business.BusinessTestHelper;
import de.metas.edi.api.EDIDesadvLineId;
import de.metas.edi.api.impl.pack.CreateEDIDesadvPackRequest;
import de.metas.edi.api.impl.pack.EDIDesadvPackRepository;
import de.metas.edi.api.impl.pack.EDIDesadvPackService;
import de.metas.esb.edi.model.I_EDI_Desadv;
import de.metas.esb.edi.model.I_EDI_DesadvLine;
import de.metas.handlingunits.generichumodel.HURepository;
import de.metas.inout.InOutId;
import de.metas.inout.InOutLineId;
import de.metas.product.ProductId;
import de.metas.quantity.Quantitys;
import de.metas.quantity.StockQtyAndUOMQty;
import de.metas.uom.CreateUOMConversionRequest;
import de.metas.uom.UomId;
import de.metas.uom.X12DE355;
import org.adempiere.test.AdempiereTestHelper;
import org.compiere.model.I_M_Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static de.metas.esb.edi.model.I_EDI_DesadvLine.COLUMNNAME_QtyDeliveredInInvoiceUOM;
import static de.metas.esb.edi.model.I_EDI_DesadvLine.COLUMNNAME_QtyDeliveredInStockingUOM;
import static de.metas.esb.edi.model.I_EDI_DesadvLine.COLUMNNAME_QtyDeliveredInUOM;
import static org.adempiere.model.InterfaceWrapperHelper.newInstance;
import static org.adempiere.model.InterfaceWrapperHelper.saveRecord;
import static org.assertj.core.api.Assertions.*;

class DesadvBLTest
{
	private de.metas.edi.api.impl.pack.EDIDesadvPackService EDIDesadvPackService;
	private DesadvBL desadvBL;
	private UomId coliUomId;
	private UomId eachUomId;
	private UomId kiloUomId;
	private ProductId productId;

	@BeforeEach
	void beforeEach()
	{
		AdempiereTestHelper.get().init();

		EDIDesadvPackService = new EDIDesadvPackService(new HURepository(), new EDIDesadvPackRepository());
		desadvBL = new DesadvBL(EDIDesadvPackService);

		eachUomId = UomId.ofRepoId(BusinessTestHelper.createUOM("each", X12DE355.EACH).getC_UOM_ID());
		coliUomId = UomId.ofRepoId(BusinessTestHelper.createUOM("coli", X12DE355.COLI).getC_UOM_ID());
		kiloUomId = UomId.ofRepoId(BusinessTestHelper.createUOM("kilo", X12DE355.KILOGRAM).getC_UOM_ID());

		final I_M_Product productRecord = BusinessTestHelper.createProduct("product", eachUomId);
		productId = ProductId.ofRepoId(productRecord.getM_Product_ID());

		// one PCE is two KGM
		BusinessTestHelper.createUOMConversion(CreateUOMConversionRequest.builder()
													   .fromUomId(eachUomId)
													   .toUomId(kiloUomId)
													   .productId(productId)
													   .catchUOMForProduct(true)
													   .fromToMultiplier(new BigDecimal("2")).build());
	}

	// 9 CUs per COLI and 20.5 CUs => 3 COLIs
	@Test
	void setQty_isUOMForTUs()
	{
		final CreateEDIDesadvPackRequest.CreateEDIDesadvPackItemRequest.CreateEDIDesadvPackItemRequestBuilder createEDIDesadvPackItemRequestBuilder = CreateEDIDesadvPackRequest.CreateEDIDesadvPackItemRequest.builder()
				.ediDesadvLineId(EDIDesadvLineId.ofRepoId(1))
				.inOutId(InOutId.ofRepoId(2))
				.inOutLineId(InOutLineId.ofRepoId(3))
				.qtyItemCapacity(new BigDecimal("9"))
				.qtyTu(BigDecimal.ZERO.intValue())
				.movementQtyInStockUOM(BigDecimal.ZERO);

		final StockQtyAndUOMQty cusPerLU = StockQtyAndUOMQty.builder()
				.productId(productId)
				.stockQty(Quantitys.create("20.5", eachUomId)) /* qtyCUsPerLUInStockUom */
				.uomQty(Quantitys.create("4", coliUomId))
				.build();

		final BigDecimal movementQty = cusPerLU.getStockQty().toBigDecimal();

		// invoke the method under test
		EDIDesadvPackService.setQty(
				createEDIDesadvPackItemRequestBuilder,
				productId,
				Quantitys.create("99999", eachUomId) /* qtyCUInStockUom */,
				cusPerLU,
				coliUomId,
				new BigDecimal("9"),
				movementQty);

		final CreateEDIDesadvPackRequest.CreateEDIDesadvPackItemRequest createEDIDesadvPackItemRequest = createEDIDesadvPackItemRequestBuilder.build();

		assertThat(createEDIDesadvPackItemRequest.getQtyCUsPerLU()).isEqualByComparingTo(new BigDecimal("3"));
		assertThat(createEDIDesadvPackItemRequest.getQtyCu()).isEqualByComparingTo(new BigDecimal("1"));
		assertThat(createEDIDesadvPackItemRequest.getMovementQtyInStockUOM()).isEqualByComparingTo(new BigDecimal("20.5"));
	}

	/**
	 * have 10PCE fitting into 1COLI and 1PCE weighing 2KGM
	 * Create a desadvLine with 0PCE and 0COLI;
	 * Then add 9PCE and 20KGM (not 18 bc catch-weight)
	 * => expect the deadvLine to have 9PCE, 1COLI and 20KGM
	 */
	@Test
	void addOrSubtractInOutLineQty_iolQtyWithKGM()
	{
		// given
		final I_EDI_Desadv desadvRecord = newInstance(I_EDI_Desadv.class);
		saveRecord(desadvRecord);

		final I_EDI_DesadvLine desadvLineRecord = newInstance(I_EDI_DesadvLine.class);
		desadvLineRecord.setEDI_Desadv_ID(desadvRecord.getEDI_Desadv_ID());
		desadvLineRecord.setM_Product_ID(productId.getRepoId());
		desadvLineRecord.setQtyDeliveredInStockingUOM(BigDecimal.ZERO);
		desadvLineRecord.setC_UOM_ID(coliUomId.getRepoId());
		desadvLineRecord.setQtyDeliveredInUOM(BigDecimal.ZERO);
		desadvLineRecord.setC_UOM_Invoice_ID(kiloUomId.getRepoId());
		desadvLineRecord.setQtyItemCapacity(BigDecimal.TEN); // 10 PCE fit into 1 COLI
		saveRecord(desadvLineRecord);

		final StockQtyAndUOMQty inOutLineQty = StockQtyAndUOMQty.builder().productId(productId)
				.stockQty(Quantitys.create("9", eachUomId))
				.uomQty(Quantitys.create("20", kiloUomId)).build();

		// when
		desadvBL.addOrSubtractInOutLineQty(desadvLineRecord, inOutLineQty, null, true);

		// then
		assertThat(desadvLineRecord).extracting(COLUMNNAME_QtyDeliveredInStockingUOM, COLUMNNAME_QtyDeliveredInUOM, COLUMNNAME_QtyDeliveredInInvoiceUOM)
				.contains(new BigDecimal("9"), new BigDecimal("1"), new BigDecimal("20"));
	}

	/**
	 * have 1PCE weighing 2KGM
	 * Create a desadvLine with 0PCE and 0KGM;
	 * Then add 9PCE and 20KGM (not 18 bc catch-weight)
	 * => expect the deadvLine to have 9PCE and 18KGM
	 */
	@Test
	void addOrSubtractInOutLineQty_iolQtyWithPCE()
	{
		// given
		final I_EDI_Desadv desadvRecord = newInstance(I_EDI_Desadv.class);
		saveRecord(desadvRecord);

		final I_EDI_DesadvLine desadvLineRecord = newInstance(I_EDI_DesadvLine.class);
		desadvLineRecord.setEDI_Desadv_ID(desadvRecord.getEDI_Desadv_ID());
		desadvLineRecord.setM_Product_ID(productId.getRepoId());
		desadvLineRecord.setQtyDeliveredInStockingUOM(BigDecimal.ZERO);
		desadvLineRecord.setC_UOM_ID(eachUomId.getRepoId());
		desadvLineRecord.setQtyDeliveredInUOM(BigDecimal.ZERO);
		desadvLineRecord.setC_UOM_Invoice_ID(kiloUomId.getRepoId());
		desadvLineRecord.setQtyItemCapacity(BigDecimal.TEN); // 10 PCE fit into 1 COLI
		saveRecord(desadvLineRecord);

		final StockQtyAndUOMQty inOutLineQty = StockQtyAndUOMQty.builder().productId(productId)
				.stockQty(Quantitys.create("9", eachUomId))
				.uomQty(Quantitys.create("20", kiloUomId)).build();

		// when
		desadvBL.addOrSubtractInOutLineQty(desadvLineRecord, inOutLineQty, null,true);

		// then
		assertThat(desadvLineRecord).extracting(COLUMNNAME_QtyDeliveredInStockingUOM, COLUMNNAME_QtyDeliveredInUOM, COLUMNNAME_QtyDeliveredInInvoiceUOM)
				.contains(new BigDecimal("9"), new BigDecimal("9"), new BigDecimal("20"));
	}

}
