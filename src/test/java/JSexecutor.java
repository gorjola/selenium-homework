import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class JSexecutor {

    public static WebDriver driver;
    @BeforeTest
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }
    @Test
    public static void test1(){
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html ");

        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='container']//child::li[3]/span/i"))).build().perform();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement clicker=driver.findElement(By.xpath("//div[@id='container']//child::li[3]/span/i"));
        js.executeScript("arguments[0].click()",clicker);

    }
    @Test
    public static void test2(){
        driver.navigate().to("http://webdriveruniversity.com/Scrolling/index.html ");
        driver.manage().window().maximize();
        WebElement box=driver.findElement(By.xpath("//h1[@id='zone2-entries']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",box);
        System.out.println(js.executeScript("return arguments[0].textContent;", box));
        System.out.println(js.executeScript("return arguments[0].textContent;", box).equals("0 Entries"));

    }
    @AfterTest
    public static void end(){
        driver.close();
        driver.quit();

    }
}
