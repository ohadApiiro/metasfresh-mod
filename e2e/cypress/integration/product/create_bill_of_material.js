import { Product, ProductCategory } from '../../support/utils/product';
import { BillOfMaterial, BillOfMaterialLine } from '../../support/utils/billOfMaterial';
import { appendHumanReadableNow } from '../../support/utils/utils';

describe('Create Product and BOM', function() {
  let productName;
  let productCategoryName;
  let productComponentName;

  // test
  let mainProductId;

  it('Read the fixture', function() {
    cy.fixture('product/create_bill_of_material.json').then(f => {
      productName = appendHumanReadableNow(f['productName']);
      productCategoryName = appendHumanReadableNow(f['productCategoryName']);
      productComponentName = appendHumanReadableNow(f['productComponentName']);
    });
  });

  it('Create a new ProductCategory', function() {
    cy.fixture('product/simple_productCategory.json').then(productCategoryJson => {
      Object.assign(new ProductCategory(), productCategoryJson)
        .setName(productCategoryName)
        .apply();
    });
  });

  it('Create main product', function() {
    cy.fixture('product/simple_product.json').then(productJson => {
      Object.assign(new Product(), productJson)
        .setName(productName)
        .setProductCategory(productCategoryName)
        .apply();
    });
    cy.getCurrentWindowRecordId().then(id => {
      mainProductId = id;
    });
  });

  it('Create component product', function() {
    cy.fixture('product/simple_product.json').then(productJson => {
      Object.assign(new Product(), productJson)
        .setName(productComponentName)
        .setProductCategory(productCategoryName)
        .apply();
    });
  });

  it('Create a new Bill of Material and add a component', function() {
    cy.fixture('product/bill_of_material.json').then(billMaterialJson => {
      Object.assign(new BillOfMaterial(), billMaterialJson)
        .setProduct(productName)
        // eslint-disable-next-line
        .addLine(new BillOfMaterialLine().setProduct(productComponentName).setQuantity(555).setScrap(3333))
        .setIsVerified(true)
        .apply();
    });
  });

  it('Verify the new BOM', function() {
    cy.visitWindow('140', mainProductId);
    cy.expectCheckboxValue('IsBOM', true);
    cy.expectCheckboxValue('IsVerified', true);
  });
});
