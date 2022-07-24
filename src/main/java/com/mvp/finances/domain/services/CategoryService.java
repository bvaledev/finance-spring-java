package com.mvp.finances.domain.services;

import com.mvp.finances.domain.dto.*;
import com.mvp.finances.domain.models.Category;

import java.util.List;

public interface CategoryService {
    CategoryViewDto findOne(Long id);
    Category findCategoryById(Long id);
    List<CategoryViewDto> findAll();
    CategoryViewDto create(NewCategoryFormDto categoryDto);
    CategoryViewDto update(Long id, UpdateCategoryFormDto categoryDto);
    CategoryViewDto delete(Long id);
}
