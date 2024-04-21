package com.example.DBConnected.Bill;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface BillRepo extends CrudRepository<Bill,Integer> {
    @Procedure(name = "daily_closure")
    void performDailyClosure();
}
