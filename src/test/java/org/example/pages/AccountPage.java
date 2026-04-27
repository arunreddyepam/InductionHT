package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {
    private WebDriver driver;

    private By titleMr = By.id("id_gender1");
    private By password = By.id("password");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By address = By.id("address1");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobileNumber = By.id("mobile_number");
    private By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
    private By accountCreatedMsg = By.xpath("//b[contains(text(),'Account Created!')]");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillAccountInformation(String pwd) {
        driver.findElement(titleMr).click();
        driver.findElement(password).sendKeys(pwd);
    }

    public void fillAddressDetails() {
        driver.findElement(firstName).sendKeys("John");
        driver.findElement(lastName).sendKeys("Doe");
        driver.findElement(address).sendKeys("123 Main Street");
        new Select(driver.findElement(country)).selectByVisibleText("United States");
        driver.findElement(state).sendKeys("California");
        driver.findElement(city).sendKeys("Los Angeles");
        driver.findElement(zipcode).sendKeys("90001");
        driver.findElement(mobileNumber).sendKeys("1234567890");
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountBtn).click();
    }

    public boolean isAccountCreated() {
        return driver.findElement(accountCreatedMsg).isDisplayed();
    }
}
