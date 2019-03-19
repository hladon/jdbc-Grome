package hibernate.lesson4.model;


import hibernate.lesson4.UserType;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {

    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType type;
    private List<Order> orders;



    @Id
    @SequenceGenerator(name="H_SEQ",sequenceName = "HOTEL_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "H_SEQ")
    @Column(name = "ID",unique = true,nullable = false)
    public long getId() {
        return id;
    }
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }
    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }
    @Column(name = "USER_TYPE")
    public UserType getType() {
        return type;
    }
    @OneToMany(cascade=CascadeType.ALL, mappedBy="user")
    public List<Order> getOrders() {
        return orders;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setType(UserType type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return id + "," + userName + "," + password + "," + country + "," + type.toString();

    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password);
    }

}
