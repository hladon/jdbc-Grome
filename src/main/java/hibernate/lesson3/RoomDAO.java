package hibernate.lesson3;

public class RoomDAO extends DAO<Room> {
    public Room findById(long id){
        return findByIdObject(id,"Room");
    }
}
