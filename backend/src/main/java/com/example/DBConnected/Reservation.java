package com.example.DBConnected;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservation_id;

    @OneToMany(mappedBy = "reservation")
    private Set<ReservationDesk> reservationDesks = new HashSet<>();
    public Reservation() {
    }


    public long getReservation_id() {
        return reservation_id;
    }


}
