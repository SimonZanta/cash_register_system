package com.example.DBConnected.Order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderTableRepo extends CrudRepository<OrderTable, Integer> {
    @Query(value = "SELECT * FROM total_sales_for_all_tables()", nativeQuery = true)
    List<Object[]> getTotalSalesForAllTables();
}
