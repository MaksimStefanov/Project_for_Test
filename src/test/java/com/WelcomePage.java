package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.Constants.*;
import static com.Constants.LEGAL_AGE_X;

public class WelcomePage {
    WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;

    }

    public void openBrowser() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();


    }

    public MainPage logInToMainPage(String country) {
        driver.findElement(By.xpath(CONFIRMATION_CHECKBOX_X)).click();
        Select dropDown = new Select(driver.findElement(By.xpath(SELECT_OPTIONS_X)));
        dropDown.selectByVisibleText(country);
        driver.findElement(By.xpath(WELCOME_BUTTON_X)).click();
        return new MainPage(driver);

    }

    public void legalAgeWait() {
        (new WebDriverWait(driver, 2)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(LEGAL_AGE_X)));
    }

    public WebElement legalAge() {
        return driver.findElement(By.xpath(LEGAL_AGE_X));
    }

    public WebElement checkBox() {
        return driver.findElement(By.xpath(CHECKBOX));
    }

    public WebElement dropDown() {
        return driver.findElement(By.className("agegate-selector-options"));
    }

    public WebElement welcomeButton() {
        return driver.findElement(By.xpath("//input[@type='submit']"));
    }

    public void quit() {
        driver.quit();
    }
}
