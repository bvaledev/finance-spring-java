package com.mvp.finances.domain.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal amount;
    @Enumerated(value = EnumType.STRING)
    private ReleaseType releaseType;
    private LocalDateTime createdAt  = LocalDateTime.now();

    public Transaction() {
    }

    public Transaction(String title, BigDecimal amount, ReleaseType releaseType){
        this.title = title;
        this.amount = amount;
        this.releaseType = releaseType;
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
