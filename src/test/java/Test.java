import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Test {

    /*
    1. Открыть боаузер
    2. Перейти по url
    3.Ввести логин и пароль, нажать логин
    4.Валидировать сообщение об ошибке
     */
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @org.testng.annotations.Test
    public void test1() {
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce1");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @org.testng.annotations.Test
    public void test2() {
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required");
    }

    @org.testng.annotations.Test
    public void test3() {
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.findElement(By.name("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");
    }

    @org.testng.annotations.Test
    public void test4() {
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'product_label']")).isDisplayed());
    }

    @AfterMethod (alwaysRun = true)
    public void close () {
        driver.quit();
    }
}
