import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

import  static org.testng.Assert.*;


public class ElentaRegisterUserTest {


    @Test(priority = 1)
    public void registerUserCorrectInputTest(){
      assertTrue(User.registerUser(new User("Brigitalabas4010", "brigita00.salinazaz@gmail.com","._5K%e","._5K%e")));
    }
    @Test(priority = 2)
    public void registerUser2Test(){
        assertFalse(User.registerUser(new User("Brigitalabas4010", "brigita00.salinazaz@gmail.com","._5K%e","._5K%e")));
    }
    @Test(priority = 3)
    public void registerNoUserNameTest(){
        assertFalse(User.registerUser(new User("", "brigita.salina011@gmail.com","._5K%e","._5K%e")));
    }
    @Test(priority = 4)
    public void registerIncorectUserNameTest(){
        assertFalse(User.registerUser(new User("@#$%^", "brigita.sali56456na022@gmail.com","qqqqqqqqq","qqqqqqqqq")));
    }
    @Test(priority = 5)
    public void EmptyEmailTest(){
        assertFalse(User.registerUser(new User("Brigita3", "","._5K%e","._5K%e")));
    }
    @Test(priority = 6)
    public void NumbersEmailTest(){
        assertFalse(User.registerUser(new User("Brigita134", "1234@7363","lalalapa","lalalapa")));
    }
    @Test(priority = 7)
    public void EmptyPasswordTest(){
        assertFalse(User.registerUser(new User("Brig54ita4", "brigita56100.salinazaza@gmail.com","","._5K%e")));
    }
    @Test(priority = 8)
    public void ToShortPasswordTest(){
        assertFalse(User.registerUser(new User("Brigitxaqq0f9", "brigixtaqq00.salinazazafff@gmail.com","lo","lo")));
    }
    @Test(priority = 9)
    public void EmptyPassword2Test(){
        assertFalse(User.registerUser(new User("Brigita08", "brigita00.salinazazas@gmail.com","lapasla","")));
    }
    @Test(priority = 10)
    public void passwordsMissMatchTest(){
        assertFalse(User.registerUser(new User("Brigita091", "brigita00.salinatr@gmail.com","lapasla","lapas")));
    }
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.com.driver","drivers\\chromedriver111.exe");
        User.driver = new ChromeDriver();
        User.driver.manage().window().maximize();
        User.driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        User.driver.get("https://elenta.lt/prisijungti?returnurl=https%3A%2F%2Felenta.lt%2Fregistracija");
        User.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
    }

    @AfterClass
    public void afterClass(){
//        driver.quit();
    }


}
