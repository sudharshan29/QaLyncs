package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class LoginPage {

    WebDriver driver;
    WaitUtil wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitUtil(driver);
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/div/form/button")
    WebElement loginBtn;

    public void login(String user, String pass) {
        wait.waitForElementToBeVisible(username);
        username.sendKeys(user);
        password.sendKeys(pass);
        wait.waitForElementToBeClickable(loginBtn);
        loginBtn.click();
    }
}