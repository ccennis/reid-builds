package com.hh.reidbuilds.controller;

import com.hh.reidbuilds.exception.ResourceNotFoundException;
import com.hh.reidbuilds.model.Category;
import com.hh.reidbuilds.model.Image;
import com.hh.reidbuilds.repository.CategoryRepository;
import com.hh.reidbuilds.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/categories")
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable(value = "id") Long categoryId,
                                   @Valid @RequestBody Category categoryDetails) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        category.setName(categoryDetails.getName());

        Category updatedCategory = categoryRepository.save(category);
        return updatedCategory;
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        categoryRepository.delete(category);

        return ResponseEntity.ok().build();
    }
}
