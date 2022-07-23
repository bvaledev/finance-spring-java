package com.mvp.finances.domain.dto;

import com.mvp.finances.domain.models.ReleaseType;

import java.math.BigDecimal;
import java.util.Date;

public class NewTransactionFormDto {
    private String title;
    private BigDecimal amount;
    private Long categoryId;
    private ReleaseType releaseType;
    private Date transactionDate;

    public String getTitle() {
        return title;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public ReleaseType getReleaseType() {
        return releaseType;
    }
    public Date getTransactionDate() {
        return transactionDate;
    }
    public Long getCategoryId() {
        return categoryId;
    }
}
