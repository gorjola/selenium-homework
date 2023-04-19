import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwitchToTest {
    public static WebDriver driver;
    @BeforeTest
    public static void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();


    }
    @Test
    public static void test1() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");
        WebElement text1 = driver.findElement(By.xpath("//body[@class='mce-content-body ']"));
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        text1.clear();
        text1.sendKeys("Here Goes");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@title='Align center']")).click();


    }
    @Test
    public static void test2(){
        driver.navigate().to("https://demoqa.com/alerts");
        String mainwindow =driver.getWindowHandle();
        WebElement click= driver.findElement(By.xpath("//button[@id='alertButton']"));
        click.click();
        driver.switchTo().alert().accept();



    }
    @AfterTest
    public static void end(){
        driver.close();
        driver.quit();

    }


}
