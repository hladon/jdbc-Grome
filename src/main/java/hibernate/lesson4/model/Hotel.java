package hibernate.lesson4.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "HOTELS")
public class Hotel extends IdEntity {
    @Id
    @SequenceGenerator(name="H_SEQ",sequenceName = "HOTEL_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "H_SEQ")
    @Column(name = "ID",unique = true,nullable = false)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STREET")
    private String street;
    @Column(name = "ROOMS")
    private List<Room> rooms;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(name, hotel.name) &&
                Objects.equals(country, hotel.country) &&
                Objects.equals(city, hotel.city) &&
                Objects.equals(street, hotel.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, city, street);
    }

    @Override
    public String toString() {
        return id + "," + name + "," + country + "," + city + "," + street;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
