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
        Filter filter=new Filter(null,"Kiyv","Hilton",2,true,false,null);
        Room room1=new Room();
        room1.setBreakfastIncluded(true);
        room1.setDateAvailableFrom(new Date(19/03/2019));
        room1.setHotel(hotelRepository.findById(1));
        room1.setNumberOfGuests(2);
        room1.setPrice(100);
        room1.setPetsAllowed(false);

        Room room2=new Room();
        room2.setBreakfastIncluded(true);
        room2.setDateAvailableFrom(new Date(19/03/2019));
        room2.setHotel(hotelRepository.findById(1));
        room2.setNumberOfGuests(4);
        room2.setPrice(150);
        room2.setPetsAllowed(false);
//        RoomRepository roomRepository=new RoomRepository();
//        roomRepository.save(room1);
//        roomRepository.save(room2);
//        for (Room room:RoomController.findRooms(filter)){
//            System.out.println(room);
//        }
//    RoomController.bookRoom(1,2,new Date(),new Date(22/03/2019));
//        RoomController.cancelReservation(1,2);
        UserController.logout();
    }
}
