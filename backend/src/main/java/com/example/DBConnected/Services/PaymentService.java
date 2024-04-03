package com.example.DBConnected.Services;

import com.example.DBConnected.Bill.Bill;
import com.example.DBConnected.Bill.BillRepo;
import com.example.DBConnected.OrderMenu.OrderMenu;
import com.example.DBConnected.OrderMenu.OrderMenuRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private final OrderMenuRepo orderMenuRepo;

    private final BillRepo billRepo;

    public PaymentService(OrderMenuRepo orderMenuRepo, BillRepo billRepo) {
        this.orderMenuRepo = orderMenuRepo;
        this.billRepo = billRepo;
    }

    @Transactional
    public void processPayment(Long orderId, List<Long> menuIds) {
        List<OrderMenu> orderMenus = new ArrayList<>();
        for(Long menuId: menuIds){
            orderMenus.addAll(orderMenuRepo.findByOrderId(orderId,menuId));
        }
        Bill bill = new Bill();
        for (OrderMenu orderMenu : orderMenus) {

            //paymentHistoryRepository.save(paymentHistory); // Uložení do historie plateb
            //cartItemRepository.delete(cartItem); // Odstranění položky z košíku
        }
        //bill.setPrice();
        billRepo.save(bill);
    }
}
