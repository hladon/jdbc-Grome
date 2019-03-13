package lesson36;

import lesson36.model.Filter;
import lesson36.model.Hotel;
import lesson36.model.Room;
import lesson36.model.User;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) throws Exception {
        Controler controler = new Controler();
        controler.login("Vlad", "trew");

//        System.out.println(controler.findHotelByName("Hilton").toString());
//        System.out.println(controler.findHotelByName("Avenue").toString());
//        System.out.println(controler.findHotelByName("Relax").toString());

//        System.out.println(controler.findHotelByCity("Kiev").toString());
//        System.out.println(controler.findHotelByCity("rome").toString());
//        System.out.println(controler.findHotelByCity("lvov").toString());

//        Filter filter=new Filter("Ukraine","Kiev",null,1,true,false,new Date());
//        System.out.println(controler.findRooms(filter).toString());

//        User user=new User(8,"Vasil","rewt","Ukraine",UserType.USER);
//        System.out.println(controler.registerUser(user));

//        controler.bookRoom(2,1);

//        controler.cancelReservation(2,1);

//        Hotel hotel=new Hotel(18,"Stelar","China","Beijing","MaoDezdun");
//        controler.addHotel(hotel);
//        controler.deleteHotel(18);

//        Room room=new Room(13,2,200,true,false,new Date(),hotel);
//        controler.addRoom(room);
//        controler.deleteRoom(13);

    }
}
