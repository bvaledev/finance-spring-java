package com.mvp.finances.application.controllers;

import com.mvp.finances.domain.dto.CategoryViewDto;
import com.mvp.finances.domain.dto.NewCategoryFormDto;
import com.mvp.finances.domain.dto.UpdateCategoryFormDto;
import com.mvp.finances.domain.models.Category;
import com.mvp.finances.domain.services.CategoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryViewDto> create(@RequestBody NewCategoryFormDto categoryDto, UriComponentsBuilder uriBuilder) {
        System.out.println(categoryDto.getTitle());
        CategoryViewDto category = this.categoryService.create(categoryDto);
        URI uriPath = uriBuilder.path("/categories/"+ category.getId()).build().toUri();
        return ResponseEntity.created(uriPath).body(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryViewDto>> list() {
        return ResponseEntity.ok(this.categoryService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryViewDto> update(@PathVariable("id") Long id, @RequestBody UpdateCategoryFormDto categoryDto){
        CategoryViewDto category = this.categoryService.update(id, categoryDto);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryViewDto> delete(@PathVariable("id") Long id){
        CategoryViewDto category = this.categoryService.delete(id);
        return ResponseEntity.ok(category);
    }
}
