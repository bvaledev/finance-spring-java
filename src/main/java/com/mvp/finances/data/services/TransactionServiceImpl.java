package com.mvp.finances.data.services;

import com.mvp.finances.domain.contracts.TransactionService;
import com.mvp.finances.domain.dto.NewTransactionFormDto;
import com.mvp.finances.domain.dto.UpdateTransactionFormDto;
import com.mvp.finances.domain.exceptions.NotFoundException;
import com.mvp.finances.domain.models.Transaction;
import com.mvp.finances.infra.database.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository repository;
    private String notFoundMessage;

    @Autowired
    TransactionServiceImpl(TransactionRepository repository){
        this.repository = repository;
        this.notFoundMessage = "Transaction Not Found";
    }

    @Override
    public List<Transaction> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Transaction create(NewTransactionFormDto transactionDTO){
        return this.repository.save(transactionDTO.toModel());
    }

    @Override
    public Transaction findOne(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException(this.notFoundMessage));
    }

    @Override
    public Transaction update(Long id, UpdateTransactionFormDto transactionDto){
        Transaction transaction = this.findOne(id);
        transaction.setTitle(transactionDto.getTitle());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setReleaseType(transactionDto.getReleaseType());
        return this.repository.save(transaction);
    }

    @Override
    public Transaction delete(Long id){
        Transaction transaction = this.findOne(id);
        this.repository.deleteById(transaction.getId());
        return transaction;
    }
}
