package com.example.DBConnected.ReservationDesk;

import com.example.DBConnected.Desk.Desk;
import com.example.DBConnected.Reservation.Reservation;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ReservationDesk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "desk_id")
    private Desk desk;

    public ReservationDesk() {
    }
    public ReservationDesk(Reservation reservation, Desk desk) {
        this.reservation = reservation;
        this.desk = desk;
    }
    public long getId() {
        return id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }
}
