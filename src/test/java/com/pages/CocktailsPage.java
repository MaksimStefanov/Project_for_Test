package com.pages;

import com.DriverProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.Constants.*;

public class CocktailsPage extends AbstractPage {

    WebDriver driver;
    @FindBy(xpath = SELECT_COCTAILS_INIT_X)
    private WebElement selectInitial;
    @FindBy(xpath = RED_WINE)
    private WebElement red;
    @FindBy(xpath = ROSE_WINE)
    private WebElement rose;
    @FindBy(xpath = WHITE_WINE)
    private WebElement white;
    @FindBy(xpath = SPARKLINE_WINE)
    private WebElement sparkline;
    @FindBy(xpath = RECIPES_X)
    private List<WebElement> recipes;
    @FindBy(xpath = RASPBERRY_COCKTAIL_X)
    private WebElement raspberry;
    @FindBy(xpath = FULL_RECIPE_X)
    private WebElement fullRecipes;
    @FindBy(xpath = INGREDIENTS_X)
    private WebElement ingridients;


    public CocktailsPage() {
        super();
        this.driver = DriverProvider.INSTANCE.getDriver();
    }

    public void selectCocktails(String wine) {
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(selectInitial));
        selectInitial.click();
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(red));
        if (wine.equals(RED_WINE)) {
            red.click();
        } else if (wine.equals(ROSE_WINE)) {
            rose.click();
        } else if (wine.equals(WHITE_WINE)) {
            white.click();
        } else if (wine.equals(SPARKLINE_WINE)) {
            sparkline.click();

        }
        selectInitial.click();

    }
    @Step
    public void selectCocktails(String wine, String wine2)  {
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(selectInitial));
        selectInitial.click();
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(red));
        if (wine.equals(RED_WINE) || wine2.equals(RED_WINE)) {
            red.click();
        }  if (wine.equals(ROSE_WINE) || wine2.equals(ROSE_WINE)) {
            (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(rose));
            rose.click();
        }  if (wine.equals(WHITE_WINE) || wine2.equals(WHITE_WINE)) {
            (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(white));
            white.click();
        }  if (wine.equals(SPARKLINE_WINE) || wine2.equals(SPARKLINE_WINE)) {
            (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(sparkline));
            sparkline.click();
        }
        selectInitial.click();
    }
    @Step
    public List<WebElement> getRecipes() {
        return recipes;
    }
    @Step
    public WebElement getRaspberry() {
        return raspberry;
    }
    @Step
    public WebElement fullRecipes() {
        return fullRecipes;
    }
    @Step
    public WebElement ingridients() {
        return ingridients;
    }
}