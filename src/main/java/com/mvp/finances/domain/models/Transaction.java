package com.mvp.finances.domain.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal amount;
    @ManyToOne
    private Category category;
    @Enumerated(value = EnumType.STRING)
    private ReleaseType releaseType;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Date transactionDate;

    public Transaction() {
    }

    public Transaction(Category category, String title, BigDecimal amount, ReleaseType releaseType, Date transactionDate) {
        this.category = category;
        this.title = title;
        this.amount = amount;
        this.releaseType = releaseType;
        this.transactionDate = transactionDate;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setReleaseType(ReleaseType releaseType) {
        this.releaseType = releaseType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
