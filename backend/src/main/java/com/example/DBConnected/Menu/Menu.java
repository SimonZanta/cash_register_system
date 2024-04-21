package com.example.DBConnected.Menu;

import com.example.DBConnected.Photos.Photo;
import jakarta.persistence.*;

@Entity
@Table(name="menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int weight;
    private int price;
    @OneToOne
    private Photo photo;
    protected Menu (){};

    public Menu(long id, String name, int weight, int price, Photo photo) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.photo = photo;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}

