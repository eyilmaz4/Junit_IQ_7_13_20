package Resource;
import DriverMngr.DriverManager1;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
public class Base extends DriverManager1 {
    public static WebDriver driver;
    @BeforeAll
    public static void setUp(){
        driver = getDriver();
        // driver= DriverManager1.getDriver();//This line makes the local driver equal to the driver in managerdriver class
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}