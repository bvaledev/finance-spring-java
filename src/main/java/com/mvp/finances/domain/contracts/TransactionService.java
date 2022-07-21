package com.mvp.finances.domain.contracts;

import com.mvp.finances.domain.models.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findAll();
    Transaction create(Transaction transactionDTO);
}
