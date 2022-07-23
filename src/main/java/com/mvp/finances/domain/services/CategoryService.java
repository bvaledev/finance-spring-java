package com.mvp.finances.domain.services;

import com.mvp.finances.domain.models.Category;

public interface CategoryService {
    Category findOne(Long id);
}
