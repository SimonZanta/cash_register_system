package com.example.DBConnected.Order;

import com.example.DBConnected.Desk.Desk;
import jakarta.persistence.*;

@Entity
@Table(name = "orderTable")
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "desk_id")
    private Desk desk;
    private String name;

    protected OrderTable(){}

    public OrderTable(Desk desk, String name) {
        this.desk = desk;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Desk getDesk() {
        return desk;
    }

    public String getName() {
        return name;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public void setName(String name) {
        this.name = name;
    }
}
