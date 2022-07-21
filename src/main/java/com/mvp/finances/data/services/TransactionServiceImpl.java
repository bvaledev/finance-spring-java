package com.mvp.finances.data.services;

import com.mvp.finances.domain.contracts.TransactionService;
import com.mvp.finances.domain.models.Transaction;
import com.mvp.finances.infra.database.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Override
    public List<Transaction> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Transaction create(Transaction transactionDTO){
        return this.repository.save(transactionDTO);
    }
}
