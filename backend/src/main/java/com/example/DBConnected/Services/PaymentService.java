package com.example.DBConnected.Services;

import com.example.DBConnected.Bill.Bill;
import com.example.DBConnected.Bill.BillRepo;
import com.example.DBConnected.Desk.DeskRepo;
import com.example.DBConnected.Menu.Menu;
import com.example.DBConnected.Menu.MenuRepo;
import com.example.DBConnected.Order.OrderTable;
import com.example.DBConnected.Order.OrderTableRepo;
import com.example.DBConnected.OrderMenu.OrderMenu;
import com.example.DBConnected.OrderMenu.OrderMenuRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PaymentService {
    private final OrderMenuRepo orderMenuRepo;
    private final MenuRepo menuRepo;
    private final OrderTableRepo orderRepo;
    private final BillRepo billRepo;

    public PaymentService(OrderMenuRepo orderMenuRepo, MenuRepo menuRepo, OrderTableRepo orderRepo, BillRepo billRepo) {
        this.orderMenuRepo = orderMenuRepo;
        this.menuRepo = menuRepo;
        this.orderRepo = orderRepo;
        this.billRepo = billRepo;
    }

    @Transactional
    public ResponseEntity<?> processPayment(/*Long orderId, List<Long> menuIds, */List<Long> ids) {
        List<OrderMenu> orderMenus = new ArrayList<>();
        //pro případ že se nedostaneme k tomu aby mi byla poslána jednotlivá ID
        //ale budou mi poslány id objednávky a menu
        /*for(Long menuId: menuIds){
            orderMenus.addAll(orderMenuRepo.findByOrderId(orderId,menuId));
        }*/
        for(Long id: ids){
            orderMenus.add(orderMenuRepo.findById(id));
        }
        Bill bill = new Bill();
        int price = 0;
        for (OrderMenu orderMenu : orderMenus) {
            Optional<Menu> menu = menuRepo.findById((int) orderMenu.getMenu().getId());
            if(menu.isPresent()) {
                price += menu.get().getPrice();
            }
            orderMenuRepo.delete(orderMenu);
        }
        int id =(int) orderMenus.get(0).getOrder().getId();
        Optional<OrderTable> order = orderRepo.findById(id);
        order.ifPresent(orderTable -> bill.setDesk(orderTable.getDesk()));
        bill.setPrice(price);
        billRepo.save(bill);
        return ResponseEntity.ok("Bill succesfully added");
    }
}
