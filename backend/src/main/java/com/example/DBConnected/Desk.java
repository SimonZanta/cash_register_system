package com.example.DBConnected;

import jakarta.persistence.*;

@Entity
@Table(name = "Desks")
public class Desk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long desk_id;
    private String name;
    protected Desk(){}
    public Desk(String name){
        this.name = name;
    }

    public long getId() {
        return desk_id;
    }

    public String getName() {
        return name;
    }
}
