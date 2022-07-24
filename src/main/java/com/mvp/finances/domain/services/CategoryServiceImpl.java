package com.mvp.finances.domain.services;

import com.mvp.finances.domain.dto.CategoryViewDto;
import com.mvp.finances.domain.dto.NewCategoryFormDto;
import com.mvp.finances.domain.dto.UpdateCategoryFormDto;
import com.mvp.finances.domain.exceptions.BadRequestException;
import com.mvp.finances.domain.exceptions.NotFoundException;
import com.mvp.finances.domain.models.Category;
import com.mvp.finances.infra.database.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.String;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final String notFoundMessage;
    private final String badRequestMessage;

    @Autowired
    CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
        this.notFoundMessage = "Category Not Found";
        this.badRequestMessage = "Category already exists";
    }

    @Override
    public CategoryViewDto findOne(Long id) {
        Category category = this.repository.findById(id).orElseThrow(() -> new NotFoundException(this.notFoundMessage));
        return new CategoryViewDto(category);
    }

    @Override
    public Category findCategoryById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException(this.notFoundMessage));
    }

    @Override
    public List<CategoryViewDto> findAll() {
        return this.repository.findAll().stream().map(t -> new CategoryViewDto(t)).toList();
    }

    @Override
    public CategoryViewDto create(NewCategoryFormDto categoryDto) {
        Category categorylExists = this.repository.findByTitle(categoryDto.getTitle());
        if (categorylExists != null) {
            throw new BadRequestException(this.badRequestMessage);
        }
        Category category = new Category();
        category.setTitle(categoryDto.getTitle());
        category = this.repository.save(category);
        return new CategoryViewDto(category);
    }

    @Override
    public CategoryViewDto update(Long id, UpdateCategoryFormDto categoryDto) {
        this.blockCategory(id);
        Category category = this.findCategoryById(id);
        if (!categoryDto.getTitle().equals(category.getTitle())) {
            Category categorylExists = this.repository.findByTitle(categoryDto.getTitle());
            if (categorylExists != null) {
                throw new BadRequestException(this.badRequestMessage);
            }
        }
        category.setTitle(categoryDto.getTitle());
        this.repository.save(category);
        return new CategoryViewDto(category);
    }

    @Override
    public CategoryViewDto delete(Long id) {
        this.blockCategory(id);
        Category category = this.findCategoryById(id);
        this.repository.delete(category);
        return new CategoryViewDto(category);
    }

    private void blockCategory(Long id) {
        if (id == 1) {
            throw new NotFoundException(this.notFoundMessage);
        }
    }

}
