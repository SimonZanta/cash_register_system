package com.example.DBConnected.Authorization;

import jakarta.persistence.*;

@Entity
@Table(name = "authorizations")
public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    protected Authorization(){}

    public Authorization(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
