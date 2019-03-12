package hibernate.lesson3;

public class Demo {
    public static void main(String[] args) {
        RoomDAO roomDAO=new RoomDAO();
        HotelDAO hotelDAO=new HotelDAO();
        Hotel hotel=new Hotel();
        hotel.setId(1);
        hotel.setCity("Kiyv");
        hotel.setCountry("Ukraine");
        hotel.setStreet("Hvoiky");
        hotel.setName("Hilton");

        hotelDAO.save(hotel);
//        System.out.println(hotelDAO.findById(1));
    }


}
