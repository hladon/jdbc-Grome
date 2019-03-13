package hibernate.lesson3;

import org.hibernate.Session;



public class RoomDAO extends DAO<Room> {
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
