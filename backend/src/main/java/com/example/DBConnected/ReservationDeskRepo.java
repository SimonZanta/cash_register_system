package com.example.DBConnected;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ReservationDeskRepo extends CrudRepository<ReservationDesk, Integer> {
    Optional<ReservationDesk> findByDeskIdAndStartTime(Integer deskId, LocalDateTime startTime);
}
