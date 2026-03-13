package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BDDLoginPage extends BasePage {

    public BDDLoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLoginCredentials(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(By.id("SubmitLogin")).click();
    }
}
