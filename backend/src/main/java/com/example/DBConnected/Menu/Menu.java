package com.example.DBConnected.Menu;

import jakarta.persistence.*;

@Entity
@Table(name="menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int weight;
    //zatím akruálně nemám tušení jak tohle přesně mám udělat a jak se to domyslí
    //private boolean availability;
    //pak zde bude URL na obrázek bo tak něco

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
