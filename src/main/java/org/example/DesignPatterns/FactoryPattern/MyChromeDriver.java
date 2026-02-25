package org.example.DesignPatterns.FactoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyChromeDriver implements BrowserDriver {

    private WebDriver driver;

    @Override
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        System.out.println("Chrome Driver Initialized");
    }

    public WebDriver getDriver() {
        return driver;
    }
}