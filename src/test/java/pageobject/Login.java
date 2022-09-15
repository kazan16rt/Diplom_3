package pageobject;

import lombok.extern.java.Log;
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
}
