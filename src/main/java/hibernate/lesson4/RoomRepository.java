package lesson36;

import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.Room;


import java.io.IOException;
import java.util.Date;

import java.util.List;

public class RoomRepository extends Repository {
    private static String repositoryLocation = "src\\lesson36\\repository\\RoomDb";


//    public static void saveRoom(List<Room> roomList ) throws IOException {
//
//        save(roomList,repositoryLocation);
//    }
//
//    public  Room findRoom(long id) throws Exception{
//        return convertToRoom(findById(id,repositoryLocation));
//
//    }
//
//    private static Room convertToRoom(String line) throws Exception{
//        if (line==null)
//            return null;
//        String[] values = line.split(",");
//        if (values.length!=7)
//            throw new RepositoryDamaged("Repository " + repositoryLocation + " are damaged") ;
//        return new Room(Long.valueOf(values[0]),Integer.valueOf(values[1]),Double.valueOf(values[2]),
//                Boolean.valueOf(values[3]), Boolean.valueOf(values[4]), new Date(Long.valueOf(values[5])),
//                HotelRepository.findHotel(Long.valueOf(values[6])));
//    }
}
