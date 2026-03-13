package org.example.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class InfiniteScrollTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the first content to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("jscroll-added")));

        List<WebElement> paragraphs = driver.findElements(By.cssSelector(".jscroll-added p"));

        int maxScrolls = 20;
        int scrollCount = 0;
        while (paragraphs.size() < 10 && scrollCount < maxScrolls) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            js.executeScript("window.scrollBy(0, 1000)");
            Thread.sleep(1500);
            paragraphs = driver.findElements(By.cssSelector(".jscroll-added p"));
            System.out.println("Paragraphs loaded: " + paragraphs.size());
            scrollCount++;
        }

        if (paragraphs.size() >= 10) {
            System.out.println("New content loaded successfully.");
            int start = paragraphs.size() - 10;
            for (int i = start; i < paragraphs.size(); i++) {
                System.out.println(paragraphs.get(i).getText());
            }
        } else {
            System.out.println("Failed to load 10 paragraphs after " + scrollCount + " scrolls.");
        }

        driver.quit();
    }
}
