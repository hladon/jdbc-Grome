package hibernate.lesson4;


import hibernate.lesson4.model.Hotel;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;


public class HotelRepository extends Repository<Hotel> {


    public HotelRepository() {
        this.type = Hotel.class;
    }

    public List<Hotel> findHotels(String queryString) throws Exception {
        List<Hotel> list;
        try(Session session=createSessionFactory().openSession()) {
            SQLQuery query = session.createSQLQuery(queryString);
            query.addEntity(Hotel.class);
            list = query.list();
            for (Hotel hotel:list){
                hotel.getRooms().size();
            }
        } catch (Exception e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
            throw e;
        }
        return list;
    }
}