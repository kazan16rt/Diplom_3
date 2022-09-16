package unit;

import com.github.javafaker.Faker;

public class UserData {
    public static User getDefault() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String name = faker.name().firstName();
        String password = faker.internet().password();
        return new User(email, password, name);
    }
}
