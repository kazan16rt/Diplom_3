package uitests;

import io.restassured.response.ValidatableResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.Header;
import pageobject.HomePage;
import pageobject.Login;
import unit.User;
import unit.UserClient;
import unit.UserData;

import static org.junit.Assert.assertEquals;

public class HeaderNavigationTest extends BaseTest {

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

    @Test
    public void goToProfile() {
        new HomePage(driver)
                .open()
                .clickLoginInAccountButton()
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickEnterButton()
                .waitHomePage();

        String profileName = new Header(driver)
                .clickProfileButton()
                .waitProfilePage()
                .getProfileInputValue(user.getName());

        assertEquals("User name in profile not found", user.getName(), profileName);
    }
    @Test
    public void goToConstructorButton() {
        new Login(driver)
                .open();
        new Header(driver)
                .clickConstructorButton()
                .waitHomePage();
    }
    @Test
    public void goToLogoButton() {
        new Login(driver)
                .open();
        new Header(driver)
                .clickLogoInHeader()
                .waitHomePage();
    }
}
