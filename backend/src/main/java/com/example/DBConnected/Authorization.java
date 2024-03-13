package com.example.DBConnected;

import jakarta.persistence.*;

@Entity
@Table(name = "authorizations")
public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorization_id;
    private String name;
    private Authorization(){}

    public Authorization(String name) {
        this.name = name;
    }

    public long getId() {
        return authorization_id;
    }

    public String getName() {
        return name;
    }
}
