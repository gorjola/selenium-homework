import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest {
    public static WebDriver driver;
    @BeforeTest
    public static void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();


    }
    @Test
    public static void test1(){
        driver.get("http://techcanvass.com/Examples/webtable.html");

        //ძაან პატარა კი ჩანს ეს კოდი მარა გეფიცები მთელი გული ჩავდე ))


        System.out.println("hondas price is -"+driver.findElement(By.xpath("//td[text()='Honda']/following-sibling::td[text()='6,00,000']")).getText());





    }
    @AfterTest
    public static void end(){
        driver.close();
        driver.quit();

    }

}

