package com.example.DBConnected.OrderMenu;

import com.example.DBConnected.Menu.MenuRepo;
import com.example.DBConnected.Order.OrderTableRepo;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderMenuController {
    private final OrderMenuRepo orderMenuRepo;

    private final OrderTableRepo orderRepo;

    private final MenuRepo menuRepo;

    public OrderMenuController(OrderMenuRepo orderMenuRepo, OrderTableRepo orderRepo, MenuRepo menuRepo) {
        this.orderMenuRepo = orderMenuRepo;
        this.orderRepo = orderRepo;
        this.menuRepo = menuRepo;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/OrderMenu")
    public Iterable<OrderMenu> findAllOrdersMenu(){
        return this.orderMenuRepo.findAll();
    }

    @PostMapping("/OrderMenu")
    public OrderMenu addOneOrder(@RequestBody OrderMenu orderMenu){
        return this.orderMenuRepo.save(orderMenu);
    }
}
