package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.InventoryPage;
import Pages.LoginPage;
import base.BaseTest;

public class InventoryTest extends BaseTest{

	@Test
	
	public void addIventoryItem() throws InterruptedException {
		
		LoginPage loginPage  = new LoginPage(driver);
		loginPage.login("qalyncs@gmail.com","password");
		Thread.sleep(2000);
		
		InventoryPage inventoryPage = new InventoryPage(driver);

		inventoryPage.clickInventory();
		inventoryPage.addItem();
		String unique = String.valueOf(System.currentTimeMillis());

		inventoryPage.baseItemName("BASE_" + unique);
		inventoryPage.baseItemCode("CODE_" + unique);
		inventoryPage.selectBaseUnit("Piece (pcs)");
		inventoryPage.saveandPacking();

		Assert.assertTrue(inventoryPage.isRepositoryVisible());
		inventoryPage.Done();
	
	
}}
