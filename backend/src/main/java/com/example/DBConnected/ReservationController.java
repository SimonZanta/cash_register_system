package com.example.DBConnected;

import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {
    private final ReservationRepo reservationRepo;
    private final DeskRepo deskRepo;
    public ReservationController(ReservationRepo reservationRepo,DeskRepo deskRepo){
        this.reservationRepo = reservationRepo;
        this.deskRepo = deskRepo;
    }

    //refactor on bigger codebase
    //needs CrossOrigin enabled globally, this is temporary localy
    //we need it enable otherwise next.js will cry that its disabled
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Reservation")
    public Iterable<Reservation> findAllEmployees(){
        return this.reservationRepo.findAll();
    }

    @PostMapping("/Reservation")
    public Reservation addOneReservation(@RequestBody ReservationDTO reservationDTO){
       // Desk desk = deskRepo.findById(reservationDTO.getDeskId())
       //         .orElseThrow(() -> new ResourceNotFoundException("Desk not found with id " + reservationDTO.getDeskId()));

        Reservation reservation = new Reservation();
        reservation.setName(reservationDTO.getName());
        return this.reservationRepo.save(reservation);
    }

}
