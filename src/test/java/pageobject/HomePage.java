package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public static final String HOME_URL = "https://stellarburgers.nomoreparties.site/";
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private By bunTab = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");
    private By sauceTab = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");
    private By fillingTab = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");

    private By loginInAccountButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg");

    public HomePage clickBunTab() {
        driver.findElement(bunTab).click();
        return this;
    }
    public HomePage clickSauceTab() {
        driver.findElement(sauceTab).click();
        return this;
    }
    public HomePage clickFillingTab() {
        driver.findElement(fillingTab).click();
        return this;
    }
    public Login clickLoginInAccountButton() {
        driver.findElement(loginInAccountButton).click();
        return new Login(driver);
    }

}
