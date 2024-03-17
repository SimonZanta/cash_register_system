package com.example.DBConnected.ReservationDesk;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ReservationDeskRepo extends CrudRepository<ReservationDesk, Integer> {
    @Query("SELECT rd FROM ReservationDesk rd JOIN rd.reservation r WHERE rd.desk.id = :deskId AND NOT (r.start_time >= :endTime OR r.end_time <= :startTime)")
    //@Query("SELECT rd FROM ReservationDesk rd WHERE rd.desk.desk_id = :deskId AND NOT (rd.startTime >= :endTime OR rd.endTime <= :startTime)")
    Optional<ReservationDesk> findByDeskIdAndTimeRange(@Param("deskId") Long deskId, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
    void deleteByReservation_id(Long reservation_id);

}
