package hibernate.lesson4;


import hibernate.lesson4.model.Filter;
import hibernate.lesson4.model.Hotel;
import hibernate.lesson4.model.Room;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.LinkedList;
import java.util.List;


public class RoomRepository extends Repository<Room> {
    public RoomRepository() {
        this.type = Room.class;
    }

    public static List<Room> findRooms(String queryString) throws Exception {

        try(Session session=createSessionFactory().openSession()) {
            SQLQuery query = session.createSQLQuery(queryString);
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
}
