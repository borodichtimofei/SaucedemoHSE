package pages;

import dto.Account;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends BasePage {


    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.xpath("//input[@type = 'submit']");

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);

    }

    public CheckoutOverviewPage fillingForm(Account account) {
        driver.findElement(firstNameField).sendKeys(account.getFirstName());
        driver.findElement(lastNameField).sendKeys(account.getLastName());
        driver.findElement(postalCodeField).sendKeys(account.getPostalCode());
        driver.findElement(continueButton).click();
        return new CheckoutOverviewPage(driver);
    }
}
