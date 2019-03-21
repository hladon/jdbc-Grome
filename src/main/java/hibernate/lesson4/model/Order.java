package hibernate.lesson4.model;



import javax.persistence.*;

import java.util.Date;
@Entity
@Table(name = "ORDERS")
public class Order  {

    private long id;

    private User userOrder;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    @Id
    @SequenceGenerator(name="O_SEQ",sequenceName = "O_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "O_SEQ")
    @Column(name = "ID",unique = true,nullable = false)
    public long getId() {
        return id;
    }
    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    public User getUserOrder() {
        return userOrder;
    }
    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(name ="ROOM_ID" )
    public Room getRoom() {
        return room;
    }
    @Column(name = "DATE_FROM")
    public Date getDateFrom() {
        return dateFrom;
    }
    @Column(name = "DATE_TO")
    public Date getDateTo() {
        return dateTo;
    }
    @Column(name = "MONEY_PAID")
    public double getMoneyPaid() {
        return moneyPaid;
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
    @Override
    public String toString() {
        return id + "," + userOrder.getId() + "," + room.getId() + "," + dateFrom.getTime() + "," + dateTo.getTime() + "," + moneyPaid;

    }
}
