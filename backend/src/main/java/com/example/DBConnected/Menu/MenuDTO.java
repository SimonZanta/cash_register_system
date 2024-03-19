package com.example.DBConnected.Menu;

public class MenuDTO {
    private long id;

    private String name;

    private int weight;

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
