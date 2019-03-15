package hibernate.lesson4.Exceptions;

public class UserNotLogged extends Exception {
    public UserNotLogged() {
        super("User not logged in! Please login.");
    }
}
