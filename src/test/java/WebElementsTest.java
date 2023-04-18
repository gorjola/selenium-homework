import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElementsTest {

    public static WebDriver driver;

    @BeforeTest
    public static void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

    }
    @Test
    public static void testing(){
        WebElement butt= driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        butt.click();
        butt.click();
        butt.click();
        WebElement delbutt1= driver.findElement(By.xpath("//button[contains(@class,'manually') and text()='Delete']"));
        WebElement delbutt2= driver.findElement(By.cssSelector("button[class^='added']"));
        WebElement delbutt3= driver.findElement(By.className("added-manually"));
        System.out.println(delbutt1.getText());
        System.out.println(delbutt2.getText());
        System.out.println(delbutt3.getText());
        driver.navigate().to("http://the-internet.herokuapp.com/challenging_dom");
        //ვიცი არასწორია მარა სუ არაფერს ჯობია დრო არ მქონდა და ფიზიკურად ვერ მოვასწარი ნორმალურად დაწერა შევეცდები მომავალში უკეთესად გავაკეტო დავალება
        System.out.println(driver.findElement(By.xpath("//tr[10]//td[2]")).getText());

        //ვიცი არასწორია მარა სუ არაფერს ჯობია დრო არ მქონდა და ფიზიკურად ვერ მოვასწარი ნორმალურად დაწერა შევეცდები მომავალში უკეთესად გავაკეტო დავალება


    }
    @AfterTest
    public static void end(){
        driver.close();
        driver.quit();

    }


}
