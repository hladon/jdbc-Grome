package hibernate.lesson4;


import hibernate.lesson4.model.User;

public class UserController  {
    public static User registerUser(User user) throws Exception {
        if ( Session.getLogedUser()!=null)
            throw new Exception("You already logged!");
        return UserService.registerUser(user);

    }

    public static void login(String userName, String password) throws Exception {
        if ( Session.getLogedUser()!=null)
            throw new Exception("You already logged!");
         UserService.login(userName, password);
    }

    public static void logout() {
        Session.setLogedUser(null);
    }
}
