package com.pages;

import com.DriverProvider;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import static com.Constants.BASE_URL;

public class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(DriverProvider.INSTANCE.getDriver(), this);
    }


}
