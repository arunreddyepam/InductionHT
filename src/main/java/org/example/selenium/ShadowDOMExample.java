package org.example.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class ShadowDOMExample {

    WebDriver driver;

    @Test(priority = 1)
    public void testShadowDOM() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://books-pwakit.appspot.com/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "return document.querySelector('book-app').shadowRoot.querySelector('input')";
        WebElement input = (WebElement) js.executeScript(script);
        input.sendKeys("Harry potter");
        input.sendKeys(Keys.ENTER);
        Thread.sleep(10000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        WebElement result = (WebElement) js.executeScript("return document.querySelector('book-app')" +".shadowRoot.querySelector('book-explore')"+

                ".shadowRoot.querySelector('book-item');");
        Assert.assertTrue(result.getText().contains("Harry Potter"));

    }

}

