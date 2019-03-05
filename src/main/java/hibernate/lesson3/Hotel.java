package hibernate.lesson3;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "HOTEL")
public class Hotel {
    private long id;
    private String name;
    private String country;
    private String city;
    private String street;


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
    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
