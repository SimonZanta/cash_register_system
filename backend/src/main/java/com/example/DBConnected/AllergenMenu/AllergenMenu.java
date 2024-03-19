package com.example.DBConnected.AllergenMenu;

import com.example.DBConnected.Allergen.Allergen;
import com.example.DBConnected.Menu.Menu;
import com.example.DBConnected.Reservation.Reservation;
import jakarta.persistence.*;

@Entity
@Table(name = "allergenMenu")
public class AllergenMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "allergen_id")
    private Allergen allergen;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public long getId() {
        return id;
    }

    public Allergen getAllergen() {
        return allergen;
    }

    public void setAllergen(Allergen allergen) {
        this.allergen = allergen;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
