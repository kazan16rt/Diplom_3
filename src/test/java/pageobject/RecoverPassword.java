package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPassword extends BasePage {
    public static final String RECOVER_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    public RecoverPassword(WebDriver driver) {
        this.driver = driver;
    }
    private By loginButton = By.xpath(".//a[@href='/login']");
    public RecoverPassword open() {
        driver.get(RECOVER_URL);
        return this;
    }
    public Login clickLoginButton() {
        driver.findElement(loginButton).click();
        return new Login(driver);
    }
}
