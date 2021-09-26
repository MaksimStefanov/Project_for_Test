package com.pages;


import com.MainPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.Constants.*;
import static com.Constants.LEGAL_AGE_X;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class WelcomePage  {

    @FindBy(xpath = CONFIRMATION_CHECKBOX_X)
    private SelenideElement confirmationCheckbox;
    @FindBy(xpath = SELECT_OPTIONS_X)
    private SelenideElement selectOptions;
    @FindBy(xpath = WELCOME_BUTTON_X)
    private SelenideElement welcomeButton;
    @FindBy(xpath = LEGAL_AGE_X)
    private SelenideElement legalAge;
    @FindBy(xpath = CHECKBOX_X)
    private SelenideElement checkbox;



    public MainPage logInToMainPage(String country) {
        confirmationCheckbox.click();
        Select dropDown = new Select(selectOptions);
        dropDown.selectByVisibleText(country);
        welcomeButton.click();
        return page (MainPage.class);

    }



    @Step
    public WebElement legalAge() {
        return legalAge;
    }

    @Step
    public WebElement checkBox() {
        return $(By.xpath(CHECKBOX_X));
    }
    @Step
    public WebElement dropDown() {
        return selectOptions;
    }
    @Step
    public WebElement welcomeButton() {
        return welcomeButton;
    }

}
