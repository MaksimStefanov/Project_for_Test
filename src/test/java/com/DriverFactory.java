package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.Constants.*;
import static com.Constants.PATH_TO_FIREFOX;

public class DriverFactory {
    public WebDriver createDriverInstance(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                System.setProperty(WEB_DRIVER_PROPERTY, PATH_TO_CHROME);
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty(WEB_DRIVER_PROPERTY_FIREFOX, PATH_TO_FIREFOX);
                return new FirefoxDriver();
            default:
                System.setProperty(WEB_DRIVER_PROPERTY, PATH_TO_CHROME);
                return new ChromeDriver();
        }

    }
}
