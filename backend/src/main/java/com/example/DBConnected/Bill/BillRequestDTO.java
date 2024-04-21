package com.example.DBConnected.Bill;

import java.util.List;

public class BillRequestDTO {
    private List<Long> ids;

    public BillRequestDTO() {
    }

    public BillRequestDTO(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
