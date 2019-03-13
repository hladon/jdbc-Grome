package hibernate.lesson3;


import org.hibernate.Session;



public class HotelDAO extends DAO<Hotel> {

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
