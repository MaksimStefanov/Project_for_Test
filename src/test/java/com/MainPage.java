package com;

import com.codeborne.selenide.SelenideElement;
import com.pages.CocktailsPage;
import com.pages.WhereToBuyPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;


import static com.Constants.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @FindBy(xpath = MAIN_PAGE_ELEMENT_X)
    private SelenideElement mainPageElement;
    @FindBy(xpath = YELLOW_TAIL_LOGO_X)
    private SelenideElement yellowTailLogo;
    @FindBy(xpath = MAIN_PAGE_MENU_X)
    private SelenideElement mainPageMenu;
    @FindBy(xpath = SELECT_COUNTRY_X)
    private SelenideElement selectCountry;
    @FindBy(xpath = COUNTRY_CHINA)
    private SelenideElement china;
    @FindBy(xpath = COUNTRY_AUSTRALIA)
    private SelenideElement australia;
    @FindBy(xpath = COUNTRY_USA)
    private SelenideElement usa;
    @FindBy(xpath = COCKTAILS_BUTTON_X)
    private SelenideElement cocktailsButton;
    @FindBy(xpath = WE_ARE_PASSIONATE_X)
    private SelenideElement weArePassionate;
    @FindBy(xpath = FIND_YOUR_WINE_X)
    private SelenideElement findYourWine;
    @FindBy(id = FOOTER_ID)
    private SelenideElement getFooter;
    @FindBy(xpath = WHERE_TO_BUY)
    private SelenideElement whereToBuy;


    @Step
    public SelenideElement selectCountry() {
        return selectCountry;
    }
    @Step
    public SelenideElement elementOnMainPage() {
        return mainPageElement;
    }
    @Step
    public SelenideElement menuButton() {
        return mainPageMenu;
    }
    @Step
    public SelenideElement welcomeToTheWorld() {
        return $(By.xpath(WELCOME_TO_THE_WORLD));
    }
    @Step
    public void selectCountryFromDropDown(String country) {
        if (country.equals(CHINA)) {
            china.click();
        } else if (country.equals(USA)) {
            usa.click();
        } else if (country.equals(AUSTRALIA)) {
            australia.click();
        }

    }
    @Step
    public CocktailsPage clickCocktailsButton() {
        cocktailsButton.click();
        return page(CocktailsPage.class);
    }
    @Step
    public WhereToBuyPage clickWhereToBuy() {
        whereToBuy.click();
        return page(WhereToBuyPage.class);
    }

    @Step
    public SelenideElement weArePassionate() {
        return weArePassionate;
    }
    @Step
    public SelenideElement findYourWine() {
        return findYourWine;
    }
    @Step
    public SelenideElement yellowTailLogo() {
        return yellowTailLogo;
    }
    @Step
    public SelenideElement getFooter() {
        return getFooter;
    }
}
