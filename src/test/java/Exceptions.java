import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exceptions {
    public static WebDriver driver;

    @BeforeTest
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/alerts ");
    }

    @Test
    public static void test1() {
        WebElement butt = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        WebDriverWait waiting = new WebDriverWait(driver, 3);

        butt.click();
        try {

            waiting.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            System.out.println("no alert");
        }


    }


    @Test
    public static void test2() {


        WebElement butt = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));

        butt.click();


        try {

            driver.switchTo().alert().accept();

        } catch (NoAlertPresentException e) {
            System.out.println("no alert 2");
        }


    }
    @Test
    public static void test3(){




        try {
            //driver.findElement(By.xpath("//button[@id='alertButton']")).click();
            //driver.navigate().refresh();

           // StaleElementReferenceException  ver gamoviwvie veraprit da gavanebe tavi :D


        } catch (StaleElementReferenceException e){
            System.out.println("no alert again");
        }

}
    @AfterTest
    public static void end(){
        driver.close();
        driver.quit();

    }
}
