package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        this.driver = driver;
    }
    private By constructorButton = By.xpath(".//header//p[text()='Конструктор']");
    private By profileButton = By.xpath(".//header//p[text()='Личный Кабинет']");
    private By logoInHeader = By.className("AppHeader_header__logo__2D0X2");
    private By modalOverlay = By.className("Modal_modal__loading__3534A");

    public HomePage clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return new HomePage(driver);
    }
    public Profile clickProfileButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(modalOverlay)));
        driver.findElement(profileButton).click();
        return new Profile(driver);
    }
    public Header isProfileButtonClickable() throws InterruptedException {
        Thread.sleep(2000);
        return this;
    }
    public HomePage clickLogoInHeader() {
        driver.findElement(logoInHeader).click();
        return new HomePage(driver);
    }
}
