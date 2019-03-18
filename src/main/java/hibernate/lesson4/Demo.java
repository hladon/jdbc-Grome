package hibernate.lesson4;


import hibernate.lesson4.model.Filter;
import hibernate.lesson4.model.Hotel;
import hibernate.lesson4.model.Room;
import hibernate.lesson4.model.User;

import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        UserController.login("Vlad", "trew");

        System.out.println(HotelController.findHotelByName("Hilton").toString());
        System.out.println(HotelController.findHotelByName("Avenue").toString());
        System.out.println(HotelController.findHotelByName("Relax").toString());

        System.out.println(HotelController.findHotelByCity("Kiev").toString());
        System.out.println(HotelController.findHotelByCity("rome").toString());
        System.out.println(HotelController.findHotelByCity("lvov").toString());

        Filter filter = new Filter("Ukraine", "Kiev", null, 1, true, false, new Date());
        System.out.println(RoomController.findRooms(filter).toString());

        User user = new User();
        System.out.println(UserController.registerUser(user));

        RoomController.bookRoom(1, 1);

        RoomController.cancelReservation(1, 1);

        Hotel hotel = new Hotel();

        Room room = new Room();


    }
}
