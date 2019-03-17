package hibernate.lesson4;




import hibernate.lesson4.model.Order;
import hibernate.lesson4.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

public class RoomRepository extends Repository {
    public Room findById(long id){
        Session session=null;
        try {
            session = createSessionFactory().openSession();
            Room room=session.get(Room.class,id);
            return room;
        }catch(Exception e){
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        }finally {
            if (session!=null)
                session.close();
        }
        return null;
    }

    public List<Room> findByQuery(String searchQuery) {
        Session session = null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery(searchQuery);
            query.addEntity(Room.class);
            List<Room> list = query.list();
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
