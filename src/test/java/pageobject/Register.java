package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends BasePage{
    public Register(WebDriver driver) {
        this.driver = driver;
    }
    private By loginButton = By.xpath(".//a[@href='/login']");

    private By nameField = By.xpath(".//label[text()='Имя']");
    private By emailField = By.xpath(".//label[text()='Email']");
    private By passwordField = By.xpath(".//input[@type='password']");

    private By enterRegisterButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa");

    public Login clickLoginButton() {
        driver.findElement(loginButton).click();
        return new Login(driver);
    }
    public Register setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    public Register setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
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
}
