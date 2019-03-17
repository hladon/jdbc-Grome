package hibernate.lesson4;


import hibernate.lesson4.model.Order;

import java.util.Date;
import java.util.List;

public class OrderService {

    private static OrderRepository orderRepository=new OrderRepository();
    private static RoomRepository roomRepository=new RoomRepository();
    private static UserRepository userRepository=new UserRepository();

    public static void bookRoom(long roomId, long userId) throws Exception {
        Order order=new Order();
        order.setUserOrder(userRepository.findById(userId));
        order.setRoom(roomRepository.findById(roomId));
        Date reservation=new Date();
        order.setDateFrom(reservation);
        order.setUserOrder(userRepository.findById(userId));
        order.setDateTo(new Date(reservation.getTime()+604800000));
        orderRepository.save(order);
//        TODO
    }



    public static void cancelReservation(long roomId, long userId) throws Exception {
        List<Order> list= orderRepository.findByQuery("SELECT*FROM ORDERS WHERE ROOM_ID="+roomId+" AND USER_ID="+userId);
        for (Order order: list){
            orderRepository.delete(order);
        }
    }
}
