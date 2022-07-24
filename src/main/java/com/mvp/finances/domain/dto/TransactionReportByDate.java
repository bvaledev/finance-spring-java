package com.mvp.finances.domain.dto;

import com.mvp.finances.domain.models.ReleaseType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionReportByDate {
    private BigDecimal amount;
    private Date month;
    private Date year;

    public TransactionReportByDate(BigDecimal amount, Date month) {
        this.amount = amount;
        this.month = month;
        this.year = month;

    }

    public String getMonth() {
        String pattern = "MMMM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(month);
        return date;
    }

    public String getYear() {
        String pattern = "YYYY";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(month);
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public void setYear(Date year) {
        this.year = year;
    }

}
