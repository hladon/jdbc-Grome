package hibernate.lesson4;

import hibernate.lesson4.model.Hotel;

import java.util.List;


public class HotelController {
    public static List<Hotel> findHotelByName(String name) throws Exception {
        if (Session.getLogedUser() == null)
            throw new Exception("User not logged!");
        return HotelService.findHotelByName(name);
    }

    public static List<Hotel> findHotelByCity(String city) throws Exception {
        if (Session.getLogedUser() == null)
            throw new Exception("User not logged!");
        return HotelService.findHotelByCity(city);
    }

}
