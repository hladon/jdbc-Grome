package hibernate.lesson4.model;



import javax.persistence.*;

import java.util.Date;
@Entity
@Table(name = "ORDERS")
public class Order  {
    @Id
    @SequenceGenerator(name="O_SEQ",sequenceName = "ORDER_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "O_SEQ")
    @Column(name = "ID",unique = true,nullable = false)
    private long id;
    @Column(name = "USER_ID")
    private User userOrder;
    @Column(name = "ROOM_ID")
    private Room room;
    @Column(name = "DATE_FROM")
    private Date dateFrom;
    @Column(name = "DATE_TO")
    private Date dateTo;
    @Column(name = "MONEY_PAID")
    private double moneyPaid;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserOrder(User user) {
        this.userOrder = user;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public User getUserOrder() {
        return userOrder;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    @Override
    public String toString() {
        return id + "," + userOrder.getId() + "," + room.getId() + "," + dateFrom.getTime() + "," + dateTo.getTime() + "," + moneyPaid;

    }
}
