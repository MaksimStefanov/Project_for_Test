package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.Constants.*;

public class CocktailsPage {

    WebDriver driver;
    @FindBy(xpath = RED_WINE)
    private WebElement red;
    @FindBy(xpath = ROSE_WINE)
    private WebElement rose;
    @FindBy(xpath = WHITE_WINE)
    private WebElement white;
    @FindBy(xpath = SPARKLINE_WINE)
    private WebElement sparkline;

    public CocktailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCocktails(String wine) {
        if (wine.equals(RED_WINE)) {
            red.click();
        } else if (wine.equals(ROSE_WINE)) {
            rose.click();
        } else if (wine.equals(WHITE_WINE)) {
            white.click();
        } else if (wine.equals(SPARKLINE_WINE)) {
            sparkline.click();

        }
    }
}
