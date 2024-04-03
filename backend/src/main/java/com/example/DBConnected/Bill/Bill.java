package com.example.DBConnected.Bill;

import com.example.DBConnected.Desk.Desk;
import com.example.DBConnected.Order.OrderTable;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long price;
    @ManyToOne
    @JoinColumn(name = "desk_id")
    private Desk desk;
    private LocalDateTime localDateTime;

    public Bill(){}

    public long getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }
}
