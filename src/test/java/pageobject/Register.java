package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Register extends BasePage{
    public static final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";
    public Register(WebDriver driver) {
        this.driver = driver;
    }
    private By loginButton = By.xpath(".//a[@href='/login']");

    private By nameField = By.className("input__textfield");
    private By emailField = By.className("input__textfield");
    private By passwordField = By.xpath(".//input[@type='password']");
    private By enterRegisterButton = By.className("button_button__33qZ0");
    private By registerError = By.className("input__error");
    private By modalLoader = By.className("Modal_modal__loading__3534A");

    public Register open() {
        driver.get(REGISTER_URL);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(modalLoader)));
        return this;
    }
    public Login clickLoginButton() {
        driver.findElement(loginButton).click();
        return new Login(driver);
    }
    public Register setNameField(String name) {
        driver.findElements(nameField).get(0).sendKeys(name);
        return this;
    }
    public Register setEmailField(String email) {
        driver.findElements(emailField).get(1).sendKeys(email);
        return this;
    }
    public Register setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public Login clickEnterRegisterButton() {
        driver.findElement(enterRegisterButton).click();
        return new Login(driver);
    }
    public String getRegisterError() {
        String text = driver.findElement(registerError).getText();
        return text;
    }
}
