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
        //driver.get("https://the-internet.herokuapp.com/");
        driver.manage().deleteAllCookies();
        jse=(JavascriptExecutor) driver;
        jse.executeScript("window.location=arguments[0]","https://the-internet.herokuapp.com/ ");

    }

    /**
     * This test is for Scroll Down/Up
     * @throws InterruptedException
     */
    @Test
    public void test1() throws InterruptedException {
        WebElement element=driver.findElement(By.xpath("//*[text()='Infinite Scroll']"));
        element.click();
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(1,1800)");//scroll down, if you want up give negative value
        Thread.sleep(5000);
        jse.executeScript("window.scrollBy(1,-1800)");


    }


    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
