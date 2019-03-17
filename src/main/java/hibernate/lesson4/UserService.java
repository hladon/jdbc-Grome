package hibernate.lesson4;



import hibernate.lesson4.model.User;
import org.hibernate.SQLQuery;

import java.util.List;

public class UserService extends Repository<User>  {
    private static UserRepository repository=new UserRepository();

    public static User registerUser(User user) throws Exception {
        String query="SELECT*FROM USERS WHERE USER_NAME="+user.getUserName();
        if (repository.findByQuery(query).isEmpty()){
            repository.save(user);
            return user;
        }
        throw new Exception("Such name exist!");
    }

    public static void login(String userName, String password) throws Exception {
        String query="SELECT*FROM USERS WHERE USER_NAME="+userName+" AND PASSWORD="+password;
        List<User> list=repository.findByQuery(query);
        if (list.isEmpty()){
            throw new Exception("Wrong password or username!");
        }
        Session.setLogedUser(list.get(0));
        System.out.println("You logged in!");
    }




}
