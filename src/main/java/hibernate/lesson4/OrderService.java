package lesson36;

import lesson36.model.Order;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class OrderService {
    private static Pattern rightDataStructure = Pattern.compile("\\d+,\\d+,\\d+,\\d+,\\d+,\\d+");


//    public static void createOrder(long roomId, long userId) throws Exception {
//        Date dateCreated = new Date();
//        long id = dateCreated.getTime();
//        long dateTo = id + 604800000;
//        String orderData = id + "," + userId + "," + roomId + "," + id + "," + dateTo + "," + 0;
//        String[] orderFromRepository = Repository.getListFromRepository(repositoryLocation, rightDataStructure);
//        Repository.changeData(id, repositoryLocation, orderFromRepository, orderData);
//    }
//
//
//
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
