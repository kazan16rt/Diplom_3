package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Profile extends BasePage {
    public Profile(WebDriver driver) {
        this.driver = driver;
    }
    private By exitProfileButton = By.xpath(".//button[text()='Выход']");
    private String disabledInputValue = ".//input[@value='%s']";
    private By modalOverlay = By.className("Modal_modal__loading__3534A");
    private By loginPageHeader = By.xpath(".//h2[text()='Вход']");

    public Login clickExitProfileButton() {
//
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(modalOverlay)));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(modalOverlay)));
        driver.findElement(exitProfileButton).click();
        return new Login(driver);
    }
    public Profile waitProfilePage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(exitProfileButton));
        return this;
    }
    public String getProfileInputValue(String value) {
        By element = By.xpath(String.format(disabledInputValue, value));
        String result = driver.findElement(element).getAttribute("value");
        return result;
    }
}
