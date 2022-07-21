package com.mvp.finances.domain.dto;

import com.mvp.finances.domain.models.ReleaseType;
import com.mvp.finances.domain.models.Transaction;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionViewDto {
    private Long id;
    private String title;
    private BigDecimal amount;
    private ReleaseType releaseType;
    private LocalDateTime createdAt;

    public TransactionViewDto(Transaction transaction) {
        this.id = transaction.getId();
        this.title = transaction.getTitle();
        this.amount = transaction.getAmount();
        this.releaseType = transaction.getReleaseType();
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
}
