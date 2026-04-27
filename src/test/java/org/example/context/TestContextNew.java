package org.example.context;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestContextNew {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPageNew loginPage;
    private SignupPage signupPage;
    private AccountPage accountPage;

    // Shared scenario data between steps
    private Map<String, Object> scenarioData = new HashMap<>();

    public TestContextNew() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        if (homePage == null) homePage = new HomePage(driver);
        return homePage;
    }

    public LoginPageNew getLoginPage() {
        if (loginPage == null) loginPage = new LoginPageNew(driver);
        return loginPage;
    }

    public SignupPage getSignupPage() {
        if (signupPage == null) signupPage = new SignupPage(driver);
        return signupPage;
    }

    public AccountPage getAccountPage() {
        if (accountPage == null) accountPage = new AccountPage(driver);
        return accountPage;
    }

    public void setData(String key, Object value) {
        scenarioData.put(key, value);
    }

    public Object getData(String key) {
        return scenarioData.get(key);
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}