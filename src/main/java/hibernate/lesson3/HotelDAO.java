package hibernate.lesson3;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

public class HotelDAO extends DAO<Hotel> {

    public Hotel findById(long id){
        Session session=null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("SELECT * FROM Hotel WHERE ID=:id");
            query.addEntity(Hotel.class);
            query.setParameter("id",id);
            List<Hotel> list=query.list();
            if(list.isEmpty())
                return null;
            return (Hotel) list.get(0);
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
