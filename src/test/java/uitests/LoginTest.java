package uitests;

import io.restassured.response.ValidatableResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.*;
import unit.User;
import unit.UserClient;
import unit.UserData;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @BeforeClass
    public static void beforeClass() {
        user = UserData.getDefault();
        userClient = new UserClient();
        ValidatableResponse register = userClient.register(user);
        token = register.extract().path("accessToken");
    }
    @AfterClass
    public static void afterClass() {
        if(token != null) {
            userClient.delete(token);
        }
    }
    private static User user;
    private static UserClient userClient;
    private static String token;
    private final String expectedText = "Оформить заказ";

    @Test
    public void loginFromHomePage() {
        String textOrderButton = new HomePage(driver)
                .open()
                .clickLoginInAccountButton()
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickEnterButton()
                .waitHomePage()
                .getTextCreateOrderButton();

        assertEquals("Order button don't displayed", expectedText, textOrderButton);
    }

    @Test
    public void loginThroughProfileButton() {
        new HomePage(driver)
                .open();
        new Header(driver)
                .clickProfileButton();
        String textOrderButton = new Login(driver)
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickEnterButton()
                .waitHomePage()
                .getTextCreateOrderButton();

        assertEquals("Order button don't displayed", expectedText, textOrderButton);
    }

    @Test
    public void loginFromRegisterPage() {
        String textOrderButton = new Register(driver)
                .open()
                .clickLoginButton()
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickEnterButton()
                .waitHomePage()
                .getTextCreateOrderButton();

        assertEquals("Order button don't displayed", expectedText, textOrderButton);
    }

    @Test
    public void loginFromRecoveryPage() {
        String textOrderButton = new RecoverPassword(driver)
                .open()
                .clickLoginButton()
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickEnterButton()
                .waitHomePage()
                .getTextCreateOrderButton();

        assertEquals("Order button don't displayed", expectedText, textOrderButton);
    }
}
