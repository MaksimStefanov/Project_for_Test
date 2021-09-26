package com.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.Constants.*;

public class CocktailsPage {


    @FindBy(xpath = SELECT_COCTAILS_INIT_X)
    private SelenideElement selectInitial;
    @FindBy(xpath = RED_WINE)
    private SelenideElement red;
    @FindBy(xpath = ROSE_WINE)
    private SelenideElement rose;
    @FindBy(xpath = WHITE_WINE)
    private SelenideElement white;
    @FindBy(xpath = SPARKLINE_WINE)
    private SelenideElement sparkline;
    @FindBy(xpath = RECIPES_X)
    private ElementsCollection recipes;
    @FindBy(xpath = RASPBERRY_COCKTAIL_X)
    private SelenideElement raspberry;
    @FindBy(xpath = FULL_RECIPE_X)
    private SelenideElement fullRecipes;
    @FindBy(xpath = INGREDIENTS_X)
    private SelenideElement ingridients;


    public void selectCocktails(String wine) {
        selectInitial.click();
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
        selectInitial.click();
        if (wine.equals(RED_WINE) || wine2.equals(RED_WINE)) {
            red.click();
        }  if (wine.equals(ROSE_WINE) || wine2.equals(ROSE_WINE)) {
            rose.click();
        }  if (wine.equals(WHITE_WINE) || wine2.equals(WHITE_WINE)) {
            white.click();
        }  if (wine.equals(SPARKLINE_WINE) || wine2.equals(SPARKLINE_WINE)) {
            sparkline.click();
        }
        selectInitial.click();
    }
    @Step
    public ElementsCollection getRecipes() {
        return recipes;
    }
    @Step
    public SelenideElement getRaspberry() {
        return raspberry;
    }
    @Step
    public SelenideElement fullRecipes() {
        return fullRecipes;
    }
    @Step
    public SelenideElement ingridients() {
        return ingridients;
    }
}