package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecoverPassword extends BasePage {
    public static final String RECOVER_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    public RecoverPassword(WebDriver driver) {
        this.driver = driver;
    }
    private By loginButton = By.xpath(".//a[@href='/login']");
    private By modalLoader = By.className("Modal_modal__loading__3534A");
    public RecoverPassword open() {
        driver.get(RECOVER_URL);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(modalLoader)));
        return this;
    }
    public Login clickLoginButton() {
        driver.findElement(loginButton).click();
        return new Login(driver);
    }
}
