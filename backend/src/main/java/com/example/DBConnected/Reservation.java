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

    private String name;
    @OneToMany(mappedBy = "reservation")
    private Set<ReservationDesk> reservationDesks = new HashSet<>();
    protected Reservation() {
    }

    public Reservation(String name) {
        this.name = name;
    }

    public long getReservation_id() {
        return reservation_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
