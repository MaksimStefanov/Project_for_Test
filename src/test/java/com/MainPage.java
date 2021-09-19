package com;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private WebElement austalia;
    @FindBy(xpath = COUNTRY_USA)
    private WebElement usa;
    @FindBy(xpath = COCKTAILS_BUTTON)
    private WebElement cocktailsButton;
    @FindBy(xpath = WE_ARE_PASSIONATE)
    private WebElement weArePassionate;
    @FindBy(xpath = FIND_YOUR_WINE)
    private WebElement findYourWine;
    @FindBy(xpath = FOOTER_ID)
    private WebElement getFooter;
    //////



    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void elementOnMainPageWait() {
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(mainPageElement));
    }

    public void yellowTailLogoWait() {
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(yellowTailLogo));
    }

    public void menuButtonWait() {
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(mainPageMenu));
    }

    public WebElement selectCountry() {
        return selectCountry;
    }

    public WebElement elementOnMainPage() {
        return mainPageElement;
    }

    public WebElement menuButton() {
        return mainPageMenu;
    }

    public WebElement welcomeToTheWorld() {
        return driver.findElement(By.xpath(WELCOME_TO_THE_WORLD));
    }

    public Country selectCountryFromDropDown(String country) {
        if (country.equals(CHINA)) {
            china.click();
        } else if (country.equals(AUSTRALIA)) {
            usa.click();
        } else if (country.equals(USA)) {
            austalia.click();
        }
        return new Country(driver);
    }

    public CocktailsPage clickCocktailsButton() {
        cocktailsButton.click();
        return new CocktailsPage(driver);
    }

    public WebElement weArePassionate() {
        return weArePassionate;
    }

    public WebElement findYourWine() {
        return findYourWine;
    }

    public WebElement yellowTailLogo() {
        return yellowTailLogo;
    }

    public WebElement getFooter() {
        return getFooter;
    }
}
