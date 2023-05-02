import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class blablabla {

    public static WebDriver driver;
    @BeforeTest
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.swoop.ge");
        driver.manage().window().maximize();
    }
    @Test
    public static void test1(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement dasveneba=driver.findElement(By.xpath("//label[text()='დასვენება']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(dasveneba).perform();
        List<WebElement> elements = driver.findElements(By.xpath("//label[contains(text(),'დასვენება')]"));
        WebElement kaxeti = elements.get(elements.size() - 1);
        kaxeti.click();
        List <WebElement> sastumroebi=driver.findElements(By.xpath("//div[@class='special-offer-title']"));
        WebElement pirvelisastumro=sastumroebi.get(0);
        WebElement sastumrossaxeli = driver.findElement(By.className("merchantTitle"));
        pirvelisastumro.click();
        WebElement kalata=driver.findElement(By.xpath("//div[@class='addBasket']"));
        kalata.click();
        WebElement kalata2= driver.findElement(By.xpath("//a[@class='basket-top-header']"));
        kalata2.click();

        WebElement checkkalatatext=driver.findElement(By.xpath("//p[@class='item-title desktop-version']/child::a"));
        System.out.println(sastumrossaxeli.getText());





    }
}

