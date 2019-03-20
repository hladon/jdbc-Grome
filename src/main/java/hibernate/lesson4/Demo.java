package hibernate.lesson4;


import hibernate.lesson4.model.Filter;
import hibernate.lesson4.model.Hotel;
import hibernate.lesson4.model.Room;
import hibernate.lesson4.model.User;

import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        Hotel hotel1 = new Hotel();
        hotel1.setCity("Kiyv");
        hotel1.setCountry("Ukraine");
        hotel1.setName("Hilton");
        hotel1.setStreet("Hreschatyk");
        HotelRepository hotelRepository=new HotelRepository();
//        hotelRepository.save(hotel1);
        User user=new User();
        user.setCountry("Ukraine");
        user.setType(UserType.ADMIN);
        user.setUserName("Vadim");
        user.setPassword("1111");
//        UserController.registerUser(user);
        UserController.login("Vadim","1111");
//        System.out.println(HotelController.findHotelByCity("Kiyv"));
//        System.out.println(HotelController.findHotelByName("Hilton"));



    }
}
