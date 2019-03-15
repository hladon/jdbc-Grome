package hibernate.lesson4.Exceptions;

public class WrongPassword extends Exception {
    public WrongPassword() {
        super("Wrong password or user Name!");
    }
}
