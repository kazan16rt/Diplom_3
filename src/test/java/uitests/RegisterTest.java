package uitests;

import io.restassured.response.ValidatableResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.Login;
import pageobject.Register;
import unit.User;
import unit.UserClient;
import unit.UserCredentials;
import unit.UserData;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {
    @BeforeClass
    public static void beforeClass() {
        user = UserData.getDefault();
        userClient = new UserClient();
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
    private final String expectedErrorText = "Некорректный пароль";

    @Test
    public void registerSuccessTest() {
        String register = new Login(driver)
                .open()
                .clickRegisterButton()
                .setEmailField(user.getEmail())
                .setNameField(user.getName())
                .setPasswordField(user.getPassword())
                .clickEnterRegisterButton()
                .getLoginPageHeader();
        assertEquals("Displayed wrong page", "Вход", register);

        ValidatableResponse response = userClient.login(UserCredentials.from(user));
        int statusCode = response.extract().statusCode();
        assertEquals("Status code is incorrect", SC_OK, statusCode);

        token = response.extract().path("accessToken");
        Boolean success = response.extract().path("success");
        assertTrue("User is not registered", success);
    }

    @Test
    public void registerWithIncorrectPassword() {
        user.setPassword("12345");
        new Register(driver)
                .open()
                .setEmailField(user.getEmail())
                .setNameField(user.getName())
                .setPasswordField(user.getPassword())
                .clickEnterRegisterButton();
        String error = new Register(driver)
                .getRegisterError();

        assertEquals("Error text is not expected", expectedErrorText, error);
    }
}
