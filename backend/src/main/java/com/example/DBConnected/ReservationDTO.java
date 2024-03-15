package com.example.DBConnected;

import java.time.LocalDateTime;

public class ReservationDTO {
    private int deskId;
    private String name;

    public int getDeskId() {
        return deskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
