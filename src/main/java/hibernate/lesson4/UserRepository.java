package hibernate.lesson4;


import hibernate.lesson4.model.User;


public class UserRepository extends Repository<User> {
    public UserRepository() {
        this.type = User.class;
    }
}
