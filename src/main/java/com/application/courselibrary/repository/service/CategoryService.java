package com.application.courselibrary.repository.service;


import com.application.courselibrary.entity.Category;
import com.application.courselibrary.entity.Publisher;
import com.application.courselibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {
        Category category ;
        category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find category "));
        return category;
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Category category;
        category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find category "));
        categoryRepository.deleteById(category.getId());
    }
}
