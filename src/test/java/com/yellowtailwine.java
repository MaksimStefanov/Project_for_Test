package com;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class yellowtailwine {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.yellowtailwine.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "Case 1: Welcome page: all required elements are displayed")
    public void verifyDisplayedItemsWelcomePageLegalAge() {
        Assert.assertTrue(driver.findElement(By.xpath("//label[@for='confirm']")).isDisplayed());
    }

    @Test(description = "Case 1: Welcome page: all required elements are displayed")
    public void verifyDisplayedItemsWelcomePageCheckBoxBeforeLegalAge() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-bars']/span")).isDisplayed());
    }

    @Test(description = "Case 1: Welcome page: all required elements are displayed")
    public void verifyDisplayedItemsWelcomePageSelectDropDown() {
        Assert.assertTrue(driver.findElement(By.className("agegate-selector-options")).isDisplayed());
    }

    @Test(description = "Case 1: Welcome page: all required elements are displayed")
    public void verifyDisplayedItemsWelcomePageWelcomeButton() {
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='submit']")).isDisplayed());
    }

    @Test(description = "Case 1: Welcome page: all required elements are displayed")
    public void verifyInactiveItemsWelcomePageWelcomeButton() {
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='submit']")).isEnabled());
    }


    @Test(description = "Case 2: Welcome page: navigate to main page as European customer")
    public void verifyNavigateToMainPage() {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='header-sub-copy'][contains(text(),'We are')]")).isDisplayed());
    }

    @Test(description = "Case 3: Main page: all required elements are displayed")
    public void verifyDisplayedItemsMainPageMenu() {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Menu')]")).isDisplayed());
    }

    @Test(description = "Case 3: Main page: all required elements are displayed")
    public void verifyDisplayedItemsMainPageWelcomeToWorld() {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Welcome')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'to the world of')]")).isDisplayed());
    }

    @Test(description = "Case 3: Main page: all required elements are displayed")
    public void verifyDisplayedItemsMainPageWeArePassionate() {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='header-sub-copy'][contains(text(),'We are')]")).isDisplayed());
    }

    @Test(description = "Case 3: Main page: all required elements are displayed")
    public void verifyDisplayedItemsMainPageFindYourWine() {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='button home-button']")).isDisplayed());
    }

    @Test(description = "Case 3: Main page: all required elements are displayed")
    public void verifyDisplayedItemsMainPageFooter() {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.id("primary-footer")).isDisplayed());
    }

    @Test(description = "Case 4: Main page: Menu button logic (open header)")
    public void menuButtonLogicOpen() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Menu')]")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='top-nav -active']/descendant::img[@alt='Yellow tail logo']")).isDisplayed());

    }
    @Test(description = "Case 5:  Main page: Menu button logic (close header)")
    public void menuButtonLogicClose() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Menu')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='top-nav -active']/descendant::img[@alt='Yellow tail logo']")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Menu')]")).isDisplayed());

    }

    @Test(description = "Case 8: Where to buy: enter valid postal code")
    public void whereToBuyPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Where to Buy']")).click();
        driver.findElement(By.id("locationName")).sendKeys("Sydney");
        driver.findElement(By.xpath("//button[@class='search-submit']")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Stockists in your area')]")).isDisplayed());
    }

    @Test(description = "Case 10: Cocktails: Navigate to Cocktail recipe page")
    public void verifyNavigateToCocktailRecipePage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Cocktails')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//img[@alt='Raspberry Rose']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath("//img[@alt='Raspberry Rose']/parent::a/descendant::div[contains(text(),'Full recipe')]")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ingredients']")).isDisplayed());
    }

    @Test(description = "Case 6: Main page: Global Nav logic") // не проходит
    public void verifyGlobalNavLogic() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Menu')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id='country-select']/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-key='CN']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.yellowtailwine.cn/");

        /**
         Case 7: Main page: Global Nav logic (CHINA - separate site is open)
         Тест будет падать так как на сайте баг

         */

    }

    @Test(description = "Case 9: Cocktails: Select one wine")
    public void verifyWinesDisplayed() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Cocktails')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='selected']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-value='red']")).click();
        Thread.sleep(2000);

        List<WebElement> recipes = driver.findElements(By.xpath("//div[@data-types='red']/descendant::div[contains(text(),'Full recipe')]"));
        Assert.assertEquals(recipes.size(),9);    }


    @Test(description = "Case 11: Cocktails: Select several wines")
    public void verifySelectSeveralWines() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Cocktails')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='selected']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-value='red']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-value='bubbles']")).click();
        Thread.sleep(2000);

        List<WebElement> recipes = driver.findElements(By.xpath("//div[@data-types='red' or @data-types='bubbles']/descendant::div[contains(text(),'Full recipe')]"));
        Assert.assertEquals(recipes.size(),20);
    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        driver.quit();
        Thread.sleep(2);
    }
}