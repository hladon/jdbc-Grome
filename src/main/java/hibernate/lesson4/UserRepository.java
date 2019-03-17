package hibernate.lesson4;


import hibernate.lesson4.model.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;


public class UserRepository extends Repository {
    public User findById(long id){
        Session session=null;
        try {
            session = createSessionFactory().openSession();
            User user=session.get(User.class,id);
            return user;
        }catch(Exception e){
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        }finally {
            if (session!=null)
                session.close();
        }
        return null;
    }

    public List<User> findByQuery(String searchQuery) {
        Session session = null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery(searchQuery);
            query.addEntity(User.class);
            List<User> list = query.list();
            return list;
        } catch (Exception e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }
}
