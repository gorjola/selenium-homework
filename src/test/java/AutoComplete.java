import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.List;

public class AutoComplete {
    public static WebDriver driver;
    @BeforeTest
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
    @Test
    public static void test1(){

        WebElement textfield= driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        textfield.sendKeys("Automation ");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> suggestionElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='UUbT9']")));
        for (WebElement x:suggestionElements){
            System.out.println(x.getText());
        }
      WebElement  lastelement=suggestionElements.get(suggestionElements.size()-1);
        lastelement.click();

    }
    @AfterTest
    public static void end(){
        driver.close();
        driver.quit();

    }
}
