package hibernate.lesson4;


import hibernate.lesson4.model.Hotel;


public class HotelRepository extends Repository<Hotel> {


    public HotelRepository() {
        this.type = Hotel.class;
    }


}