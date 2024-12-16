package pages;

import com.google.common.collect.Comparators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductsPage {

    WebDriver driver;
    By title = By.xpath("//div[@class = 'product_label']");
    String addToCartButton = "//div[text()='%s']/ancestor::div[@class = 'inventory_item']//button";
    By cartButton = By.id("shopping_cart_container");
    By sortMenu = By.xpath("//select[@class = 'product_sort_container']");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductsPage isPageOpened() {
        driver.findElement(title).isDisplayed();
        return this;
    }

    @Step("Нажимаем кнопку доавить в корзину товар {product}")
    public ProductsPage addToCart(String product) {
        driver.findElement(By.xpath(String.format(addToCartButton, product))).click();
        return this;
    }

    @Step("Нажимаем кнопку корзина")
    public CartPage clickCart() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public boolean isSorted() {
        List<String> names = new ArrayList<>();
        return Comparators.isInOrder(names, Comparator.reverseOrder());
    }

    public ProductsPage selectSort(String sort) {
        Actions actions = new Actions(driver);
        Select select = new Select(driver.findElement(sortMenu));
        select.selectByVisibleText(sort);
        return this;
    }

    public boolean sort() {
        List<String> names = new ArrayList<>();
        return Comparators.isInOrder(names, Comparator.naturalOrder());
    }
}
