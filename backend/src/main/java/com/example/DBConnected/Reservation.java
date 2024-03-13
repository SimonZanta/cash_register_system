package com.example.DBConnected;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservation_id;
    private String name;
    private LocalDateTime start_time;
    @ManyToOne
    @JoinColumn(name="desk_id")
    private Desk desk;
    protected Reservation(){}

    public Reservation(String name, LocalDateTime start_time, Desk desk) {
        this.name = name;
        this.start_time = start_time;
        this.desk = desk;
    }

    public long getReservation_id() {
        return reservation_id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }
}
