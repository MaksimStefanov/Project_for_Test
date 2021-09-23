package com.pages;

import com.DriverProvider;
import com.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.Constants.*;
import static com.Constants.LEGAL_AGE_X;

public class WelcomePage extends AbstractPage {
    WebDriver driver;

    @FindBy(xpath = CONFIRMATION_CHECKBOX_X)
    private WebElement confirmationCheckbox;
    @FindBy(xpath = SELECT_OPTIONS_X)
    private WebElement selectOptions;
    @FindBy(xpath = WELCOME_BUTTON_X)
    private WebElement welcomeButton;
    @FindBy(xpath = LEGAL_AGE_X)
    private WebElement legalAge;
    @FindBy(xpath = CHECKBOX_X)
    private WebElement checkbox;


    public WelcomePage() {
        super();
        this.driver = DriverProvider.INSTANCE.getDriver();

    }

    public void openBrowser() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();


    }

    public MainPage logInToMainPage(String country) {
        confirmationCheckbox.click();
        Select dropDown = new Select(selectOptions);
        dropDown.selectByVisibleText(country);
        welcomeButton.click();
        return new MainPage();

    }

    @Step
    public void legalAgeWait() {
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(legalAge));
    }

    @Step
    public WebElement legalAge() {
        return legalAge;
    }

    @Step
    public WebElement checkBox() {
        return driver.findElement(By.xpath(CHECKBOX_X));
    }
    @Step
    public WebElement dropDown() {
        return selectOptions;
    }
    @Step
    public WebElement welcomeButton() {
        return welcomeButton;
    }
    @Step
    public void quit() {
        driver.quit();
    }
}
