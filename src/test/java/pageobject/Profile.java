package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Profile extends BasePage {
    public Profile(WebDriver driver) {
        this.driver = driver;
    }

    private By exitProfileButton = By.xpath(".//button[@type='button' and text()='Выход']");

    public Login clickExitProfileButton() {
        driver.findElement(exitProfileButton).click();
        return new Login(driver);
    }

}
