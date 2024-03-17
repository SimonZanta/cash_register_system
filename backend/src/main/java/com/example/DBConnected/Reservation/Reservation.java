package com.example.DBConnected.Reservation;

import com.example.DBConnected.ReservationDesk.ReservationDesk;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    @OneToMany(mappedBy = "reservation")
    private Set<ReservationDesk> reservationDesks = new HashSet<>();
    protected Reservation() {
    }

    public Reservation(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime startTime) {
        this.start_time = startTime;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime endTime) {
        this.end_time = endTime;
    }
}
