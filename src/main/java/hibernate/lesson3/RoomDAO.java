package hibernate.lesson3;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

public class RoomDAO extends DAO<Room> {
    public Room findById(long id){
        Session session=null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("SELECT * FROM Room WHERE ID=:id");
            query.addEntity(Room.class);
            query.setParameter("id",id);
            List<Room> list=query.list();
            if(list.isEmpty())
                return null;
            return (Room) list.get(0);
        }catch(Exception e){
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        }finally {
            if (session!=null)
                session.close();
        }
        return null;
    }
}
