package org.example.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    private WebDriver driver;

    private By signupName = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By signupErrorMsg = By.xpath("//p[contains(text(),'Email Address already exist')]");
    private By accountInfoHeader = By.xpath("//b[contains(text(),'Enter Account Information')]");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSignupName(String name) {
        driver.findElement(signupName).clear();
        driver.findElement(signupName).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        driver.findElement(signupEmail).clear();
        driver.findElement(signupEmail).sendKeys(email);
    }

    public void clickSignup() {
        driver.findElement(signupButton).click();
    }

    public String getSignupErrorMessage() {
        return driver.findElement(signupErrorMsg).getText();
    }

    public boolean isAccountInfoPageDisplayed() {
        return driver.findElement(accountInfoHeader).isDisplayed();
    }

    public String getNameFieldValidationMessage() {
        return driver.findElement(signupName).getAttribute("validationMessage");
    }

    public String getEmailFieldValidationMessage() {
        return driver.findElement(signupEmail).getAttribute("validationMessage");
    }
}