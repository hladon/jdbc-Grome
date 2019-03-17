package hibernate.lesson4.model;


import hibernate.lesson4.UserType;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @SequenceGenerator(name="H_SEQ",sequenceName = "HOTEL_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "H_SEQ")
    @Column(name = "ID",unique = true,nullable = false)
    private long id;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "USER_TYPE")
    private UserType type;
//    TODO
    private List<Order> orders;

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getType() {
        return type;
    }

    @Override
    public String toString() {
        return id + "," + userName + "," + password + "," + country + "," + type.toString();

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
