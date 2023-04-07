
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class Ad{
    public String title;
    public String text;
    public String price;
    public String location;
    public String phone;
    public String email;
    public static WebDriver driver;

    public Ad(String title, String text, String price, String location, String phone, String email) {
        this.title = title;
        this.text = text;
        this.price = price;
        this.location = location;
        this.phone = phone;
        this.email = email;
    }

    public static boolean createAd(Ad ad) {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=BuitisLaisvalaikis_Baldai&actionId=Siulo&returnurl=%2Fpatalpinti%2Fpasirinkti-kategorija");
        driver.findElement(By.id("title")).sendKeys(ad.title);
        driver.findElement(By.id("text")).sendKeys(ad.title);
        driver.findElement(By.id("price")).sendKeys(ad.price);
        driver.findElement(By.id("location")).sendKeys(ad.location);
        driver.findElement(By.id("phone")).sendKeys(ad.phone);
        driver.findElement(By.id("email")).sendKeys(ad.email);
        driver.findElement(By.id("submit-button")).click();
        return true;
//        return adCreationStatus();

    }
//    public static boolean adCreationStatus(){
//
//    }





}
