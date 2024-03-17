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
    //pak zde bude URL na obrázek bo tak něco

}
