package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public static final String HOME_URL = "https://stellarburgers.nomoreparties.site/";
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private By bunTab = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']/parent::div");
    private By sauceTab = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']/parent::div");
    private By fillingTab = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']/parent::div");
    private By loginInAccountButton = By.className("button_button__33qZ0");

    public HomePage open() {
        driver.get(HOME_URL);
        return this;
    }
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
    public String getClassNameBunTub() {
        String element = driver.findElement(bunTab).getAttribute("class");
        return element;
    }
    public String getClassNameSauceTub() {
        String element = driver.findElement(sauceTab).getAttribute("class");
        return element;
    }
    public String getClassNameFillingTub() {
        String element = driver.findElement(fillingTab).getAttribute("class");
        return element;
    }

}
