package hibernate.lesson4.model;

import java.util.Date;

public class Filter {
    private String country;
    private String city;
    private String hotel;
    private int numberOfGuests;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public Filter(String country, String city, String hotel, int numberOfGuests, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom) {
        this.hotel = hotel;
        this.country = country;
        this.city = city;
        this.numberOfGuests = numberOfGuests;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public String getHotel() {
        return hotel;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public void setDateAvaibleFrom(Date dateAvaibleFrom) {
        this.dateAvailableFrom = dateAvaibleFrom;
    }
}
