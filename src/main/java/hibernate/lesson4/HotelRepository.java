package hibernate.lesson4;


import hibernate.lesson4.model.Hotel;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

public class HotelRepository extends Repository<Hotel> {
    public Hotel findById(long id) throws Exception{
        Session session=null;
        try {
            session = createSessionFactory().openSession();
            Hotel hotel=session.get(Hotel.class,id);
            return hotel;
        }catch(Exception e){
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
            throw e;
        }finally {
            if (session!=null)
                session.close();
        }

    }

    public List<Hotel> findByQuery(String searchQuery) throws Exception {
        Session session = null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery(searchQuery);
            query.addEntity(Hotel.class);
            List<Hotel> list = query.list();
            return list;
        } catch (Exception e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
            throw e;
        } finally {
            if (session != null)
                session.close();
        }

    }

}