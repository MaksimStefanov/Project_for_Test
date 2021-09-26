package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.pages.CocktailsPage;
import com.pages.WelcomePage;
import com.pages.WhereToBuyPage;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.Constants.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

import org.testng.Assert;
import org.testng.annotations.*;


public class YellowTailTest extends SelenideRunner {

    @Description("Case 1: Welcome page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsWelcomePageLegalAge() {

        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        $(welcomePage.legalAge()).shouldBe(Condition.visible);
    }

    @Description("Case 1: Welcome page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsWelcomePageCheckBoxBeforeLegalAge() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        $(welcomePage.checkBox()).shouldBe(Condition.visible);

    }

    @Description("Case 1: Welcome page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsWelcomePageSelectDropDown() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        $(welcomePage.dropDown()).shouldBe(Condition.visible);

    }

    @Description("Case 1: Welcome page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsWelcomePageWelcomeButton() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        $(welcomePage.welcomeButton()).shouldBe(Condition.visible);

    }

    @Description("Case 1: Welcome page: all required elements are displayed")
    @Test
    public void verifyInactiveItemsWelcomePageWelcomeButton() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        $(welcomePage.welcomeButton()).shouldBe(Condition.disabled);

    }

    @Description("Case 2: Welcome page: navigate to main page as European customer")
    @Test
    public void verifyNavigateToMainPage() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        $(mainPage.elementOnMainPage()).shouldBe(Condition.visible);

    }

    @Description("Case 3: Main page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsMainPageMenu() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        $(mainPage.menuButton()).shouldBe(Condition.visible);

    }

    @Description("Case 3: Main page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsMainPageWelcomeToWorld() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        $(mainPage.welcomeToTheWorld()).shouldBe(Condition.visible);
    }

    @Description("Case 3: Main page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsMainPageWeArePassionate() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        $(mainPage.weArePassionate()).shouldBe(Condition.visible);

    }

    @Description("Case 3: Main page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsMainPageFindYourWine() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        $(mainPage.findYourWine()).shouldBe(Condition.visible);

    }

    @Description("Case 3: Main page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsMainPageFooter() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        $(mainPage.getFooter()).shouldBe(Condition.visible);

    }

    @Description("Case 4: Main page: Menu button logic (open header)")
    @Test
    public void menuButtonLogicOpen() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.menuButton().click();
        $(mainPage.yellowTailLogo()).shouldBe(Condition.visible);
    }

    @Description("Case 5:  Main page: Menu button logic (close header)")
    @Test
    public void menuButtonLogicClose() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.menuButton().click();
        mainPage.yellowTailLogo().click();
        $(mainPage.menuButton()).shouldBe(Condition.visible);
    }

    @Description("Case 8: Where to buy: enter valid postal code")
    @Test
    public void whereToBuyPage() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        WhereToBuyPage whereToBuyPage = mainPage.clickWhereToBuy();
        whereToBuyPage.findCountry(SYDNEY);
        $(whereToBuyPage.stockists()).shouldBe(Condition.visible);
    }

    @Description("Case 10: Cocktails: Navigate to Cocktail recipe page")
    @Test
    public void verifyNavigateToCocktailRecipePage() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);

        CocktailsPage cocktails = mainPage.clickCocktailsButton();
        WebElement element = cocktails.getRaspberry();
//        ((JavascriptExecutor) DriverProvider.INSTANCE.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        cocktails.fullRecipes().click();
        $(cocktails.ingridients()).shouldBe(Condition.visible);
    }

    @Description("Case 6: Main page: Global Nav logic")
    @Test
    public void verifyGlobalNavLogic() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.menuButton().click();
        mainPage.selectCountry().click();
        mainPage.selectCountryFromDropDown(CHINA);
        Assert.assertEquals(url(), EXPECTED_URL_CHINA);


        /**
         Case 7: Main page: Global Nav logic (CHINA - separate site is open)
         Тест будет падать так как на сайте баг

         */

    }

    @Description("Case 9: Cocktails: Select one wine")
    @Test
    public void verifyWinesDisplayed() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.clickCocktailsButton();
        CocktailsPage cocktails = mainPage.clickCocktailsButton();
        cocktails.selectCocktails(RED_WINE);
        ElementsCollection recipes = cocktails.getRecipes();
        Assert.assertEquals(recipes.size(), 9);
    }

    @Description("Case 11: Cocktails: Select several wines")
    @Test
    public void verifySelectSeveralWines() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        CocktailsPage cocktails = mainPage.clickCocktailsButton();
        cocktails.selectCocktails(RED_WINE, SPARKLINE_WINE);
        ElementsCollection recipes = cocktails.getRecipes();
        Assert.assertEquals(recipes.size(), 20);
    }

    @Description("Test just to fall ;) ")
    @Test
    public void ExtraTestToFall() {
        WelcomePage welcomePage = open(BASE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        CocktailsPage cocktails = mainPage.clickCocktailsButton();
        cocktails.selectCocktails(RED_WINE, SPARKLINE_WINE);
        ElementsCollection recipes = cocktails.getRecipes();
        Assert.assertEquals(recipes.size(), 0);
    }


}
