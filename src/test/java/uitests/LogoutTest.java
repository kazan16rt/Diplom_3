package uitests;

import io.restassured.response.ValidatableResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.Header;
import pageobject.Login;
import unit.User;
import unit.UserClient;
import unit.UserData;

import static org.junit.Assert.assertEquals;

public class LogoutTest extends BaseTest {
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
    private final String expectedText = "Вход";

    @Test
    public void logoutTest() {
        new Login(driver)
                .open()
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickEnterButton()
                .waitHomePage();
        String loginPage =  new Header(driver)
                .clickProfileButton()
                .waitProfilePage()
                .clickExitProfileButton()
                .getLoginPageHeader();

        assertEquals("Login page is not displayed", expectedText, loginPage);
    }
}
