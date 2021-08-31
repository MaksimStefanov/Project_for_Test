import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {


    @Test
    public void navigate(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ithillel.ua/");
        driver.findElement(By.xpath("//button[@id='btn-consultation-hero']")).click();
        WebElement temp = driver.findElement(By.xpath(Constants.PATH_TO_NAME));
                temp.sendKeys("Максим");

//        Assert.assertEquals(temp.getText(),"Максим");

        driver.quit();

    }

}
