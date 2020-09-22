package firstClassVersions;

import Resource.Base;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author: Esra
 */

public class JunitExample extends Base {
    //static WebDriver driver;
    //    @BeforeAll
//    public static void setUp(){
//        WebDriverManager.chromedriver().setup(); //instead of System.setProperty("webDriver.crome.driver",(path")
//        driver= new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/");
//        driver.manage().window().maximize();
//    }
    @Test
    public void login(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
    }
    @Test
    public void addEmployee()throws InterruptedException{
        Actions action= new Actions(driver);
        WebElement pim= driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b"));
        action.moveToElement(pim).build().perform();
        WebElement addEmployee=driver.findElement(By.linkText("Add Employee"));
        addEmployee.click();
        driver.findElement(By.id("firstName")).sendKeys("Esra");
        driver.findElement(By.id("lastName")).sendKeys("Yilmaz");
        String expectedID=driver.findElement(By.cssSelector("#employeeId")).getAttribute("value");
        driver.findElement(By.id("btnSave")).click();
        String actualID= driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
        Assert.assertEquals("not equal",expectedID,actualID);
        driver.findElement(By.xpath("//a[text()='Welcome Admin']")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Logout")).click();
    }
}