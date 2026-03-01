package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import Pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("qalyncs@gmail.com", "password");
    }
}