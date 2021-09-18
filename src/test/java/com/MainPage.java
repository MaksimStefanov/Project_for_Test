package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.Constants.*;

public class MainPage {
    WebDriver driver;
    WebDriverWait wait;

    public MainPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void elementOnMainPageWait() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(MAIN_PAGE_ELEMENT)));
    }

    public WebElement elementOnMainPage() {
        return driver.findElement(By.xpath(MAIN_PAGE_ELEMENT));
    }

    public WebElement menuButton() {
        return driver.findElement(By.xpath(MAIN_PAGE_MENU));
    }

    public WebElement welcomeToTheWorld() {
        return driver.findElement(By.xpath("//*[contains(text(),'to the world of')]"));
    }

    public WebElement weArePassionate() {
        return driver.findElement(By.xpath("//p[@class='header-sub-copy'][contains(text(),'We are')]"));
    }

    public WebElement findYourWine() {
        return driver.findElement(By.xpath("//*[@class='button home-button']"));
    }

    public WebElement yellowTailLogo() {
        return driver.findElement(By.xpath("//div[@class='top-nav -active']/descendant::img[@alt='Yellow tail logo']"));
    }

    public WebElement getFooter() {
        return driver.findElement(By.id(FOOTER_ID));
    }


}
