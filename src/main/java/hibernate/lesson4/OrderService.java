package hibernate.lesson4;


import hibernate.lesson4.model.Order;

import java.util.Date;
import java.util.List;


public class OrderService {

    private static OrderRepository orderRepository=new OrderRepository();
    private static RoomRepository roomRepository=new RoomRepository();
    private static UserRepository userRepository=new UserRepository();

    public static Order createOrder(long roomId, long userId,Date dateFrom,Date dateTo) {
        Order order=new Order();
        order.setUserOrder(userRepository.findById(userId));
        order.setRoom(roomRepository.findById(roomId));
        order.setDateFrom(dateFrom);
        order.setUserOrder(userRepository.findById(userId));
        order.setDateTo(dateTo);
        return order;
    }

    public static Order findOrders(long roomId, long userId) throws Exception{

        String query="SELECT*FROM ORDERS WHERE ROOM_ID="+roomId+" AND USER_ID=" + userId;
        List<Order> orders = orderRepository.findByQuery(query);
        if (orderRepository.findByQuery(query).isEmpty()){
            throw new Exception("Such order does not exist!");
        }
        return orders.get(0);

    }

}
