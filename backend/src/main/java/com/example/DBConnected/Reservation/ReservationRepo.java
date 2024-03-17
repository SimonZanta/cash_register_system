package com.example.DBConnected.Reservation;

import com.example.DBConnected.Reservation.Reservation;
import org.springframework.data.repository.CrudRepository;

//this is simple middle man between model and controller
//if used CrudRepo we don't need to define any CRUD operation
public interface ReservationRepo extends CrudRepository<Reservation, Integer> {
}
