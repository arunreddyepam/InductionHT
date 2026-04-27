package org.example.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageNew {
    private WebDriver driver;

    private By loginEmail = By.xpath("//input[@data-qa='login-email']");
    private By loginPassword = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By loginErrorMsg = By.xpath("//p[contains(text(),'Your email or password is incorrect')]");
    private By loginHeader = By.xpath("//h2[contains(text(),'Login to your account')]");

    public LoginPageNew(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLoginEmail(String email) {
        driver.findElement(loginEmail).clear();
        driver.findElement(loginEmail).sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        driver.findElement(loginPassword).clear();
        driver.findElement(loginPassword).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getLoginErrorMessage() {
        return driver.findElement(loginErrorMsg).getText();
    }

    public boolean isLoginPageDisplayed() {
        return driver.findElement(loginHeader).isDisplayed();
    }
}
