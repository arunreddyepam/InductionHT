package org.example.DesignPatterns.FactoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class MyIEDriver implements BrowserDriver {

    private WebDriver driver;

    @Override
    public void initializeDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        driver = new InternetExplorerDriver(options);

        System.out.println("IE Driver Initialized");
    }

    public WebDriver getDriver() {
        return driver;
    }
}

