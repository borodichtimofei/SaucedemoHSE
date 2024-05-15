package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{


    By checkOutButton = By.xpath("//a[text() = 'CHECKOUT']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutInformationPage clickCheckOut() {
        driver.findElement(checkOutButton).click();
        return new CheckoutInformationPage(driver);
    }
}
