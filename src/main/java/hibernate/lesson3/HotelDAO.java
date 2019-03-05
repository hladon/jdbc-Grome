package hibernate.lesson3;

public class HotelDAO extends DAO<Hotel> {

    public Hotel findById(long id){
       return findByIdObject(id,"Hotel");
    }
}
