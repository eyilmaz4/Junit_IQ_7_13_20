package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject {
    WebDriver hdriver;
    public HomePageObject(WebDriver driver){
        hdriver=driver;
        PageFactory.initElements(hdriver, this);
    }
    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']/b")
    WebElement pim;

    @FindBy(linkText = "Add Employee")
    WebElement addEmployee;

    public void navigateToAddEmployee(){
        Actions action= new Actions(hdriver);
        action.moveToElement(pim).build().perform();
        WebDriverWait wait=new WebDriverWait(hdriver,5);
        wait.until(ExpectedConditions.visibilityOf(addEmployee));
        addEmployee.click();
    }


}
