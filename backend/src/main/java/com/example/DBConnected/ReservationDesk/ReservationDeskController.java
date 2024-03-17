package com.example.DBConnected.ReservationDesk;

import com.example.DBConnected.Desk.Desk;
import com.example.DBConnected.Desk.DeskRepo;
import com.example.DBConnected.Reservation.Reservation;
import com.example.DBConnected.Reservation.ReservationRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationDeskController {
    private final ReservationDeskRepo reservationDeskRepo;
    private final DeskRepo deskRepo;
    private final ReservationRepo reservationRepo;
    public ReservationDeskController(ReservationDeskRepo reservationDeskRepo, DeskRepo deskRepo, ReservationRepo reservationRepo){
        this.reservationDeskRepo = reservationDeskRepo;
        this.deskRepo =deskRepo;
        this.reservationRepo = reservationRepo;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/ReservationDesk")
    public Iterable<ReservationDesk> findAllReservations(){
        return this.reservationDeskRepo.findAll();
    }

    @PostMapping("/ReservationDesk")
    public ResponseEntity<?> addOneReservationDesk(@RequestBody ReservationDeskDTO reservationDeskDTO) {

        Desk desk = deskRepo.findById(reservationDeskDTO.getDeskId())
                .orElseThrow(() -> new RuntimeException("Desk not found: " + reservationDeskDTO.getDeskId()));

        Reservation reservation = reservationRepo.findById(reservationDeskDTO.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation not found: " + reservationDeskDTO.getReservationId()));

        ReservationDesk reservationDesk = new ReservationDesk();
        reservationDesk.setDesk(desk);
        reservationDesk.setReservation(reservation);

        reservationDeskRepo.save(reservationDesk);
        return ResponseEntity.ok(reservationDesk);
     }

}
