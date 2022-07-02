package com.pages;

import com.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.Constants.*;

public class WhereToBuyPage extends AbstractPage {
    WebDriver driver;

    public WhereToBuyPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    @FindBy(id = SEARCH_FIELD)
    private WebElement searchField;

    @FindBy(xpath = SEARCH_BUTTON_X)
    private WebElement search;

    @FindBy(xpath = STOCKISTS_X)
    private WebElement stockists;

    public void findCountry(String country) {
        searchField.sendKeys(country);
        search.click();
        (new WebDriverWait(DriverProvider.INSTANCE.getDriver(), 4)).until(ExpectedConditions.visibilityOf(stockists));
    }

    public WebElement stockists() {
        return stockists;
    }


}
