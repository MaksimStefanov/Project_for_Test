package com;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.Constants.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.awt.windows.ThemeReader;

import java.util.List;

public class YellowTailTest {
    WebDriver driver;


    @BeforeMethod
    public void properties() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void closeDriver() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.quit();
    }

    @Test(description = "Case 1: Welcome page: all required elements are displayed")
    public void verifyDisplayedItemsWelcomePageLegalAge() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        welcomePage.legalAgeWait();
        Assert.assertTrue(welcomePage.legalAge().isDisplayed());
    }

    @Test(description = "Case 1: Welcome page: all required elements are displayed")
    public void verifyDisplayedItemsWelcomePageCheckBoxBeforeLegalAge() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        welcomePage.legalAgeWait();
        Assert.assertTrue(welcomePage.checkBox().isDisplayed());
    }

    @Test(description = "Case 1: Welcome page: all required elements are displayed")
    public void verifyDisplayedItemsWelcomePageSelectDropDown() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        welcomePage.legalAgeWait();
        Assert.assertTrue(welcomePage.dropDown().isDisplayed());
    }

    @Test(description = "Case 1: Welcome page: all required elements are displayed")
    public void verifyDisplayedItemsWelcomePageWelcomeButton() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        welcomePage.legalAgeWait();
        Assert.assertTrue(welcomePage.welcomeButton().isDisplayed());
    }

    @Test(description = "Case 1: Welcome page: all required elements are displayed")
    public void verifyInactiveItemsWelcomePageWelcomeButton() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        welcomePage.legalAgeWait();
        Assert.assertFalse(welcomePage.welcomeButton().isEnabled());
    }


    @Test(description = "Case 2: Welcome page: navigate to main page as European customer")
    public void verifyNavigateToMainPage() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        Assert.assertTrue(mainPage.elementOnMainPage().isDisplayed());
    }

    @Test(description = "Case 3: Main page: all required elements are displayed")
    public void verifyDisplayedItemsMainPageMenu() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        Assert.assertTrue(mainPage.menuButton().isDisplayed());
    }

    @Test(description = "Case 3: Main page: all required elements are displayed")
    public void verifyDisplayedItemsMainPageWelcomeToWorld() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        Assert.assertTrue(mainPage.welcomeToTheWorld().isDisplayed());
    }

    @Test(description = "Case 3: Main page: all required elements are displayed")
    public void verifyDisplayedItemsMainPageWeArePassionate() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        Assert.assertTrue(mainPage.weArePassionate().isDisplayed());
    }

    @Test(description = "Case 3: Main page: all required elements are displayed")
    public void verifyDisplayedItemsMainPageFindYourWine() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        Assert.assertTrue(mainPage.findYourWine().isDisplayed());
    }

    @Test(description = "Case 3: Main page: all required elements are displayed")
    public void verifyDisplayedItemsMainPageFooter() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        Assert.assertTrue(mainPage.getFooter().isDisplayed());
    }

    @Test(description = "Case 4: Main page: Menu button logic (open header)")
    public void menuButtonLogicOpen()   {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.menuButtonWait();
        mainPage.menuButton().click();
        mainPage.yellowTailLogoWait();
        Assert.assertTrue(mainPage.yellowTailLogo().isDisplayed());

    }

    @Test(description = "Case 5:  Main page: Menu button logic (close header)")
    public void menuButtonLogicClose()   {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.menuButtonWait();
        mainPage.menuButton().click();
        mainPage.yellowTailLogoWait();
        mainPage.yellowTailLogo().click();
        mainPage.menuButtonWait();
        Assert.assertTrue(mainPage.menuButton().isDisplayed());

    }

    @Test(description = "Case 8: Where to buy: enter valid postal code")
    public void whereToBuyPage()  {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        driver.findElement(By.xpath("//a[text()='Where to Buy']")).click();
        driver.findElement(By.id("locationName")).sendKeys("Sydney");
        driver.findElement(By.xpath("//button[@class='search-submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Stockists in your area')]")).isDisplayed());
    }

    @Test(description = "Case 10: Cocktails: Navigate to Cocktail recipe page")
    public void verifyNavigateToCocktailRecipePage() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        mainPage.clickCocktailsButton();
        WebElement element = driver.findElement(By.xpath("//img[@alt='Raspberry Rose']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath("//img[@alt='Raspberry Rose']/parent::a/descendant::div[contains(text(),'Full recipe')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ingredients']")).isDisplayed());
    }

    @Test(description = "Case 6: Main page: Global Nav logic")
    public void verifyGlobalNavLogic() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        mainPage.menuButtonWait();
        mainPage.menuButton().click();

        mainPage.selectCountry().click();
        mainPage.selectCountryFromDropDown(CHINA);
        Assert.assertEquals(driver.getCurrentUrl(), EXPECTED_URL_CHINA);

        /**
         Case 7: Main page: Global Nav logic (CHINA - separate site is open)
         Тест будет падать так как на сайте баг

         */

    }

    @Test(description = "Case 9: Cocktails: Select one wine")
    public void verifyWinesDisplayed() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        mainPage.clickCocktailsButton();
        CocktailsPage cocktails = mainPage.clickCocktailsButton();
        cocktails.selectCocktails(RED_WINE);

        List<WebElement> recipes = driver.findElements(By.xpath("//div[@class='tile recipe-tile']"));
        Assert.assertEquals(recipes.size(), 9);
    }


    @Test(description = "Case 11: Cocktails: Select several wines")
    public void verifySelectSeveralWines() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openBrowser();
        MainPage mainPage = welcomePage.logInToMainPage(EUROPE);
        mainPage.elementOnMainPageWait();
        driver.findElement(By.xpath("//a[contains(text(),'Cocktails')]")).click();
        driver.findElement(By.xpath("//a[@class='selected']")).click();
        driver.findElement(By.xpath("//a[@data-value='red']")).click();
        driver.findElement(By.xpath("//a[@data-value='bubbles']")).click();

        List<WebElement> recipes = driver.findElements(By.xpath("//div[@class='tile recipe-tile']"));
        Assert.assertEquals(recipes.size(), 20);
    }


}
