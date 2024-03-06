import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.Converter.getPrice;

public class CheckPriceTest extends BaseTest {

    @Test
    public void test() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .isPageOpened()
                .addToCart("Sauce Labs Backpack")
                .selectSort("Price (low to high)")
                .clickCart()
                .clickCheckOut()
                .fillingForm("Евдокия", "Ильина", "123456");
        Assert.assertEquals(getPrice(checkoutOverviewPage.getTotalPrice()),
                getPrice(checkoutOverviewPage.getItemPrice()) + getPrice(checkoutOverviewPage.getTaxPrice()));
    }
}
