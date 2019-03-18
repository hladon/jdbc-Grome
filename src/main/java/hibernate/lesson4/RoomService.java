package hibernate.lesson4;




import hibernate.lesson4.model.Order;
import hibernate.lesson4.model.Room;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
        } finally {
            if (session != null)
                session.close();
                }

    }


    public static void cancelReservation(long roomId, long userId) throws Exception {
        Room room = repository.findById(roomId);
        if (room == null)
            return;
        room.setDateAvailableFrom(new Date());
        repository.delete(roomId);
        repository.save(room);
        OrderService.deleteOrder(roomId, userId);
    }


    public static Set<Room> findRooms(Filter filter) throws Exception {
        List<Room> list = repository.getList();
        Set<Hotel> hotels = HotelService.findHotelByCity(filter.getCity());
        hotels.addAll(HotelService.findHotelByName(filter.getHotel()));
        hotels.addAll(HotelService.findHotelByCountry(filter.getCountry()));
        Set<Room> rooms = new HashSet<>();
        for (Room room : list) {
            if (room.getDateAvailableFrom().before(filter.getDateAvaibleFrom()) &&
                    room.isBreakfastIncluded() == filter.isBreakfastIncluded() &&
                    room.isPetsAllowed() == filter.isPetsAllowed() &&
                    room.getNumberOfGuests() >= filter.getNumberOfGuests() &&
                    checkHotelForRoom(room, hotels)) {
                rooms.add(room);
            }

        }
        return rooms;
    }




}
