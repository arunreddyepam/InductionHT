package org.example.DesignPatterns.FactoryPattern;

public class TestClass {

    public static void main(String[] args) {

        BrowserDriver browser = DriverFactory.getBrowser("ie");
        browser.initializeDriver();

    }
}