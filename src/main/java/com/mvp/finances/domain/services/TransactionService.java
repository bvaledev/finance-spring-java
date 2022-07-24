package com.mvp.finances.domain.services;

import com.mvp.finances.domain.dto.*;
import com.mvp.finances.domain.models.ReleaseType;
import com.mvp.finances.domain.models.Transaction;

import java.util.List;

public interface TransactionService {
    List<TransactionViewDto> findAll();
    Transaction findOne(Long id);
    Transaction create(NewTransactionFormDto transactionDto);
    Transaction update(Long id, UpdateTransactionFormDto transactionDto);
    Transaction delete(Long id);
    List<TransactionReportByCategory> reportByCategory(ReleaseType releaseType, Integer year);
    List<TransactionReportByDate> reportByYear(ReleaseType releaseType, Integer year);
}
