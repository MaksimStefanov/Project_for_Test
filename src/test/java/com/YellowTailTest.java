package com;

import com.pages.CocktailsPage;
import com.pages.WelcomePage;
import com.pages.WhereToBuyPage;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.Constants.*;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class YellowTailTest extends TestNgRunner {

    @Description("Case 1: Welcome page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsWelcomePageLegalAge() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        welcomePage.legalAgeWait();
        Assert.assertTrue(welcomePage.legalAge().isDisplayed());
    }
    @Description("Case 1: Welcome page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsWelcomePageCheckBoxBeforeLegalAge() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        welcomePage.legalAgeWait();
        Assert.assertTrue(welcomePage.checkBox().isDisplayed());
    }
    @Description("Case 1: Welcome page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsWelcomePageSelectDropDown() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        welcomePage.legalAgeWait();
        Assert.assertTrue(welcomePage.dropDown().isDisplayed());
    }
    @Description("Case 1: Welcome page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsWelcomePageWelcomeButton() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        welcomePage.legalAgeWait();
        Assert.assertTrue(welcomePage.welcomeButton().isDisplayed());
    }
    @Description("Case 1: Welcome page: all required elements are displayed")
    @Test
    public void verifyInactiveItemsWelcomePageWelcomeButton() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        welcomePage.legalAgeWait();
        Assert.assertFalse(welcomePage.welcomeButton().isEnabled());
    }

    @Description("Case 2: Welcome page: navigate to main page as European customer")
    @Test
    public void verifyNavigateToMainPage() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        Assert.assertTrue(mainPage.elementOnMainPage().isDisplayed());
    }
    @Description("Case 3: Main page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsMainPageMenu() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        Assert.assertTrue(mainPage.menuButton().isDisplayed());
    }
    @Description("Case 3: Main page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsMainPageWelcomeToWorld() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        Assert.assertTrue(mainPage.welcomeToTheWorld().isDisplayed());
    }
    @Description("Case 3: Main page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsMainPageWeArePassionate() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        Assert.assertTrue(mainPage.weArePassionate().isDisplayed());
    }
    @Description("Case 3: Main page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsMainPageFindYourWine() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        Assert.assertTrue(mainPage.findYourWine().isDisplayed());
    }
    @Description("Case 3: Main page: all required elements are displayed")
    @Test
    public void verifyDisplayedItemsMainPageFooter() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        Assert.assertTrue(mainPage.getFooter().isDisplayed());
    }
    @Description("Case 4: Main page: Menu button logic (open header)")
    @Test
    public void menuButtonLogicOpen() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.menuButtonWait();
        mainPage.menuButton().click();
        mainPage.yellowTailLogoWait();
        Assert.assertTrue(mainPage.yellowTailLogo().isDisplayed());

    }
    @Description("Case 5:  Main page: Menu button logic (close header)")
    @Test
    public void menuButtonLogicClose() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.menuButtonWait();
        mainPage.menuButton().click();
        mainPage.yellowTailLogoWait();
        mainPage.yellowTailLogo().click();
        mainPage.menuButtonWait();
        Assert.assertTrue(mainPage.menuButton().isDisplayed());

    }
    @Description("Case 8: Where to buy: enter valid postal code")
    @Test
    public void whereToBuyPage() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        WhereToBuyPage whereToBuyPage = mainPage.clickWhereToBuy();
        whereToBuyPage.findCountry(SYDNEY);
        Assert.assertTrue(whereToBuyPage.stockists().isDisplayed());
    }
    @Description("Case 10: Cocktails: Navigate to Cocktail recipe page")
    @Test
    public void verifyNavigateToCocktailRecipePage() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        CocktailsPage cocktails = mainPage.clickCocktailsButton();
        WebElement element = cocktails.getRaspberry();
        ((JavascriptExecutor) DriverProvider.INSTANCE.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        cocktails.fullRecipes().click();
        Assert.assertTrue(cocktails.ingridients().isDisplayed());
    }
    @Description("Case 6: Main page: Global Nav logic")
    @Test
    public void verifyGlobalNavLogic() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        mainPage.menuButtonWait();
        mainPage.menuButton().click();
        mainPage.yellowTailLogoWait();
        mainPage.selectCountry().click();
        mainPage.selectCountryFromDropDown(CHINA);
        Assert.assertEquals(DriverProvider.INSTANCE.getDriver().getCurrentUrl(), EXPECTED_URL_CHINA);

        /**
         Case 7: Main page: Global Nav logic (CHINA - separate site is open)
         Тест будет падать так как на сайте баг

         */

    }
    @Description("Case 9: Cocktails: Select one wine")
    @Test
    public void verifyWinesDisplayed() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        mainPage.clickCocktailsButton();
        Thread.sleep(1000);
        CocktailsPage cocktails = mainPage.clickCocktailsButton();
        cocktails.selectCocktails(RED_WINE);
        List<WebElement> recipes = cocktails.getRecipes();
        Assert.assertEquals(recipes.size(), 9);
    }

    @Description("Case 11: Cocktails: Select several wines")
    @Test
    public void verifySelectSeveralWines() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        CocktailsPage cocktails = mainPage.clickCocktailsButton();
        cocktails.selectCocktails(RED_WINE, SPARKLINE_WINE);
        List<WebElement> recipes = cocktails.getRecipes();
        Assert.assertEquals(recipes.size(), 20);
    }
    @Description("Test just to fall ;) ")
    @Test
    public void ExtraTestToFall()  {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        CocktailsPage cocktails = mainPage.clickCocktailsButton();
        cocktails.selectCocktails(RED_WINE, SPARKLINE_WINE);
        List<WebElement> recipes = cocktails.getRecipes();
        Assert.assertEquals(recipes.size(), 0);
    }


}
