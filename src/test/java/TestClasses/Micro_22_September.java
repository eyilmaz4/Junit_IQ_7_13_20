package TestClasses;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Micro_22_September {
    static WebDriver driver;
    static JavascriptExecutor jse;
    @BeforeAll
    public static void setup(){
         WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        jse=(JavascriptExecutor) driver;
        jse.executeScript("window.location='https://the-internet.herokuapp.com/");

    }
    @Test
    public void test1() throws InterruptedException {
        WebElement element=driver.findElement(By.xpath("//*[text()='Infinite Scroll']"));
        element.click();
        Thread.sleep(10000);
        jse.executeScript("window.scrollBy(1,1800)");//scroll down, if you want up give negative value
        Thread.sleep(5000);
        jse.executeScript("window.scrollBy(1,-1800)");

        /**
        WebElement showMore=driver.findElement(By.xpath("//a[text()='Online Banking Service Agreement']"));
        WebElement agree=(WebElement)jse.executeScript("return document.getElementById('footer_bofa_online_banking_service_agreement')");
        jse.executeScript("arguments[0].scrollIntoView(true)",showMore); */

    }


    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
