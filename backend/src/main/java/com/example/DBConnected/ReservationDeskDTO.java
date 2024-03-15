package com.example.DBConnected;

import org.hibernate.persister.entity.SingleTableEntityPersister;

import java.time.LocalDateTime;

public class ReservationDeskDTO {
    private Integer id;
    private Integer reservationId;
    private Integer deskId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Integer getId() {
        return id;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getDeskId() {
        return deskId;
    }

    public void setDeskId(Integer deskId) {
        this.deskId = deskId;
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
