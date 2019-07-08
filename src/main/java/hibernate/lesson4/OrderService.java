package hibernate.lesson4;


import hibernate.lesson4.model.Order;
import hibernate.lesson4.model.Room;


import java.util.Date;
import java.util.List;


public class OrderService {

    private static OrderRepository orderRepository = new OrderRepository();
    private static RoomRepository roomRepository = new RoomRepository();
    private static UserRepository userRepository = new UserRepository();

    public static Order createOrder(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        Order order = new Order();
        order.setUserOrder(userRepository.findById(userId));
        order.setRoom(roomRepository.findById(roomId));
        order.setDateFrom(dateFrom);
        order.setUserOrder(userRepository.findById(userId));
        order.setDateTo(dateTo);
        return order;
    }

    public static Order findOrders(long roomId, long userId) throws Exception {

        String query = "SELECT*FROM ORDERS WHERE ROOM_ID=" + roomId + " AND USER_ID=" + userId;
        List<Order> orders = orderRepository.findByQuery(query);
        if (orderRepository.findByQuery(query).isEmpty()) {
            throw new Exception("Such order does not exist!");
        }
        return orders.get(0);

    }

    public static void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        Room room = roomRepository.findById(roomId);
        if (room == null)
            throw new Exception("Room" + roomId + "don`t exist!");
        if (room.getDateAvailableFrom().compareTo(dateFrom) > 0)
            throw new Exception("Room" + roomId + "room is booked!");
        Order order = OrderService.createOrder(roomId, userId, dateFrom, dateTo);
        room.setDateAvailableFrom(order.getDateTo());
        orderRepository.bookRoom(order, room);

    }

    public static void cancelReservation(long roomId, long userId) throws Exception {
        Room room = roomRepository.findById(roomId);
        if (room == null)
            throw new Exception("Room" + roomId + "don`t exist!");
        Order order = OrderService.findOrders(roomId, userId);
        room.setDateAvailableFrom(order.getDateFrom());
        orderRepository.cancelReservation(order, room);
    }
}
