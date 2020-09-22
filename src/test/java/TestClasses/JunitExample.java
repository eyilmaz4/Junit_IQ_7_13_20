package TestClasses;

import Resource.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pageObjects.AddEmployeeObject;
import pageObjects.HomePageObject;
import pageObjects.LogOutPageObject;
import pageObjects.LoginPageObject;

/**
 * @author: Esra
 */
import java.util.List;
public class JunitExample extends Base {
    LoginPageObject loginPageObject;
    HomePageObject homePageObject;
    AddEmployeeObject addEmployeeObject;
    LogOutPageObject logOutPageObject;


    @Test
    public void login(){
        LoginPageObject loginPageObject= new LoginPageObject(driver);
        loginPageObject.loginCredentials();

    }
    @Test
    public void addEmployee()throws InterruptedException{
        homePageObject=new HomePageObject(driver);
        homePageObject.navigateToAddEmployee();
        addEmployeeObject=new AddEmployeeObject(driver);
        addEmployeeObject.saveEmployee();
        logOutPageObject=new LogOutPageObject(driver);
        logOutPageObject.logOut();





    }
}