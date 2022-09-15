package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPassword extends BasePage {
    public RecoverPassword(WebDriver driver) {
        this.driver = driver;
    }

    private By loginButton = By.xpath(".//a[@href='/login']");

}
