package org.example.tests;

import org.example.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.example.pages.LoginPage;
import org.example.listeners.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class FirefoxLoginTest extends BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        initDriver(browser);
    }

    @Test
    public void loginTestOnFirefox() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.openLoginPage();
        loginPage.login("tomsmith", "SuperSecretPassword!");

        String message = loginPage.getFlashMessage();
        System.out.println("[FIREFOX] Flash Message: " + message);

        Assert.assertTrue(message.contains("You logged into a secure area!"),
                "Login failed on Firefox");
    }
}
