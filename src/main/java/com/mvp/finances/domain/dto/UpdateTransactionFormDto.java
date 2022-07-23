package com.mvp.finances.domain.dto;

import com.mvp.finances.domain.models.Category;
import com.mvp.finances.domain.models.ReleaseType;

import java.math.BigDecimal;
import java.util.Date;

public class UpdateTransactionFormDto {
    private String title;
    private BigDecimal amount;
    private ReleaseType releaseType;
    private Category category;
    private Long categoryId;
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

    public Category getCategory() {
        return category;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
