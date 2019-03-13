package lesson36;



import lesson36.model.Filter;
import lesson36.model.Hotel;
import lesson36.model.Room;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RoomService extends RoomRepository {


//    public static Room addRoom(Room room) throws Exception {
//        if (room==null)
//            return null;
//        List<Room> list = getList();
//        list.add(room);
//        saveRoom(list);
//        return room;
//    }
//
//    public static void deleteRoom(long id) throws Exception {
//        List<Room> list = getList();
//        for (Room room : list) {
//            if (room.getId() == id) {
//                list.remove(room);
//                saveRoom(list);
//                return;
//            }
//
//        }
//    }
//    public static Room findRoomById(long id) throws Exception {
//
//        for (Room room : getList()) {
//            if (room.getId()==id)
//                return room;
//        }
//        return null;
//    }
//
//    public static void roomReservation(long roomId, long userId) throws Exception {
//            List<Room> list = getList();
//            for (Room room: list){
//                if (room.getId()==roomId)
//                    room.setDateAvailableFrom(new Date(room.getDateAvailableFrom().getTime()+ 604800000));
//            }
//            saveRoom(list);
//            OrderService.createOrder(roomId,userId);
//    }
//
//
//    public static void cancelReservation(long roomId, long userId) throws Exception {
//        List<Room> list = getList();
//        for (Room room: list){
//            if (room.getId()==roomId)
//                room.setDateAvailableFrom(new Date());
//        }
//        OrderService.deleteOrder(roomId, userId);
//    }
//
//
//
//    public static Set<Room> findRooms(Filter filter) throws Exception {
//        Set<Hotel> hotels = HotelService.findHotelByCity(filter.getCity());
//        hotels.addAll(HotelService.findHotelByName(filter.getHotel()));
//        hotels.addAll(HotelService.findHotelByCountry(filter.getCountry()));
//        Set<Room> rooms=new HashSet<>();
//        for (Room room:getList()){
//            if (room.getDateAvailableFrom().before(filter.getDateAvaibleFrom())&&
//                    room.isBreakfastIncluded()==filter.isBreakfastIncluded()&&
//                    room.isPetsAllowed()==filter.isPetsAllowed()&&
//                    room.getNumberOfGuests()>=filter.getNumberOfGuests()&&
//                    checkHotelForRoom(room,hotels)                ){
//
//                rooms.add(room);
//            }
//
//        }
//
//
//        return null;
//    }
//
//
//    private static boolean checkHotelForRoom(Room room, Set<Hotel> hotels) {
//        for (Hotel hotel : hotels) {
//            if (room.getHotel().equals(hotel))
//            return true;
//        }
//        return false;
//    }

}
