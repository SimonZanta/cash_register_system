package com.example.DBConnected.Reservation;

import java.time.LocalDateTime;

public class ReservationDTO {
    private int deskId;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public int getDeskId() {
        return deskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
