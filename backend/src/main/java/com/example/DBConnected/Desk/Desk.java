package com.example.DBConnected.Desk;

import jakarta.persistence.*;

import java.net.InterfaceAddress;

@Entity
@Table(name = "Desks")
public class Desk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    protected Desk(){}
    public Desk(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
