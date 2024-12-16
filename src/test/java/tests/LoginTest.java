package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @org.testng.annotations.Test(testName = "Проверка входа в систему с неверным паролем")
    public void checkLoginWithNegativePassword() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce1");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @org.testng.annotations.Test(testName = "Проверка входа в систему с верными данными")
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void test() {
        loginPageFactory.open();
        loginPageFactory.login("standard_user", "secret_sauce");
        Assert.assertEquals(loginPageFactory.gerErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }
}
