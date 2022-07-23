package com.mvp.finances.domain.contracts;

import com.mvp.finances.domain.dto.NewTransactionFormDto;
import com.mvp.finances.domain.dto.TransactionViewDto;
import com.mvp.finances.domain.dto.UpdateTransactionFormDto;
import com.mvp.finances.domain.models.Transaction;

import java.util.List;

public interface TransactionService {
    List<TransactionViewDto> findAll();
    Transaction findOne(Long id);
    Transaction create(NewTransactionFormDto transactionDto);
    Transaction update(Long id, UpdateTransactionFormDto transactionDto);
    Transaction delete(Long id);
}
