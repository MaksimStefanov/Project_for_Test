package com;

import com.pages.CocktailsPage;
import com.pages.WhereToBuyPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.Constants.*;

public class MainPage {
    WebDriver driver;

    @FindBy(xpath = MAIN_PAGE_ELEMENT_X)
    private WebElement mainPageElement;
    @FindBy(xpath = YELLOW_TAIL_LOGO_X)
    private WebElement yellowTailLogo;
    @FindBy(xpath = MAIN_PAGE_MENU_X)
    private WebElement mainPageMenu;
    @FindBy(xpath = SELECT_COUNTRY_X)
    private WebElement selectCountry;////
    @FindBy(xpath = COUNTRY_CHINA)
    private WebElement china;
    @FindBy(xpath = COUNTRY_AUSTRALIA)
    private WebElement australia;
    @FindBy(xpath = COUNTRY_USA)
    private WebElement usa;
    @FindBy(xpath = COCKTAILS_BUTTON_X)
    private WebElement cocktailsButton;
    @FindBy(xpath = WE_ARE_PASSIONATE_X)
    private WebElement weArePassionate;
    @FindBy(xpath = FIND_YOUR_WINE_X)
    private WebElement findYourWine;
    @FindBy(id = FOOTER_ID)
    private WebElement getFooter;
    @FindBy(xpath = WHERE_TO_BUY)
    private WebElement whereToBuy;


    public MainPage()  {
        this.driver = DriverProvider.INSTANCE.getDriver();
        PageFactory.initElements(driver, this);
    }
    @Step
    public void elementOnMainPageWait() {
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(mainPageElement));
    }
    @Step
    public void yellowTailLogoWait() {
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(yellowTailLogo));
    }
    @Step
    public void menuButtonWait() {
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(mainPageMenu));
    }
    @Step
    public WebElement selectCountry() {
        return selectCountry;
    }
    @Step
    public WebElement elementOnMainPage() {
        return mainPageElement;
    }
    @Step
    public WebElement menuButton() {
        return mainPageMenu;
    }
    @Step
    public WebElement welcomeToTheWorld() {
        return driver.findElement(By.xpath(WELCOME_TO_THE_WORLD));
    }
    @Step
    public Country selectCountryFromDropDown(String country) {
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(china));
        if (country.equals(CHINA)) {
            china.click();
        } else if (country.equals(USA)) {
            usa.click();
        } else if (country.equals(AUSTRALIA)) {
            australia.click();
        }
        return new Country(driver);
    }
    @Step
    public CocktailsPage clickCocktailsButton() {
        cocktailsButton.click();
        return new CocktailsPage();
    }
    @Step
    public WhereToBuyPage clickWhereToBuy() {
        whereToBuy.click();
        return new WhereToBuyPage(driver);
    }

    @Step
    public WebElement weArePassionate() {
        return weArePassionate;
    }
    @Step
    public WebElement findYourWine() {
        return findYourWine;
    }
    @Step
    public WebElement yellowTailLogo() {
        return yellowTailLogo;
    }
    @Step
    public WebElement getFooter() {
        return getFooter;
    }
}
