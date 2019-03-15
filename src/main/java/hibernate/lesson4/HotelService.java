package hibernate.lesson4;

import hibernate.lesson4.model.Hotel;


import java.util.List;

public class HotelService  {


    private static HotelRepository hotelRepository=new HotelRepository();

    public static List<Hotel> findHotelByName(String name) throws Exception {
        String query="SELECT * FROM HOTELS WHERE NAME="+name;
        return hotelRepository.findByQuery(query,"Hotel") ;
    }

    public static List<Hotel> findHotelByCity(String city) throws Exception {
        String query="SELECT * FROM HOTELS WHERE CITY="+city;
        return hotelRepository.findByQuery(query,"Hotel") ;
    }

    public static List<Hotel> findHotelByCountry(String country) throws Exception {
        String query="SELECT * FROM HOTELS WHERE COUNTRY="+country;
        return hotelRepository.findByQuery(query,"Hotel") ;
    }




}
