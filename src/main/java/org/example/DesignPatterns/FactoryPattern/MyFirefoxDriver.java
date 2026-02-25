package org.example.DesignPatterns.FactoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MyFirefoxDriver implements BrowserDriver {

    private WebDriver driver;

    @Override
    public void initializeDriver() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);

        System.out.println("Firefox Driver Initialized");
    }

    public WebDriver getDriver() {
        return driver;
    }
}