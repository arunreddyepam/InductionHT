package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BDDHomePage extends BasePage {

    public BDDHomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get("http://automationpractice.com/");
    }

    public void clickSignIn() {
        driver.findElement(By.className("login")).click();
    }
}