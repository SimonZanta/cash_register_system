package com.example.DBConnected.Bill;

import com.example.DBConnected.Services.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {
    private final BillRepo billRepo;

    //private final PaymentService paymentService;

    public BillController(BillRepo billRepo/* ,PaymentService paymentService*/) {
        this.billRepo = billRepo;
      //  this.paymentService = paymentService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Bill")
    public Iterable<Bill> findAllBills(){
        return this.billRepo.findAll();
    }

    @PostMapping("/Bill")
    @Transactional
    public Bill addOneBill(@RequestBody Bill bill){
        return this.billRepo.save(bill);
    }
}
