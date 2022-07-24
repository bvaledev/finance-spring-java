package com.mvp.finances.domain.dto;

import com.mvp.finances.domain.models.Category;

public class CategoryViewDto {
    private Long id;
    private String title;

    public CategoryViewDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
