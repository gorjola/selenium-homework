import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class CrossBrowserTest {

    public static WebDriver driver;
    @BeforeTest
    @Parameters({"browser"})
    public static void setup(@Optional("chrome") String browser) throws Exception{
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        else {
            throw new Exception("Incorrect Browser");
        }
    }

    @Test
    public static void test1() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html ");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='container']//child::li[3]/span/i"))).build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement clicker = driver.findElement(By.xpath("//div[@id='container']//child::li[3]/span/i"));
        js.executeScript("arguments[0].click()", clicker);

    }

    @AfterTest
    public static void end() {
        driver.close();
        driver.quit();
    }
}