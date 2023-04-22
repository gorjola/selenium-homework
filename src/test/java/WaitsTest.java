import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitsTest {

    public static WebDriver driver;


    @BeforeTest
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/progress-bar");

    }

    @Test
    public static void test1() {
        WebElement butt =driver.findElement(By.xpath("//button[@id='startStopButton']"));
        butt.click();
        driver.manage().timeouts().implicitlyWait(200000, TimeUnit.SECONDS);
        WebElement progressbarcheck = driver.findElement(By.xpath("//div[@aria-valuenow='100']"));

        System.out.println(progressbarcheck.getText());
    }

    @Test
    public static void test2(){
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html ");

        //DROPDOWN

        WebElement dropdown=driver.findElement(By.xpath("//select[@class='dropdown-menu-lists']"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("Python");
        WebElement o=select.getFirstSelectedOption();
        System.out.println("\n"+"DROPDOWN"+"\n");
        System.out.println(o.getText());
        System.out.println(o.getText().equals("Python"));
        System.out.println("\n"+"CHECKBOXES"+"\n");

        // CHECKBOXES

         List<WebElement>boxlist=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement i:boxlist){
            System.out.println(i.isEnabled());
            System.out.println(i.isDisplayed());
            System.out.println(i.isSelected());
           if(i.isDisplayed()&&i.isEnabled()&&(!(i.isSelected()))){
               i.click();
           }
        }

        System.out.println("\n"+"RADIO BUTTON"+"\n");


        // RADIO BUTTON

        WebElement radiobutton=driver.findElement(By.xpath("//input[@type='radio' and (@value='yellow')]"));
        System.out.println(radiobutton.isDisplayed());
        System.out.println(radiobutton.isEnabled());
        radiobutton.click();
        System.out.println(radiobutton.isSelected());


        System.out.println("\n"+"DROPDAWN ORANGE CHECK"+"\n");


        // DROPDAWN orange check

        WebElement fruitselect =driver.findElement(By.xpath("//select[@class='dropdown-menu-lists' and (@id='fruit-selects')]"));

        Select select1 =new Select(fruitselect);
        List<WebElement> options = select1.getOptions();
        for (WebElement x:options){
            if(!(x.isEnabled())){
                System.out.println(x.getText()+" is disabled");
            }
        }


       }
       @AfterTest
       public static void end(){
        driver.close();
        driver.quit();
       }

    }



