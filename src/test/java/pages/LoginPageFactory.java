package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage{

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "user-name")
    WebElement loginField;
    @FindBy (id = "password")
    WebElement passwordField;
    @FindBy (id = "login-button")
    WebElement loginButton;
    @FindBy (xpath = "//h3[@data-test = 'error']")
    WebElement errorMessage;

    public void open() {
        driver.get("https://www.saucedemo.com/v1/index.html");
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String paswword) {
        loginField.sendKeys(user);
        passwordField.sendKeys(paswword);
        loginButton.click();
    }

    public String gerErrorMessage() {
        return errorMessage.getText();
    }
}
