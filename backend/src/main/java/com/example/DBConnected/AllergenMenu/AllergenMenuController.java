package com.example.DBConnected.AllergenMenu;

import org.springframework.web.bind.annotation.*;

@RestController
public class AllergenMenuController {
    private final AllergenMenuRepo allergenMenuRepo;

    public AllergenMenuController(AllergenMenuRepo allergenMenuRepo) {
        this.allergenMenuRepo = allergenMenuRepo;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/AllergenMenu")
    public Iterable<AllergenMenu> findAllAllergenMenu(){
        return this.allergenMenuRepo.findAll();
    }

    @PostMapping("/AllergenMenu")
    public AllergenMenu addOneAllergenMenu(@RequestBody AllergenMenu allergenMenu){
        return this.allergenMenuRepo.save(allergenMenu);
    }

}
