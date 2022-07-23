package com.mvp.finances.domain.mapper;

import com.mvp.finances.domain.contracts.CategoryService;
import com.mvp.finances.domain.dto.NewTransactionFormDto;
import com.mvp.finances.domain.models.Category;
import com.mvp.finances.domain.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewTransactionFormMapper implements Mapper<NewTransactionFormDto, Transaction> {
    private final CategoryService categoryService;
    @Autowired
    public NewTransactionFormMapper(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Transaction map(NewTransactionFormDto t) {
        Category categoryService = this.categoryService.findOne(t.getCategoryId());
        return new Transaction(categoryService, t.getTitle(), t.getAmount(), t.getReleaseType(), t.getTransactionDate());
    }
}
