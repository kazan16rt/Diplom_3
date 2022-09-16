package uitests;

import com.github.javafaker.Faker;
import io.restassured.response.ValidatableResponse;
import org.junit.*;
import pageobject.HomePage;
import pageobject.Login;
import pageobject.Register;
import unit.User;
import unit.UserClient;
import unit.UserCredentials;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {
    @Before
    public void beforeClass() {
        user = new User(email, password, name);
        userClient = new UserClient();
    }
    @After
    public void afterClass() {
        if(token != null) {
            userClient.delete(token);
        }
    }
    private User user;
    private UserClient userClient;
    Faker faker = new Faker();
    private final String email = faker.internet().emailAddress();
    private final String name = faker.name().firstName();
    private final String password = faker.internet().password();
    private String token;

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
        assertTrue("Login failed", success);
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

        assertEquals("Error text is not expected", "Некорректный пароль", error);
    }
}
