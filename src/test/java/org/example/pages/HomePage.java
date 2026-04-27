package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private static final String URL = "https://automationexercise.com/";

    private By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By logoutLink = By.xpath("//a[contains(text(),'Logout')]");
    private By loggedInAsText = By.xpath("//a[contains(text(),'Logged in as')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginLink).click();
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }

    public boolean isLoggedInDisplayed() {
        return driver.findElement(loggedInAsText).isDisplayed();
    }

    public String getLoggedInText() {
        return driver.findElement(loggedInAsText).getText();
    }
}
