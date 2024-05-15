package tests;

import dto.Account;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class CheckPriceTest extends BaseTest {

    @Description(value = "Проверка правильности суумы налога и стоимости товара")
    @Epic("HSE-01")
    @Story("HSE-01-01")
    @Issue("Bug HSE-01/01")
    @Link("https://docs.google.com/document/d/1n_1tPfcwAUvcZLSKp8Xa2FLgQU0RIyq_Vj7WdfnEPj4/edit")
    @Owner("Серая команда")
    @Flaky()
    @Test
    public void test() {
        Account account = new Account("Евдокия", "Ильина", "123456");
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .isPageOpened()
                .addToCart("Sauce Labs Backpack")
                .selectSort("Price (low to high)")
                .clickCart()
                .clickCheckOut()
                .fillingForm(account);
        ;
    }
}
