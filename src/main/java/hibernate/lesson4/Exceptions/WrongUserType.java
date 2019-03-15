package hibernate.lesson4.Exceptions;

public class WrongUserType extends Exception {
    public WrongUserType() {
        super("This action not allowed!");
    }
}
