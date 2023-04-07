
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

import  static org.testng.Assert.*;


public class LoginTest {

    @Test
    public void loginWithCorrectInputTest(){
        assertTrue(User.userLogin(new User("Brigitalabas", "._5K%e")));
    }
    @Test
    public void loginWithUserNameEmptyFieldInputTest(){
        assertFalse(User.userLogin(new User("", "._5K%e")));
    }
    @Test
    public void loginWithIncorrectUserNameTest(){
        assertFalse(User.userLogin(new User("BrigitaNeBrigita", "._5K%e")));
    }
@BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.com.driver","drivers\\chromedriver111.exe");
        User.driver = new ChromeDriver();
        User.driver.manage().window().maximize();
        User.driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        User.driver.get("https://elenta.lt/prisijungti");
        User.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();
    }

    @AfterClass
    public void afterClass(){
//        driver.quit();
    }
}
