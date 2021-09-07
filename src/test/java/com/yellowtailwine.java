package com;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class yellowtailwine {
    WebDriver driver;
    WebDriverWait wait;

//    @BeforeClass
//    public void raiseBrowser() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//    }

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
    public void menuButtonLogic() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='confirmation-checkbox']/child::label")).click();
        Select dropDown = new Select(driver.findElement(By.id("agegate-selector-options")));
        dropDown.selectByVisibleText("Europe");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Menu')]")));
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

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        driver.quit();
        Thread.sleep(2);
    }
}