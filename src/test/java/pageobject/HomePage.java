package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public static final String HOME_URL = "https://stellarburgers.nomoreparties.site/";
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private By bunTab = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']/parent::div");
    private By sauceTab = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']/parent::div");
    private By fillingTab = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']/parent::div");
    private By loginInAccountButton = By.className("button_button__33qZ0");
    private By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private By headerHomePage = By.xpath(".//h1[text()='Соберите бургер']");
    private By modalLoader = By.className("Modal_modal__loading__3534A");

    public HomePage open() {
        driver.get(HOME_URL);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(modalLoader)));
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
    public String getClassNameBunTub() throws InterruptedException {
        Thread.sleep(1000);
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
    public String getTextCreateOrderButton() {
        String text = driver.findElement(createOrderButton).getText();
        return text;
    }
    public HomePage waitHomePage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(headerHomePage));
        return this;
    }
}
