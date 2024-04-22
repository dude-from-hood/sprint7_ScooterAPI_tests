package courier;

// Класс Credentials представляет собой модель данных для хранения логина и пароля.
public class Credentials {
    private String login;
    private String password;

    public Credentials() {
    }

    public Credentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // from(Courier) - это статический метод класса Credentials.
    // Он принимает объект Courier в качестве аргумента и возвращает новый объект Credentials,
    // содержащий логин и пароль, извлеченные из переданного курьера.
    public static Credentials from(Courier courier) {
        return new Credentials(courier.getLogin(), courier.getPassword());
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

