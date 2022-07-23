package com.mvp.finances.domain.services;

import com.mvp.finances.domain.services.CategoryService;
import com.mvp.finances.domain.exceptions.NotFoundException;
import com.mvp.finances.domain.models.Category;
import com.mvp.finances.infra.database.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.String;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final String notFoundMessage;

    @Autowired
    CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
        this.notFoundMessage = "Category Not Found";
    }

    @Override
    public Category findOne(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException(this.notFoundMessage));
    }
}
