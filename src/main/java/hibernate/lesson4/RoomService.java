package hibernate.lesson4;




import hibernate.lesson4.model.Filter;
import hibernate.lesson4.model.Order;
import hibernate.lesson4.model.Room;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;


import java.util.List;


public class RoomService  {

    private static RoomRepository repository = new RoomRepository();


    public static void bookRoom(long roomId, long userId) throws Exception {
        Room room = repository.findById(roomId);
        if (room == null)
            throw new Exception("Room"+roomId+"don`t exist!");
        Order order= OrderService.createOrder(roomId,userId);
        room.setDateAvailableFrom(order.getDateTo());
        Session session=null;
        Transaction transaction=null;
        try {
            SessionFactory sf=new Configuration().configure().buildSessionFactory();
            session= sf.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            session.save(order);
            session.update(room);
            transaction.commit();
        }catch (Exception e){
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (transaction != null)
                transaction.rollback();
            throw e;
        } finally {
            if (session != null)
                session.close();
                }

    }


    public static void cancelReservation(long roomId, long userId) throws Exception {
        Room room = repository.findById(roomId);
        if (room == null)
            throw new Exception("Room"+roomId+"don`t exist!");
        Order order=OrderService.findOrders(roomId,userId);
        room.setDateAvailableFrom(order.getDateFrom());
        Session session=null;
        Transaction transaction=null;
        try {
            SessionFactory sf=new Configuration().configure().buildSessionFactory();
            session= sf.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            session.delete(order);
            session.update(room);
            transaction.commit();
        }catch (Exception e){
            System.err.println("Cancel booking is failed");
            System.err.println(e.getMessage());
            if (transaction != null)
                transaction.rollback();
            throw e;
        } finally {
            if (session != null)
                session.close();
                    }
    }


    public static List<Room> findRooms(Filter filter) throws Exception {
        return repository.findByQuery(createQuery(filter));

    }
    private static String createQuery(Filter filter){
        String query="SELECT * FROM ROOMS WHERE ";
        if (filter.isPetsAllowed()){
            query+=" PETS_ALLOWED=1";
        }else {
            query+=" PETS_ALLOWED=0";
        }
        if (filter.getCountry()!=null)
            query+=" AND COUNTRY="+filter.getCountry();
        if (filter.getCity()!=null)
            query+=" AND CITY="+filter.getCity();
        if (filter.getHotel()!=null)
            query+=" AND HOTEL="+filter.getHotel();
        if (filter.getDateAvailableFrom()!=null){
            query+=" AND DATE_AVAILABLE_FROM <"+filter.getDateAvailableFrom();
        }
        if (filter.isBreakfastIncluded()){
            query+=" AND BREAKFAST=1";
        }else {
            query+=" AND BREAKFAST=0";
        }
        query+=" AND GUESTS_NUMBER>="+filter.getNumberOfGuests();
        return query;
    }




}
