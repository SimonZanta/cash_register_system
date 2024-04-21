package com.example.DBConnected.Reservation;

import com.example.DBConnected.Reservation.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepo extends CrudRepository<Reservation, Integer> {
    /*@Query("SELECT new com.example.DBConnected.ReservationDTO(r.id, r.name, r.startTime, r.endTime) " +
            "FROM Reservation r WHERE CAST(r.startTime AS date) = CURRENT_DATE")
    List<ReservationDTO> findTodaysReservations();*/
}
