package hibernate.lesson4;



import hibernate.lesson4.model.Order;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

public class OrderRepository extends Repository {
    public Order findById(long id){
        Session session=null;
        try {
            session = createSessionFactory().openSession();
            Order order=session.get(Order.class,id);
            return order;
        }catch(Exception e){
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        }finally {
            if (session!=null)
                session.close();
        }
        return null;
    }

    public List<Order> findByQuery(String searchQuery) {
        Session session = null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery(searchQuery);
            query.addEntity(Order.class);
            List<Order> list = query.list();
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
