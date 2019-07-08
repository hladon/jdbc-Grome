package hibernate.lesson4;


import hibernate.lesson4.model.Filter;
import hibernate.lesson4.model.Hotel;
import hibernate.lesson4.model.Order;
import hibernate.lesson4.model.Room;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class RoomService {

    private static HotelRepository hotelRepository = new HotelRepository();


    public static List<Room> findRooms(Filter filter) throws Exception {
        Session session = null;
        try {
            session = hotelRepository.createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery(createQuery(filter));
            query.addEntity(Hotel.class);
            List<Hotel> list = query.list();
            List<Room> roomList = new LinkedList<>();
            for (Hotel hotel : list) {
                for (Room room : hotel.getRooms()) {
                    if (checkRoom(room, filter))
                        roomList.add(room);
                }
            }
            return roomList;
        } catch (Exception e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
            throw e;
        } finally {
            if (session != null)
                session.close();
        }


    }

    private static boolean checkRoom(Room room, Filter filter) {
        if (filter.getDateAvailableFrom() != null && filter.getDateAvailableFrom().compareTo(room.getDateAvailableFrom()) > 0)
            return false;
        if (filter.isPetsAllowed() != room.getPetsAllowed())
            return false;
        if (filter.isBreakfastIncluded() != room.getBreakfastIncluded())
            return false;
        if (filter.getNumberOfGuests() > room.getNumberOfGuests())
            return false;
        return true;
    }

    private static String createQuery(Filter filter) {
        String query = "SELECT * FROM HOTELS WHERE ID>0 ";
        if (filter.getCountry() != null)
            query += " AND COUNTRY=\'" + filter.getCountry() + "\'";
        if (filter.getCity() != null)
            query += " AND CITY=\'" + filter.getCity() + "\'";
        if (filter.getHotel() != null)
            query += " AND NAME=\'" + filter.getHotel() + "\'";

        return query;
    }


}
