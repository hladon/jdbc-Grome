package lesson36;

import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.Hotel;
import lesson36.model.Room;


import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class HotelRepository extends Repository {
    private static String repositoryLocation = "src\\lesson36\\repository\\HotelDb";



    public static void saveHotel(List<Hotel> hotelList ) throws IOException {

        save(hotelList,repositoryLocation);
    }

//    public static Hotel findHotel(long id) throws Exception{
//        return convertToHotel(findById(id,repositoryLocation));
//
//    }

    private static Hotel convertToHotel(String line) throws Exception{
        if (line==null)
            return null;
        String[] values = line.split(",");
        if (values.length!=7)
            throw new RepositoryDamaged("Repository " + repositoryLocation + " are damaged") ;
        return new Hotel(Long.valueOf(values[0]), values[1], values[2], values[3], values[4]);
    }



}