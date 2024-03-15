package com.example.DBConnected;

public class DeskDTO {
    private long desk_id;
    private String name;

    public DeskDTO(String name) {
        this.name = name;
    }

    public long getDesk_id() {
        return desk_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
