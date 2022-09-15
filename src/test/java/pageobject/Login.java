package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage {
    public Login(WebDriver driver) {
        this.driver = driver;
    }
    private By emailField = By.xpath(".//input[@type='text']");
    private By passwordField = By.xpath(".//input[@type='password']");
    private By enterButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa");

    private By registerButton = By.xpath(".//a[@href='/register']");
    private By recoveryPasswordButton = By.xpath(".//a[@href='/forgot-password']");

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
}
