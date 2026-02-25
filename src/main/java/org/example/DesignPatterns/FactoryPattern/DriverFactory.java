package org.example.DesignPatterns.FactoryPattern;

public class DriverFactory {

    public static BrowserDriver getBrowser(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            return new MyChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            return new MyFirefoxDriver();

        } else if (browserName.equalsIgnoreCase("ie")) {
            return new MyIEDriver();

        } else {
            throw new IllegalArgumentException("Invalid browser name");
        }
    }
}
