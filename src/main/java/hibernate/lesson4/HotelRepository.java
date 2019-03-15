package hibernate.lesson4;

import hibernate.lesson3.Hotel;
import org.hibernate.Session;

public class HotelRepository extends Repository {
    public Hotel findById(long id){
        Session session=null;
        try {
            session = createSessionFactory().openSession();
            Hotel hotel=session.get(Hotel.class,id);
            return hotel;
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