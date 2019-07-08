package hibernate.lesson4;

import hibernate.lesson4.model.Filter;
import hibernate.lesson4.model.Room;

import java.util.Date;
import java.util.List;

public class RoomController {
    public static List<Room> findRooms(Filter filter) throws Exception {
        if (Session.getLogedUser() == null)
            throw new Exception("User not logged!");
        return RoomService.findRooms(filter);
    }




}
