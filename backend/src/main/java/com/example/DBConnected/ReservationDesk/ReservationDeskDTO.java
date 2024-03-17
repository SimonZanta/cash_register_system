package com.example.DBConnected.ReservationDesk;

import org.hibernate.persister.entity.SingleTableEntityPersister;

import java.time.LocalDateTime;

public class ReservationDeskDTO {
    private Integer id;
    private Integer reservationId;
    private Integer deskId;

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
}
