package com.example.DBConnected.Order;

import java.util.List;

public class OrderRequestDTO {
    private long desk_id;

    private List<Long> menu;
    private String name;

    public long getDesk_id() {
        return desk_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesk_id(long desk_id) {
        this.desk_id = desk_id;
    }

    public List<Long> getMenu() {
        return menu;
    }

    public void setMenu(List<Long> menu) {
        this.menu = menu;
    }
}
