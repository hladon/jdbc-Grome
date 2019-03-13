package lesson36;

import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.Order;
import lesson36.model.Room;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class OrderRepository extends Repository {
    private static String repositoryLocation = "src\\lesson36\\repository\\OrderDb";

//    public static List<Order> getList() throws Exception{
//        List<Order> list=new LinkedList();
//        for (String line:getListFromRepository(repositoryLocation) ) {
//            list.add(convertToOrder(line));
//        }
//        return list;
//    }
//
//    public static void saveRoom(List<Order> orderList ) throws IOException {
//
//        save(orderList,repositoryLocation);
//    }
//
//    private static Order convertToOrder(String line) throws Exception{
//        if (line==null)
//            return null;
//        String[] values = line.split(",");
//        if (values.length!=6)
//            throw new RepositoryDamaged("Repository " + repositoryLocation + " are damaged") ;
//        return new Order(Long.valueOf(values[0]),UserRepository.findUser(Long.valueOf(values[1])),
//                RoomRepository.findRoom(Long.valueOf(values[2])),new Date(Long.valueOf(values[3])),
//                new Date(Long.valueOf(values[4])),Double.valueOf(values[5]));
//    }
}
