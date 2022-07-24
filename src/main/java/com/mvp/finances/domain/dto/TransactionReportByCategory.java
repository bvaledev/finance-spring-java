package com.mvp.finances.domain.dto;

import java.math.BigDecimal;

public class TransactionReportByCategory {
    private BigDecimal amount;
    private String category;

    public TransactionReportByCategory(BigDecimal amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
