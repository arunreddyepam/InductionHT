package org.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.listeners.CustomTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Listeners(CustomTestListener.class)
public class BrokenLinksTest {

    private WebDriver driver;
    private final String URL = "https://demoqa.com/broken";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.get(URL);
    }

    @Test
    public void validateAllLinksAreValid() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found on page: " + links.size());

        List<String> brokenLinks = new ArrayList<>();

        for (WebElement link : links) {
            String href = link.getAttribute("href");
            if (href == null || href.isEmpty() || href.startsWith("javascript")
                    || href.startsWith("mailto")) {
                continue;
            }
            int responseCode = getResponseCode(href);
            if (responseCode >= 400) {
                brokenLinks.add(href + " --> Status: " + responseCode);
                System.out.println("BROKEN: " + href + " (HTTP " + responseCode + ")");
            } else {
                System.out.println("VALID : " + href + " (HTTP " + responseCode + ")");
            }
        }

        Assert.assertTrue(brokenLinks.isEmpty(),
                "Broken links found: " + brokenLinks);
    }

    private int getResponseCode(String urlString) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();
            conn.setRequestMethod("HEAD");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.connect();
            return conn.getResponseCode();
        } catch (Exception e) {
            return 500;
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}