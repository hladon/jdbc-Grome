package hibernate.lesson3;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        RoomDAO roomDAO=new RoomDAO();
        Room room=new Room();
        room.setBreakfastIncluded(true);
        room.setDateAvailableFrom(new Date());
        room.setNumberOfGuests(2);
        room.setPetsAllowed(false);
        room.setPrice(50);
        room.setId(1);
        HotelDAO hotelDAO=new HotelDAO();
        Hotel hotel=new Hotel();
        hotel.setCity("Kiyv");
        hotel.setCountry("Ukraine");
        hotel.setStreet("Hvoiky");
        hotel.setName("Hilton");
        room.setHotel(hotelDAO.findById(21));

//        hotelDAO.save(hotel);
//        roomDAO.save(room);
//        roomDAO.delete(room);

//        hotel.setCountry("China");
//        hotelDAO.update(hotel);
//        hotelDAO.delete(hotel);
//        System.out.println(hotelDAO.findById(21));
//        System.out.println(roomDAO.findById(2));

        roomDAO.save(room);
//        System.out.println(hotelDAO.findById(1));
    }


}
