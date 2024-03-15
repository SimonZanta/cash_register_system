package com.example.DBConnected;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ReservationDesk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "desk_id")
    private Desk desk;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public ReservationDesk() {
    }
    public ReservationDesk(Reservation reservation, Desk desk, LocalDateTime startTime, LocalDateTime endTime) {
        this.reservation = reservation;
        this.desk = desk;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public Long getId() {
        return id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Desk getDesk() {
        return desk;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
