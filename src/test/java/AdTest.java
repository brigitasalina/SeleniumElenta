import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import  static org.testng.Assert.*;



public class AdTest {
    @Test
    public void createAdInputTest(){
        assertTrue(Ad.createAd(new Ad("","","","","","")));
    }





    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.com.driver","drivers\\chromedriver111.exe");
        Ad.driver = new ChromeDriver();
        Ad.driver.manage().window().maximize();
        Ad.driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Ad.driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=BuitisLaisvalaikis_Baldai&actionId=Siulo&returnurl=%2Fpatalpinti%2Fpasirinkti-kategorija");
        Ad.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
    }

    @AfterClass
    public void afterClass(){
//        driver.quit();
    }
}
