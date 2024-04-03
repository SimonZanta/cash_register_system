package com.example.DBConnected.Order;

import com.example.DBConnected.Desk.Desk;
import com.example.DBConnected.Desk.DeskRepo;
import com.example.DBConnected.Menu.Menu;
import com.example.DBConnected.Menu.MenuRepo;
import com.example.DBConnected.OrderMenu.OrderMenu;
import com.example.DBConnected.OrderMenu.OrderMenuRepo;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderTableController {
    private final OrderTableRepo orderRepo;
    private final DeskRepo deskRepo;
    private final MenuRepo menuRepo;
    private  final OrderMenuRepo orderMenuRepo;

    public OrderTableController(OrderTableRepo orderRepo, DeskRepo deskRepo, MenuRepo menuRepo, OrderMenuRepo orderMenuRepo) {
        this.orderRepo = orderRepo;
        this.deskRepo = deskRepo;
        this.menuRepo = menuRepo;
        this.orderMenuRepo = orderMenuRepo;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Order")
    public Iterable<OrderTable> findAllOrders(){
        return this.orderRepo.findAll();
    }

    @PostMapping("/Order")
    @Transactional
    public ResponseEntity<?> addOneOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        Desk desk = deskRepo.findById(Math.toIntExact(orderRequestDTO.getDesk_id()))
                .orElseThrow(() -> new RuntimeException("Desk not found: " + orderRequestDTO.getDesk_id()));
        OrderTable order = new OrderTable();
        order.setDesk(desk);
        order.setName(orderRequestDTO.getName() == null ? "Desk" + desk.getId() : orderRequestDTO.getName());
        order = orderRepo.save(order);

        for(long menuId: orderRequestDTO.getMenu()){
            Menu menu = menuRepo.findById(Math.toIntExact(menuId))
                    .orElseThrow(() -> new RuntimeException("Desk not found: " + orderRequestDTO.getDesk_id()));
            OrderMenu orderMenu = new OrderMenu();
            orderMenu.setMenu(menu);
            orderMenu.setOrder(order);
            orderMenuRepo.save(orderMenu);
        }
        return ResponseEntity.ok("Order created successfully");
    }

}
