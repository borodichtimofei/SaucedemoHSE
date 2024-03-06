package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;
    By checkOutButton = By.xpath("//a[text() = 'CHECKOUT']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutInformationPage clickCheckOut() {
        driver.findElement(checkOutButton).click();
        return new CheckoutInformationPage(driver);
    }
}
