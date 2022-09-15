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
}
