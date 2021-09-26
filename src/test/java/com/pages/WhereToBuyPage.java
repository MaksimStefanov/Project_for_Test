package com.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


import static com.Constants.*;

public class WhereToBuyPage  {


    @FindBy(id = SEARCH_FIELD)
    private SelenideElement searchField;

    @FindBy(xpath = SEARCH_BUTTON_X)
    private SelenideElement search;

    @FindBy(xpath = STOCKISTS_X)
    private SelenideElement stockists;

    public void findCountry(String country) {
        searchField.setValue(country);
        search.click();
    }

    public SelenideElement stockists() {
        return stockists;
    }


}
