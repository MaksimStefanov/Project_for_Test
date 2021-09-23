package com;

import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static com.Constants.*;

public class DriverProvider {
//    private static String driverName = "chrome";
//    private static WebDriver driver;

    /*public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }*/

    /*public static WebDriver createDriver(String driverName) {
        if (driverName.equals("chrome")) {
            System.setProperty(WEB_DRIVER_PROPERTY, PATH_TO_CHROME);
            return new ChromeDriver();
        } else if (driverName.equals("firefox")) {
            System.setProperty(WEB_DRIVER_PROPERTY_FIREFOX, PATH_TO_FIREFOX);
            return new FirefoxDriver();
        } else {
            System.setProperty(WEB_DRIVER_PROPERTY, PATH_TO_CHROME);
            return new ChromeDriver();
        }

    }*/

    public static final DriverProvider INSTANCE = new DriverProvider();
    private ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();

    private DriverProvider() {
    }

    public WebDriver getDriver()  {
        if (DRIVER.get() == null) {
            String browserName = loadProperties().getProperty(BROWSER_NAME_PROPERTY);
            WebDriver createdDriver = new DriverFactory().createDriverInstance(BrowserType.valueOf(browserName));
            DRIVER.set(createdDriver);
        }
        return DRIVER.get();
    }

    public void removeDriver() {
        DRIVER.get().quit();
        DRIVER.remove();
    }

    public static Properties loadProperties()  {
        String current = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String resourcesFolder = "src" + separator + "test" + separator + "resources";
        Path file = Paths.get(current + separator + resourcesFolder + separator + FILE_PROPERTY);
    Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;

    }

}
