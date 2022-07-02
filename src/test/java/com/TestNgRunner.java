package com;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNgRunner {


    @BeforeMethod
    public void properties() {
        DriverProvider.INSTANCE.getDriver();

    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(ITestResult result) {
        if(!result.isSuccess()){
            makeScreenshot();
        }
         DriverProvider.INSTANCE.getDriver().quit();
        DriverProvider.INSTANCE.removeDriver();
    }
    @Attachment(value = "Page screenshot", type = "img/png")
    public byte[] makeScreenshot(){
        return ((TakesScreenshot) DriverProvider.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
