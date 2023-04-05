import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

import  static org.testng.Assert.*;


public class ElentaRegisterUserTest {


//    @Test
//    public void registerUserTest(){
//      assertTrue(User.registerUser(new User("Brigitalabas", "brigita.salina@gmail.com","._5K%e","._5K%e")));
//
//    }
    @Test
    public void registerUserTest(){
        assertTrue(User.registerUser(new User("Brigitalabas2", "brigita.salina00@gmail.com","._5K%e","._5K%e")));

    }
    @Test
    public void registerNoUserNameTest(){
        assertTrue(User.registerUser(new User("", "brigita.salina0@gmail.com","._5K%e","._5K%e")));

    }
    @Test
    public void registerIncorectUserNameTest(){
        assertTrue(User.registerUser(new User("/", "brigita.salina1@gmail.com","._5K%e","._5K%e")));

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
