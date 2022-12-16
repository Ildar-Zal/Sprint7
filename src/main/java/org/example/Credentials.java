package org.example;

public class Credentials {
    // ключ name стал полем типа String
    private String login;
    // ключ link стал полем типа String
    private String password;

    // это ещё не весь код: тут будет продолжение
    public Credentials(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }

public static Credentials from (Courier courier){
        return new Credentials(courier.getLogin(), courier.getPassword());
}

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
