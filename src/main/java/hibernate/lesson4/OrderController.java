package hibernate.lesson4;

import java.util.Date;

public class OrderController {
    public static void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        if (Session.getLogedUser() == null)
            throw new Exception("User not logged!");
        OrderService.bookRoom(roomId, userId, dateFrom,dateTo);
    }

    public static void cancelReservation(long roomId, long userId) throws Exception {
        if (Session.getLogedUser() == null)
            throw new Exception("User not logged!");
        OrderService.cancelReservation(roomId, userId);

    }
}
