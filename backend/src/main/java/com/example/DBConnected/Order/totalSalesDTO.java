package com.example.DBConnected.Order;

import java.math.BigDecimal;

public class totalSalesDTO {
    private Long tableId;
    private BigDecimal totalSales;

    public totalSalesDTO(Long tableId, BigDecimal totalSales) {
        this.tableId = tableId;
        this.totalSales = totalSales;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }
}
