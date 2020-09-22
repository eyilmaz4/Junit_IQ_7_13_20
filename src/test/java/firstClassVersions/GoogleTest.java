package firstClassVersions;

import DriverMngr.DriverManager2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * @author Esra Yilmaz
 */
public class GoogleTest  {
   static WebDriver driver;
    @BeforeAll
    public static void setUp() throws IOException {
        //we can put url here instead


driver=DriverManager2.initializingDriver();
    }

    @Test
    public void GoogleTitle(){
       String title=driver.getTitle();
       Assertions.assertEquals("Gooogle",title,"not equal");

//TODO validation


    }
    @AfterAll
    public static void tearDown(){
driver.quit();
    }
}
