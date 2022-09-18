package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends BasePage {
    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    public Login(WebDriver driver) {
        this.driver = driver;
    }
    private By emailField = By.xpath(".//input[@type='text']");
    private By passwordField = By.xpath(".//input[@type='password']");
    private By enterButton = By.className("button_button__33qZ0");
    private By registerButton = By.xpath(".//a[@href='/register']");
    private By recoveryPasswordButton = By.xpath(".//a[@href='/forgot-password']");
    private By loginPageHeader = By.xpath(".//h2[text()='Вход']");
    private By modalLoader = By.className("Modal_modal__loading__3534A");

    public Login open() {
        driver.get(LOGIN_URL);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(modalLoader)));
        return this;
    }
    public Login setEmailField (String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public Login setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public HomePage clickEnterButton() {
        driver.findElement(enterButton).click();
        return new HomePage(driver);
    }
    public Register clickRegisterButton() {
        driver.findElement(registerButton).click();
        return new Register(driver);
    }
    public RecoverPassword clickRecoveryPasswordButton() {
        driver.findElement(recoveryPasswordButton).click();
        return new RecoverPassword(driver);
    }
    public String getLoginPageHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginPageHeader));
        String header = driver.findElement(loginPageHeader).getText();
        return header;
    }
}
