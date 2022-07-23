package com.mvp.finances.data.services;

import com.mvp.finances.domain.contracts.CategoryService;
import com.mvp.finances.domain.contracts.TransactionService;
import com.mvp.finances.domain.dto.NewTransactionFormDto;
import com.mvp.finances.domain.dto.TransactionViewDto;
import com.mvp.finances.domain.dto.UpdateTransactionFormDto;
import com.mvp.finances.domain.exceptions.NotFoundException;
import com.mvp.finances.domain.mapper.NewTransactionFormMapper;
import com.mvp.finances.domain.models.Category;
import com.mvp.finances.domain.models.Transaction;
import com.mvp.finances.infra.database.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository repository;
    private String notFoundMessage;
    private CategoryService categoryService;
    private NewTransactionFormMapper transactionFormMapper;

    @Autowired
    TransactionServiceImpl(TransactionRepository repository, CategoryService categoryService, NewTransactionFormMapper transactionFormMapper){
        this.repository = repository;
        this.notFoundMessage = "Transaction Not Found";
        this.categoryService = categoryService;
        this.transactionFormMapper = transactionFormMapper;
    }

    @Override
    public List<TransactionViewDto> findAll() {
        return this.repository.findAll().stream().map(t -> new TransactionViewDto(t)).toList();
    }

    @Override
    public Transaction create(NewTransactionFormDto transactionDTO){
        return this.repository.save(transactionFormMapper.map(transactionDTO));
    }

    @Override
    public Transaction findOne(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException(notFoundMessage));
    }

    @Override
    public Transaction update(Long id, UpdateTransactionFormDto transactionDto){
        Transaction transaction = this.findOne(id);
        Category category = this.categoryService.findOne(transactionDto.getCategoryId());
        transaction.setTitle(transactionDto.getTitle());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setReleaseType(transactionDto.getReleaseType());
        transaction.setCategory(category);
        return this.repository.save(transaction);
    }

    @Override
    public Transaction delete(Long id){
        Transaction transaction = this.findOne(id);
        this.repository.deleteById(transaction.getId());
        return transaction;
    }
}
