package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtil;

public class InventoryPage {
  WebDriver driver;
  WaitUtil wait;
  
  public InventoryPage (WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this );
	wait = new WaitUtil(driver);
}
  
  //Locators
  
  @FindBy(xpath = "//h3[normalize-space()='Inventory']")
  WebElement inventoryModule;
  
  @FindBy(xpath = "//button[@class='inline-flex items-center justify-center gap-2 whitespace-nowrap rounded-md text-sm font-medium transition-colors focus-visible:outline-none focus-visible:ring-1 focus-visible:ring-ring disabled:pointer-events-none disabled:opacity-50 [&_svg]:pointer-events-none [&_svg]:size-4 [&_svg]:shrink-0 shadow h-9 px-4 py-2 w-full shrink-0 bg-white text-purple-800 hover:bg-white/90 dark:bg-gray-800 dark:text-purple-200 dark:hover:bg-gray-700 sm:w-auto']")
  WebElement addItem;
  
  @FindBy(xpath = "//input[@placeholder='Enter base item name']")
  WebElement baseItemName;
  
  @FindBy(xpath = "//input[@placeholder='Enter item code']")
  WebElement baseItemCode;
  
  @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div[4]/button")
  WebElement baseUnitDropdown;
  
  @FindBy(xpath = "(//button[@role='combobox'])[1]")
  WebElement baseUnitOption;
  
  @FindBy(xpath = "//span[normalize-space()='Piece (pcs)']")
  WebElement picece;
  
  @FindBy(xpath = "//button[normalize-space()='Save & Go to Packaging']")
  WebElement saveandPacking;
  
  @FindBy(xpath = "//h1[normalize-space()='Repository']")
  WebElement checkingRepospage;
  

  //methods
  public void clickInventory() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    // Wait until visible & clickable
	    wait.until(ExpectedConditions.visibilityOf(inventoryModule));
	    wait.until(ExpectedConditions.elementToBeClickable(inventoryModule));
	    
	    // Scroll slightly above element to avoid sticky header
	    ((JavascriptExecutor) driver).executeScript(
	        "window.scrollTo(0, arguments[0].getBoundingClientRect().top + window.pageYOffset - 100);", 
	        inventoryModule
	    );

	    // Small wait for scroll
	    try { Thread.sleep(200); } catch (InterruptedException e) { }

	    // Normal click
	    try {
	        inventoryModule.click();
	    } catch (Exception e) {
	        // Fallback to JS click
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", inventoryModule);

	    }
	}
  public void addItem() {
	  wait.waitForElementToBeClickable(addItem);
	  addItem.click();
	    }
  
  public void baseItemName(String name) {
  wait.waitForElementToBeClickable(baseItemName);	
  baseItemName.sendKeys("Name");
}
  public void baseItemCode(String name) {
	  wait.waitForElementToBeClickable(baseItemCode);
baseItemCode.sendKeys("base123");
}
  
  public void baseUnitOption() {
	  wait.waitForElementToBeVisible(baseUnitOption);
baseUnitOption.click();
}
  
  public void picece() {
	  wait.waitForElementToBeVisible(picece);
	  picece.click();
   }
  
  public void saveandPacking() {
	  wait.waitForElementToBeClickable(saveandPacking);
	  saveandPacking.click();
	  }
  
  
  
  
  
  
  
  
 
  
  
  
  
}

 