package DriverMngr;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager1 {
    static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }
    public static void initDriver() {
        String browserNm = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        switch (browserNm) {
            case "chrome" : {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            }
            case "firefox" : {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            }
            default : {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            }
        }
    }
}