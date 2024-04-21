package com.example.DBConnected.OrderMenu;

import com.example.DBConnected.Order.OrderTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderMenuRepo extends CrudRepository<OrderMenu, Integer> {
    @Query("SELECT om FROM OrderMenu om WHERE om.order.id = :orderId AND om.menu.id = :menuId")
    List<OrderMenu> findByOrderId(@Param("orderId") long orderId, @Param("menuId") long menuId);

    @Query("SELECT om FROM OrderMenu om WHERE om.id = :id")
    OrderMenu findById(@Param("id") long id);

}
