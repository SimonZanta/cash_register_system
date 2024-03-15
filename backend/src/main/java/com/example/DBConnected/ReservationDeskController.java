package com.example.DBConnected;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

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
    public ReservationDesk addOneReservationDesk(@RequestBody ReservationDeskDTO reservationDeskDTO) {
        Desk desk = deskRepo.findById(reservationDeskDTO.getDeskId())
                .orElseThrow(() -> new RuntimeException("Desk not found: " + reservationDeskDTO.getDeskId()));

        Reservation reservation = reservationRepo.findById(reservationDeskDTO.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation not found: " + reservationDeskDTO.getReservationId()));

        ReservationDesk reservationDesk = new ReservationDesk();
        reservationDesk.setDesk(desk);
        reservationDesk.setReservation(reservation);
        reservationDesk.setStartTime(reservationDeskDTO.getStartTime());
        reservationDesk.setEndTime(reservationDeskDTO.getEndTime());

        return reservationDeskRepo.save(reservationDesk);
    }


}
