package hibernate.lesson4;




import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RoomService  {

    private static RoomRepository repository = new RoomRepository();


    public static void bookRoom(long roomId, long userId) throws Exception {
        Room room = repository.findById(roomId);
        if (room == null)
            return;
        room.setDateAvailableFrom(new Date(room.getDateAvailableFrom().getTime() + 604800000));
        repository.delete(roomId);
        repository.save(room);
        OrderService.createOrder(roomId, userId);
    }


    public static void cancelReservation(long roomId, long userId) throws Exception {
        Room room = repository.findById(roomId);
        if (room == null)
            return;
        room.setDateAvailableFrom(new Date());
        repository.delete(roomId);
        repository.save(room);
        OrderService.deleteOrder(roomId, userId);
    }


    public static Set<Room> findRooms(Filter filter) throws Exception {
        List<Room> list = repository.getList();
        Set<Hotel> hotels = HotelService.findHotelByCity(filter.getCity());
        hotels.addAll(HotelService.findHotelByName(filter.getHotel()));
        hotels.addAll(HotelService.findHotelByCountry(filter.getCountry()));
        Set<Room> rooms = new HashSet<>();
        for (Room room : list) {
            if (room.getDateAvailableFrom().before(filter.getDateAvaibleFrom()) &&
                    room.isBreakfastIncluded() == filter.isBreakfastIncluded() &&
                    room.isPetsAllowed() == filter.isPetsAllowed() &&
                    room.getNumberOfGuests() >= filter.getNumberOfGuests() &&
                    checkHotelForRoom(room, hotels)) {
                rooms.add(room);
            }

        }
        return rooms;
    }




}
