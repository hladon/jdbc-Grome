package lesson36;


import lesson36.model.Hotel;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class HotelService extends HotelRepository {


//    public static Set findHotelByName(String name) throws Exception {
//        Set<Hotel> list=new TreeSet<Hotel>();
//        for (Hotel hotel : getList()) {
//            if (hotel.getName().equalsIgnoreCase(name))
//                list.add(hotel);
//        }
//        return list;
//    }
//
//    public static Set findHotelByCity(String city) throws Exception {
//        Set<Hotel> list=new TreeSet<Hotel>();
//        for (Hotel hotel : getList()) {
//            if (hotel.getCity().equalsIgnoreCase(city))
//                list.add(hotel);
//        }
//        return list;
//    }
//
//    public static Set findHotelByCountry(String country) throws Exception {
//        Set<Hotel> list=new TreeSet<Hotel>();
//        for (Hotel hotel : getList()) {
//            if (hotel.getCountry().equalsIgnoreCase(country))
//                list.add(hotel);
//        }
//        return list;
//    }
//
//
//    public static Hotel addHotel(Hotel hotel) throws Exception {
//        if (hotel==null)
//            return null;
//        List<Hotel> list = getList();
//        list.add(hotel);
//        saveHotel(list);
//        return hotel;
//    }
//
//    public static void deleteHotel(long id) throws Exception {
//        List<Hotel> list = getList();
//        for (Hotel hotel:list){
//            if (hotel.getId()==id){
//                list.remove(hotel);
//                saveHotel(list);
//                return;
//            }
//
//    }

//}

}
