import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

import  static org.testng.Assert.*;


public class ElentaRegisterUserTest {


    @Test
    public void registerUserTest(){
        User user = new User("Brigita", "brigita.salina@gmail.com","tralialia","tralialia");
        assertTrue( User.registerUser(user) );
    }







    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.com.driver","drivers\\chromedriver111.exe");
        User.driver = new ChromeDriver();
        User.driver.manage().window().maximize();
        User.driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterClass
    public void afterClass(){
//        driver.quit();
    }


}
