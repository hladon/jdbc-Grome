package hibernate.lesson4;


import lesson36.Exceptions.WrongPassword;
import lesson36.model.User;
import java.util.List;


public class UserService  {
    private static UserRepository repository=new UserRepository();

    public static User registerUser(User user) throws Exception {
        List<User> list =repository.getList();
        list.add(user);
        UserRepository.saveUser(list);
        return user;
    }

    public static User login(String userName, String password) throws Exception {
        List<User> list = repository.getList();

        for (User line : list) {
            if (line.getUserName().equals(userName) && line.getPassword().equals(password))
                return line;
        }
        throw new WrongPassword();
    }


}
