package hibernate.lesson4.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name ="ROOMS" )
public class Room {

    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    @Id
    @SequenceGenerator(name="R_SEQ",sequenceName = "ROOM_SQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "R_SEQ")
    @Column(name = "ID",unique = true,nullable = false)
    public long getId() {
        return id;
    }
    @Column(name = "GUESTS_NUMBER")
    public int getNumberOfGuests() {
        return numberOfGuests;
    }
    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }
    @Column(name = "BREAKFAST")
    public boolean getBreakfastIncluded() {
        return breakfastIncluded;
    }
    @Column(name = "PETS_ALLOWED")
    public boolean getPetsAllowed() {
        return petsAllowed;
    }
    @Column(name = "DATE_AVAILABLE_FROM")
    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }
    @ManyToOne
    @JoinColumn(name="HOTEL", nullable=false)
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
