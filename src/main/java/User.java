import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class User {
    public String userName;
    public String email;
    public String password;
    public String password2;
    public static WebDriver driver;

    public User(String name, String email, String password, String repeatPassword) {
        this.userName = name;
        this.email = email;
        this.password = password;
        this.password2 = repeatPassword;
    }

    public static boolean registerUser(User user) {
        boolean output = true;
        driver.get("https://elenta.lt/prisijungti?returnurl=https%3A%2F%2Felenta.lt%2Fregistracija");
        driver.findElement(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[10]/td/p/a")).click();
        WebElement userName = driver.findElement(By.id("UserName"));
        WebElement email = driver.findElement(By.id("Email"));
        WebElement password = driver.findElement(By.id("Password"));
        WebElement password2 = driver.findElement(By.id("Password2"));
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[11]/td[2]/input"));

        userName.sendKeys(user.userName);
        email.sendKeys(user.email);
        password.sendKeys(user.password);
        password2.sendKeys(user.password2);
        submit.click();


        List<WebElement> usernameExist = driver.findElements(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        List<WebElement> validUserName = driver.findElements(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        if (!usernameExist.isEmpty()){
            System.out.println(usernameExist.get(0).getText());
            output = false;
        }
        if (!validUserName.isEmpty()){
            System.out.println(validUserName.get(0).getText());
            output = false;
        }
        return output;

    }







    }



