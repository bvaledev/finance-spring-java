package com.mvp.finances.domain.dto;

import com.mvp.finances.domain.models.Category;
import com.mvp.finances.domain.models.ReleaseType;
import com.mvp.finances.domain.models.Transaction;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

public class TransactionViewDto {
    private Long id;
    private String title;
    private Category category;
    private BigDecimal amount;
    private ReleaseType releaseType;
    private Date transactionDate;
    private LocalDateTime createdAt;

    public TransactionViewDto(Transaction transaction) {
        this.id = transaction.getId();
        this.title = transaction.getTitle();
        this.amount = transaction.getAmount();
        this.releaseType = transaction.getReleaseType();
        this.transactionDate = transaction.getTransactionDate();
        this.category = transaction.getCategory();
        this.createdAt = transaction.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public ReleaseType getReleaseType() {
        return releaseType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Date getTransactionDate() throws ParseException {
        return transactionDate;
    }

    public Category getCategory() {
        return category;
    }
}
