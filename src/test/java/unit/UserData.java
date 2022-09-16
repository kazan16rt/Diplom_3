package unit;

public class UserData {
    public static User getDefault() {
        return new User("potato@yandex.ru", "123456", "John");
    }
    public static User getChangedUser() {
        return new User("tomato@yandex.ru", "54321", "Gray");
    }
}
