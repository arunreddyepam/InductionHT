package org.example.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LoginTest {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        logger.info("=== Starting Test Setup ===");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.debug("Browser launched and maximized");
    }

    @Test
    public void validLoginTest() {
        try {
            logger.info("Navigating to login page");
            driver.get("https://the-internet.herokuapp.com/login");

            logger.debug("Entering username");
            driver.findElement(By.id("username")).sendKeys("tomsmith");

            logger.debug("Entering password");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

            logger.info("Clicking login button");
            driver.findElement(By.id("loginBtn")).click();

            logger.info("Login successful ✓");
        } catch (Exception e) {
            logger.error("Login test failed", e);
            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Closing browser");
        if (driver != null) driver.quit();
        logger.info("=== Test Completed ===\n");
    }
}
