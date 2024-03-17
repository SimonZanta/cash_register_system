package com.example.DBConnected.Desk;

public class DeskDTO {
    private Integer desk_id;
    private String name;

    public DeskDTO(String name) {
        this.name = name;
    }

    public Integer getDesk_id() {
        return desk_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
