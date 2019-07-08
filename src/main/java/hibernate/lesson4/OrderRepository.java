package hibernate.lesson4;



import hibernate.lesson4.model.Order;
import hibernate.lesson4.model.Room;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderRepository extends Repository<Order> {
    public OrderRepository() {
        this.type=Order.class;
    }

    public List<Order> findByQuery(String searchQuery) throws Exception{
        try(Session session=createSessionFactory().openSession()){
            SQLQuery query = session.createSQLQuery(searchQuery);
            query.addEntity(Order.class);
            List<Order> list = query.list();
            return list;
        } catch (Exception e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public void bookRoom(Order order, Room room){
        Transaction transaction=null;
        try(Session session=createSessionFactory().openSession()) {
            transaction=session.getTransaction();
            transaction.begin();
            session.save(order);
            session.update(room);
            transaction.commit();
        }catch (Exception e){
            System.err.println("Reservation is failed");
            System.err.println(e.getMessage());
            if (transaction != null)
                transaction.rollback();
            throw e;
        }
    }

    public void cancelReservation(Order order, Room room){
        Transaction transaction=null;
        try(Session session=createSessionFactory().openSession()) {
            transaction=session.getTransaction();
            transaction.begin();
            session.delete(order);
            session.update(room);
            transaction.commit();
        }catch (Exception e){
            System.err.println("Reservation not canceled");
            System.err.println(e.getMessage());
            if (transaction != null)
                transaction.rollback();
            throw e;
        }
    }



}
