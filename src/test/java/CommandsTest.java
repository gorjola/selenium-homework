import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import static org.openqa.selenium.By.tagName;

public class CommandsTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        enableButton.click();
        Thread.sleep(5000);
        WebElement field=driver.findElement((By.xpath("//*[@id=\"input-example\"]/input")));
        field.isEnabled();
        WebElement text=driver.findElement(By.id("message"));
        text.isDisplayed();
        String  textfromlocal=text.getText();
        Assert.assertEquals(textfromlocal,"It's enabled!");
        String buttontext= enableButton.getText();
        Assert.assertEquals(buttontext,"Disable");
        field.sendKeys("Bootcamp");
        Thread.sleep(5000);
        field.clear();
        Thread.sleep(5000);

        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        WebElement boxA = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        WebElement boxB = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
        Assert.assertEquals(boxA.getLocation().getY(),boxB.getLocation().getY());














       // System.out.println(driver.getTitle());


    }
}
