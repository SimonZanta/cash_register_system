package com.example.DBConnected.Allergen;

import com.example.DBConnected.Employee.Employee;
import com.example.DBConnected.Reservation.Reservation;
import org.springframework.web.bind.annotation.*;

@RestController
public class AllergenController {
    private final AllergenRepo allergenRepo;

    public AllergenController(AllergenRepo allergenRepo) {
        this.allergenRepo = allergenRepo;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Allergen")
    public Iterable<Allergen> findAllAllergens(){
        return this.allergenRepo.findAll();
    }

    @PostMapping("/Allergen")
    public Allergen addOneEmployee(@RequestBody Allergen allergen){
        return this.allergenRepo.save(allergen);
    }

}
