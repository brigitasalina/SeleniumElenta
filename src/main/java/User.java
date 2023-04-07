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

    public User(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public static boolean registerUser(User user) {
        boolean output = true;
        driver.get("https://elenta.lt/registracija");
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

        List<WebElement> goods = driver.findElements(By.xpath("/html/body/div[1]/div[2]/h1/b"));
        if (goods.size() > 0 && goods.get(0).getText().equals("Jūs sėkmingai prisiregistravote!")) {
            return true;
        }

        List<WebElement> usernameExistOrNotValid = driver.findElements(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        if (!usernameExistOrNotValid.isEmpty()) {
            System.out.println(usernameExistOrNotValid.get(0).getText());
            output = false;
        }
        List<WebElement> emailExistOrNotValid = driver.findElements(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[4]/td[2]/span"));
        if (emailExistOrNotValid.size() > 0) {
            System.out.println(emailExistOrNotValid.get(0).getText());
            output = false;
        }
        List<WebElement> emptyPasswordExistOrNotValid = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[7]/td[2]/span"));
        if (emptyPasswordExistOrNotValid.size() > 0) {
            System.out.println(emptyPasswordExistOrNotValid.get(0).getText());
            output = false;
        }
        List<WebElement> password2ExistOrNotValid = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[8]/td[2]/span"));
        if (password2ExistOrNotValid.size() > 0) {
            System.out.println(password2ExistOrNotValid.get(0).getText());
            output = false;
        }
        return output;
    }

    public static boolean userLogin(User user) {
        driver.get("https://elenta.lt/prisijungti?returnurl=https%3A%2F%2Felenta.lt%2F");
        driver.findElement(By.id("UserName")).sendKeys(user.userName);
        driver.findElement(By.id("Password")).sendKeys(user.password);
        driver.findElement(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[4]/td[2]/input")).click();
        return checkLoginStatus();

    }

    public static boolean checkLoginStatus() {
        boolean output = true;


        List<WebElement> CorrectInput = driver.findElements(By.xpath("/html/body/div[2]/div[1]/div[2]/div/a[3]"));
        if (CorrectInput.size() > 0 && CorrectInput.get(0).getText().equals("mano skelbimai")) {
            return true;
        }
        List<WebElement> EmptyFieldExistOrNotValid = driver.findElements(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[1]/td[2]/span"));
        if (EmptyFieldExistOrNotValid.size() > 0) {
            System.out.println(EmptyFieldExistOrNotValid.get(0).getText());
            output = false;
        }
        List<WebElement> IncorrectUserNameExistOrNotValid = driver.findElements(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[5]/td/div/ul/li"));
        if (IncorrectUserNameExistOrNotValid.size() > 0) {
            System.out.println(IncorrectUserNameExistOrNotValid.get(0).getText());
            output = false;
        }


            return output;
        }


    }












