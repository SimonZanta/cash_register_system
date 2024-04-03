package com.example.DBConnected.Order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderTableRepo extends CrudRepository<OrderTable, Integer> {

}
