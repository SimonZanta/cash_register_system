package com.example.DBConnected.Reservation;

import com.example.DBConnected.*;
import com.example.DBConnected.Desk.Desk;
import com.example.DBConnected.Desk.DeskRepo;
import com.example.DBConnected.ReservationDesk.ReservationDesk;
import com.example.DBConnected.ReservationDesk.ReservationDeskRepo;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ReservationController {
    private final ReservationRepo reservationRepo;
    private final DeskRepo deskRepo;
    private final ReservationDeskRepo reservationDeskRepo;

    public ReservationController(ReservationRepo reservationRepo, DeskRepo deskRepo, ReservationDeskRepo reservationDeskRepo) {
        this.reservationRepo = reservationRepo;
        this.deskRepo = deskRepo;
        this.reservationDeskRepo = reservationDeskRepo;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Reservation")
    public Iterable<Reservation> findAllEmployees(){
        return this.reservationRepo.findAll();
    }

    @PostMapping("/Reservation")
    @Transactional
    public ResponseEntity<?> createReservation(@RequestBody ReservationRequestDTO requestDTO) {
        for(Long deskId : requestDTO.getDeskIds()) {
            Desk desk = deskRepo.findById(Math.toIntExact(deskId))
                    .orElseThrow(() -> new RuntimeException("Desk not found: " + deskId));

            Optional<ReservationDesk> existingReservation = reservationDeskRepo.findByDeskIdAndTimeRange(
                    desk.getId(),
                    requestDTO.getStartTime(),
                    requestDTO.getEndTime());

            if (existingReservation.isPresent()) {
                return ResponseEntity.badRequest().body("Reservation for the desk at the specified time already exists for deskId " + deskId);
            }
        }

        Reservation reservation = new Reservation();
        reservation.setName(requestDTO.getName());
        reservation.setStart_time(requestDTO.getStartTime());
        reservation.setEnd_time(requestDTO.getEndTime());
        reservation = reservationRepo.save(reservation);

        for(Long deskId : requestDTO.getDeskIds()) {
            Desk desk = deskRepo.findById(Math.toIntExact(deskId))
                    .orElseThrow(() -> new RuntimeException("Desk not found: " + deskId));

            ReservationDesk reservationDesk = new ReservationDesk();
            reservationDesk.setReservation(reservation);
            reservationDesk.setDesk(desk);
            reservationDeskRepo.save(reservationDesk);
        }

        return ResponseEntity.ok("Reservation created successfully with ID: " + reservation.getId());
    }
    @DeleteMapping("/Reservation/{reservationId}")
    @Transactional
    public ResponseEntity<?> cancelReservation(@PathVariable Long reservationId) {

        Reservation reservation = reservationRepo.findById(Math.toIntExact(reservationId))
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + reservationId));

        reservationDeskRepo.deleteByReservation_id(reservationId);

        reservationRepo.deleteById(Math.toIntExact(reservationId));

        return ResponseEntity.ok("Reservation cancelled successfully");
    }




}
