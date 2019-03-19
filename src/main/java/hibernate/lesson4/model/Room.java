package hibernate.lesson4.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name ="ROOMS" )
public class Room {
    @Id
    @SequenceGenerator(name="R_SEQ",sequenceName = "ROOM_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "R_SEQ")
    @Column(name = "ID",unique = true,nullable = false)
    private long id;
    @Column(name = "GUESTS_NUMBER")
    private int numberOfGuests;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "BREAKFAST")
    private boolean breakfastIncluded;
    @Column(name = "PETS_ALLOWED")
    private boolean petsAllowed;
    @Column(name = "DATE_AVAILABLE_FROM")
    private Date dateAvailableFrom;
    @Column(name = "HOTELS")
    private Hotel hotel;

    public long getId() {
        return id;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return id + "," + numberOfGuests + "," + price + "," + breakfastIncluded + "," + petsAllowed + "," + dateAvailableFrom.getTime() + "," + hotel.getId();

    }
}
