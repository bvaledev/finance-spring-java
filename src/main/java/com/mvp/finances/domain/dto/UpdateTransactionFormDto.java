package com.mvp.finances.domain.dto;

import com.mvp.finances.domain.contracts.FormDto;
import com.mvp.finances.domain.models.ReleaseType;
import com.mvp.finances.domain.models.Transaction;

import java.math.BigDecimal;

public class UpdateTransactionFormDto implements FormDto<Transaction> {
    private String title;
    private BigDecimal amount;
    private ReleaseType releaseType;

    public UpdateTransactionFormDto() {
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

    @Override
    public Transaction toModel() {
        return new Transaction(title, amount, releaseType);
    }
}
