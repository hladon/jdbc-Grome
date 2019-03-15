package hibernate.lesson4;

import hibernate.lesson4.Exceptions.WrongUserType;
import hibernate.lesson4.model.User;

public class UserController  {
    public static User registerUser(User user) throws Exception {
        if ( user.getType().equals(UserType.ADMIN)&&(Session.getLogedUser()==null||Session.getLogedUser().getType().equals(UserType.USER)))
            throw new WrongUserType();
        return UserService.registerUser(user);

    }

    public static void login(String userName, String password) throws Exception {
         UserService.login(userName, password);
    }

    public static void logout() {
        Session.setLogedUser(null);
    }
}
