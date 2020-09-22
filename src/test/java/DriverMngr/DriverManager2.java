package DriverMngr;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverManager2 {
    static WebDriver driver;
    static Properties prop;
    static FileInputStream fis;
   static String urlName;


    public static WebDriver initializingDriver() throws IOException {
        prop = new Properties();
        fis = new FileInputStream("C:\\Users\\12812\\Junit_IQ_7_13_20\\src\\test\\java\\DriverMngr\\browser.properties");//get the data from browser.properties file
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        urlName=prop.getProperty("url");


        switch (browserName) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.get(urlName);


                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.get(urlName);

                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.get(urlName);

                break;
            }

//        if (browserName.equals("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.manage().deleteAllCookies();
//        } else if (browserName.equals("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            driver.manage().window().maximize();
//            driver.manage().deleteAllCookies();
//        }
//        else {
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//            driver.manage().window().maximize();
//            driver.manage().deleteAllCookies();
//        }
        }
        return driver;
    }
}