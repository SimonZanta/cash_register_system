package com.example.DBConnected.Bill;

import com.example.DBConnected.Services.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {
    private final BillRepo billRepo;

    private final PaymentService paymentService;

    public BillController(BillRepo billRepo ,PaymentService paymentService) {
        this.billRepo = billRepo;
        this.paymentService = paymentService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Closure")
    public void executeDailyClosure() {
        billRepo.performDailyClosure();
    }
    @PostMapping("/Bill")
    @Transactional
    public ResponseEntity<?> addOneBill(@RequestBody BillRequestDTO billRequestDTO){
        return paymentService.processPayment(billRequestDTO.getIds());
    }
}
