package hibernate.lesson3;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "ROOM")
public class Room {
    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    @Column(name = "ID")
    public long getId() {
        return id;
    }
    @Column(name = "NUMBER_OF_GUEST")
    public int getNumberOfGuests() {
        return numberOfGuests;
    }
    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }
    @Column(name = "BREAKFAST_INCLUDED")
    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }
    @Column(name = "PETS_ALLOWED")
    public boolean isPetsAllowed() {
        return petsAllowed;
    }
    @Column(name = "DATE_AVAILABLE_FROM")
    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }
    @OneToOne(fetch = FetchType.LAZY )
    @MapsId
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