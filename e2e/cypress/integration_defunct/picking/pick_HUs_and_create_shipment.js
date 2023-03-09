import { salesOrders } from '../../page_objects/sales_orders';
import { SalesOrder, SalesOrderLine } from '../../support/utils/sales_order';
import { DocumentStatusKey } from '../../support/utils/constants';
import { applyFilters, clearNotFrequentFilters, selectNotFrequentFilterWidget, toggleNotFrequentFilters } from '../../support/functions';
import { Builder } from '../../support/utils/builder';

let productName;
let productQty;
let locatorId;

let businessPartnerName;
let soProductQuantity;

// shipment
let shipmentQuantityTypeOption;
let shipmentNotificationModalText;
let expectedPackingStatus;

// test columns
const orderColumn = 'order';
const huSelectionHuCodeColumn = 'Value';
const pickingHuCodeColumn = 'huCode';
const productPartnerColumn = 'ProductOrBPartner';
const handlingUnitsShipmentColumn = 'M_HU_ID';

// test
let soDocNumber;
let soRecordId;
let huValue1;
let huValue2;

describe('Create test data', function() {
  it('Read fixture and prepare the names', function() {
    cy.fixture('picking/pick_HUs_and_create_shipment.json').then(f => {
      productName = f['productName'];
      productQty = f['productQty'];
      locatorId = f['locatorId'];

      businessPartnerName = f['businessPartnerName'];
      soProductQuantity = f['soProductQuantity'];

      shipmentQuantityTypeOption = f['shipmentQuantityTypeOption'];
      shipmentNotificationModalText = f['shipmentNotificationModalText'];
      expectedPackingStatus = f['expectedPackingStatus'];
    });
  });

  it('Create first single-HU inventory doc', function() {
    cy.fixture('picking/pick_HUs_and_create_shipment.json').then(f => {
      Builder.createHUWithStock(f['productName'], f['productQty'], f['locatorId']).then(huVal => (huValue1 = huVal));
    });
  });

  it('Create second single-HU inventory doc', function() {
    cy.fixture('picking/pick_HUs_and_create_shipment.json').then(f => {
      Builder.createHUWithStock(f['productName'], f['productQty'], f['locatorId']).then(huVal => (huValue2 = huVal));
    });
  });

  it('Create Sales Order', function() {
    cy.fixture('picking/pick_HUs_and_create_shipment.json').then(f => {
      new SalesOrder()
        .setBPartner(f['businessPartnerName'])
        .addLine(new SalesOrderLine().setProduct(f['productName']).setQuantity(f['soProductQuantity']))
        .apply();
      cy.completeDocument();

      cy.getCurrentWindowRecordId().then(id => (soRecordId = id));
      cy.getStringFieldValue('DocumentNo').then(docNO => (soDocNumber = docNO));
    });
  });
});

describe('Pick the SO', function() {
  it('Visit "Picking Terminal (Prototype)"', function() {
    // unfortunately the picking assignment is not created instantly and there's no way to check when it is created except by refreshing the page,
    // so i have to wait for it to be created :(
    cy.waitUntilProcessIsFinished();
    cy.visitWindow('540345');
  });

  it('Select first row and run action Pick', function() {
    cy.selectRowByColumnAndValue({ column: productPartnerColumn, value: productName });
    cy.executeQuickAction('WEBUI_Picking_Launcher');
  });

  it('Pick first HU', function() {
    cy.selectLeftTable().within(() => {
      cy.selectRowByColumnAndValue({ column: orderColumn, value: soDocNumber }, false, true);
    });
    cy.executeQuickActionWithRightSideTable('WEBUI_Picking_HUEditor_Launcher');

    cy.selectItemUsingBarcodeFilter(huValue1);

    cy.selectRightTable().within(() => {
      cy.selectRowByColumnAndValue({ column: huSelectionHuCodeColumn, value: huValue1 }, false, true);
    });

    cy.executeQuickAction('WEBUI_Picking_HUEditor_PickHU', true, false);
  });

  it('Pick second HU', function() {
    cy.selectLeftTable().within(() => {
      cy.selectRowByColumnAndValue({ column: orderColumn, value: soDocNumber }, false, true);
    });
    cy.executeQuickActionWithRightSideTable('WEBUI_Picking_HUEditor_Launcher');
    cy.selectRightTable().within(() => {
      cy.selectRowByColumnAndValue({ column: huSelectionHuCodeColumn, value: huValue2 }, false, true);
    });
    cy.executeQuickAction('WEBUI_Picking_HUEditor_PickHU', true, false);
  });

  it('Confirm Picks', function() {
    cy.selectLeftTable().within(() => {
      cy.selectRowByColumnAndValue({ column: orderColumn, value: soDocNumber }, false, true);
    });
    cy.selectRightTable().within(() => {
      cy.selectRowByColumnAndValue({ column: pickingHuCodeColumn, value: huValue2 }, false, true);
    });
    cy.executeQuickAction('WEBUI_Picking_M_Picking_Candidate_Process', true, false);
    cy.waitForSaveIndicator();

    cy.selectLeftTable().within(() => {
      cy.selectRowByColumnAndValue({ column: orderColumn, value: soDocNumber }, false, true);
    });
    cy.selectRightTable().within(() => {
      cy.selectRowByColumnAndValue({ column: pickingHuCodeColumn, value: huValue1 }, false, true);
    });
    cy.executeQuickAction('WEBUI_Picking_M_Picking_Candidate_Process', true, false);
    cy.waitForSaveIndicator();
  });
});

describe('Generate the Shipment', function() {
  it('Open the Referenced Shipment Disposition', function() {
    salesOrders.visit(soRecordId);
    cy.openReferencedDocuments('M_ShipmentSchedule');

    cy.expectNumberOfRows(1);
    cy.selectNthRow(0).dblclick();
  });

  it('Shipment Disposition checks', function() {
    cy.expectCheckboxValue('IsToRecompute', false);
    cy.getStringFieldValue('C_BPartner_ID').should('contain', businessPartnerName);
    cy.getStringFieldValue('M_Product_ID').should('contain', productName);
    cy.getStringFieldValue('C_Order_ID').should('equal', soDocNumber);
    cy.getStringFieldValue('QtyOrdered_Calculated').should('equal', soProductQuantity.toString(10));
    cy.getStringFieldValue('QtyToDeliver ').should('equal', '0');
    cy.getStringFieldValue('QtyPickList ').should('equal', soProductQuantity.toString(10));
  });

  it('Run action "Generate shipments"', function() {
    cy.readAllNotifications();
    cy.executeHeaderAction('M_ShipmentSchedule_EnqueueSelection');
    cy.selectInListField('QuantityType', shipmentQuantityTypeOption, true, null, true);
    cy.expectCheckboxValue('IsCompleteShipments', true, true);
    cy.expectCheckboxValue('IsShipToday', false, true);

    cy.pressStartButton();
    cy.getNotificationModal(shipmentNotificationModalText);
    cy.expectCheckboxValue('Processed', true);
  });

  it('Open notifications and go to the shipment', function() {
    cy.openInboxNotificationWithText(businessPartnerName);
  });

  it('Shipment checks', function() {
    cy.expectDocumentStatus(DocumentStatusKey.Completed);
    cy.getStringFieldValue('C_BPartner_ID').should('contain', businessPartnerName);
    cy.selectTab('M_HU_Assignment');
    cy.expectNumberOfRows(2);
    cy.selectRowByColumnAndValue({ column: handlingUnitsShipmentColumn, value: huValue1 });
    cy.selectRowByColumnAndValue({ column: handlingUnitsShipmentColumn, value: huValue2 });
  });

  it('Visit HU Editor and expect the 2 HUs have Packing Status Shipped', function() {
    cy.visitWindow(540189);
    clearNotFrequentFilters();
    toggleNotFrequentFilters();
    selectNotFrequentFilterWidget('default');
    cy.selectInListField('HUStatus', expectedPackingStatus, false, null, true);
    cy.writeIntoStringField('Value', huValue1, false, null, true);
    applyFilters();

    cy.expectNumberOfRows(1);

    cy.visitWindow(540189);
    clearNotFrequentFilters();
    toggleNotFrequentFilters();
    selectNotFrequentFilterWidget('default');
    cy.selectInListField('HUStatus', expectedPackingStatus, false, null, true);
    cy.writeIntoStringField('Value', huValue2, false, null, true);
    applyFilters();

    cy.expectNumberOfRows(1);
  });
});
