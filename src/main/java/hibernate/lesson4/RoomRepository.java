package hibernate.lesson4;


import hibernate.lesson4.model.Room;



public class RoomRepository extends Repository<Room> {
    public RoomRepository() {
        this.type = Room.class;
    }


}
