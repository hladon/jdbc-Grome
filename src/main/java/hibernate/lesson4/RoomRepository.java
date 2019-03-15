package hibernate.lesson4;




import hibernate.lesson4.model.Room;
import org.hibernate.Session;

public class RoomRepository extends Repository {
    public Room findById(long id){
        Session session=null;
        try {
            session = createSessionFactory().openSession();
            Room room=session.get(Room.class,id);
            return room;
        }catch(Exception e){
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        }finally {
            if (session!=null)
                session.close();
        }
        return null;
    }
}
