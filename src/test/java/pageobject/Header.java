package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        this.driver = driver;
    }

    private By constructorButton = By.xpath(".//header//p[text()='Конструктор']");
    private By profileButton = By.xpath(".//header//p[text()='Личный Кабинет']");
    private By logoInHeader = By.className("AppHeader_header__logo__2D0X2");

    public HomePage clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return new HomePage(driver);
    }

    public Profile clickProfileButton() {
        driver.findElement(profileButton).click();
        return new Profile(driver);
    }
    public HomePage clickLogoInHeader() {
        driver.findElement(logoInHeader).click();
        return new HomePage(driver);
    }
}
