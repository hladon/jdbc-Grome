package hibernate.lesson4;


import hibernate.lesson4.model.Order;

import java.util.Date;

public class OrderService {

    private static OrderRepository orderRepository=new OrderRepository();
    private static RoomRepository roomRepository=new RoomRepository();
    private static UserRepository userRepository=new UserRepository();

    public static void createOrder(long roomId, long userId) throws Exception {
        Order order=new Order();
        order.setRoom(roomRepository.findById(roomId));
        order.setDateFrom(new Date());
        order.setUserOrder(userRepository.findById(userId));
        order.setDateTo();
    }



//    public static void deleteOrder(long roomId, long userId) throws Exception {
//        Set<String> setOfSearch = new LinkedHashSet();
//        String[] orderFromRepository = Repository.getListFromRepository(repositoryLocation, rightDataStructure);
//        setOfSearch = Repository.find(String.valueOf(roomId), 2, orderFromRepository);
//        setOfSearch.addAll(Repository.find(String.valueOf(userId), 1, orderFromRepository));
//        for (String ob : setOfSearch) {
//            String[] gettingId = ob.split(",");
//            Long id = Long.valueOf(gettingId[0]);
//            Repository.changeData(id, repositoryLocation, orderFromRepository, null);
//        }
//    }
}
