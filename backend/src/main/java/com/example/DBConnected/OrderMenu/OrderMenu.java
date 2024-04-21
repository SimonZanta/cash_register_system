package com.example.DBConnected.OrderMenu;

import com.example.DBConnected.Menu.Menu;
import com.example.DBConnected.Order.OrderTable;
import jakarta.persistence.*;

import javax.swing.plaf.IconUIResource;

@Entity
@Table(name = "ordermenu")
public class OrderMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderTable order;

    private int count;
    public OrderMenu(){}

    public OrderMenu(Menu menu, OrderTable order, int count) {
        this.menu = menu;
        this.order = order;
        this.count = count;
    }

    public Menu getMenu() {
        return menu;
    }

    public OrderTable getOrder() {
        return order;
    }

    public long getId() {
        return id;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setOrder(OrderTable order) {
        this.order = order;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
