package com.example.DBConnected.Menu;

import com.example.DBConnected.Allergen.Allergen;
import com.example.DBConnected.Allergen.AllergenRepo;
import com.example.DBConnected.AllergenMenu.AllergenMenu;
import com.example.DBConnected.AllergenMenu.AllergenMenuRepo;
import com.example.DBConnected.Desk.Desk;
import com.example.DBConnected.ReservationDesk.ReservationDesk;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {
    private MenuRepo menuRepo;
    private AllergenMenuRepo allergenMenuRepo;
    private AllergenRepo allergenRepo;

    public MenuController(MenuRepo menuRepo, AllergenMenuRepo allergenMenuRepo, AllergenRepo allergenRepo) {
        this.menuRepo = menuRepo;
        this.allergenMenuRepo = allergenMenuRepo;
        this.allergenRepo = allergenRepo;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Menu")
    public Iterable<Menu> findAllEmployees(){
        return this.menuRepo.findAll();
    }
    @PostMapping("/Menu")
    @Transactional
    public ResponseEntity<?> createReservation(@RequestBody MenuRequestDTO requestDTO) {

        Menu menu = new Menu();
        menu.setName(requestDTO.getName());
        menu.setWeight(requestDTO.getWeight());
        menu.setPrice(requestDTO.getPrice());
        menu = menuRepo.save(menu);

        for(Long deskId : requestDTO.getAllergensIds()) {
            Allergen allergen = allergenRepo.findById(Math.toIntExact(deskId))
                    .orElseThrow(() -> new RuntimeException("Desk not found: " + deskId));

            AllergenMenu allergenMenu = new AllergenMenu();
            allergenMenu.setAllergen(allergen);
            allergenMenu.setMenu(menu);
            allergenMenuRepo.save(allergenMenu);
        }

        return ResponseEntity.ok("Dish created successfully with ID: " + menu.getId());
    }
}
