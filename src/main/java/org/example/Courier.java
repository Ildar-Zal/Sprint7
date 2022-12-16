package org.example;

public class Card {
    private  String firstName;
    // ключ name стал полем типа String
    private String login;
    // ключ link стал полем типа String
    private String password;

// это ещё не весь код: тут будет продолжение
public Card(String login, String password,String firstName) {
    this.login = login;
    this.password = password;
    this.firstName= firstName;
}
    public Card(String login,String firstName) {
        this.login = login;
        this.firstName= firstName;
    }
    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Card() {
    }
}
