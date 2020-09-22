package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOutPageObject {
    WebDriver lodriver;

    public LogOutPageObject(WebDriver driver) {
        lodriver=driver;
        PageFactory.initElements(lodriver,this);

    }

    @FindBy(xpath ="//a[text()='Welcome Admin']" )
    WebElement welcome;

    @FindBy(linkText ="Logout" )
    WebElement logOut;

      public void logOut(){
        welcome.click();
          WebDriverWait wait=new WebDriverWait(lodriver,5);
          wait.until(ExpectedConditions.visibilityOf(logOut));
          logOut.click();
      }

}
