package tests;

import org.testng.annotations.Test;

import Pages.InventoryPage;
import Pages.LoginPage;
import base.BaseTest;

public class InventoryTest extends BaseTest{

	@Test
	
	public void addIventoryItem() throws InterruptedException {
		
		LoginPage loginPage  = new LoginPage(driver);
		loginPage.login("qalyncs@gmail.com","password");
		
		
		InventoryPage inventoryPage = new InventoryPage(driver);

		inventoryPage.clickInventory();
		inventoryPage.addItem();
		inventoryPage.baseItemName("hello");
		inventoryPage.baseItemCode("TestItem");
		inventoryPage.baseUnitOption();
		inventoryPage.picece();
		inventoryPage.saveandPacking();
		
		
	}
	
	
}
