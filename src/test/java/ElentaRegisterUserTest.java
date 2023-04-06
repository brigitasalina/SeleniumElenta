import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

import  static org.testng.Assert.*;


public class ElentaRegisterUserTest {


    @Test(priority = 1)
    public void registerUserTest(){
      assertTrue(User.registerUser(new User("Brigitalabas4", "brigita.salinaza@gmail.com","._5K%e","._5K%e")));

    }
    @Test(priority = 2)
    public void registerUserT2est(){
        assertTrue(User.registerUser(new User("Brigitalabas4", "brigita.salinazaza@gmail.com","._5K%e","._5K%e")));

    }
    @Test(priority = 3)
    public void registerNoUserNameTest(){
        assertTrue(User.registerUser(new User("", "brigita.salina01@gmail.com","._5K%e","._5K%e")));

    }
    @Test(priority = 4)
    public void registerIncorectUserNameTest(){
        assertTrue(User.registerUser(new User("/", "brigita.salina02@gmail.com","._5K%e","._5K%e")));

    }








    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.com.driver","drivers\\chromedriver111.exe");
        User.driver = new ChromeDriver();
        User.driver.manage().window().maximize();
        User.driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        User.driver.get("https://elenta.lt/prisijungti?returnurl=https%3A%2F%2Felenta.lt%2Fregistracija");
        User.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
    }

    @AfterClass
    public void afterClass(){
//        driver.quit();
    }


}
