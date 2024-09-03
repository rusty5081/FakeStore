package com.practice.controller;

import com.practice.Services.CategoryService;
import com.practice.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CategoryController {

    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService)
    {
        this.categoryService=categoryService;
    }
    @GetMapping("/categories")
    public List<String> getAllCategories()
    {
        return categoryService.getAllCategories();
    }
    @GetMapping("/category/{category}")
    public List<Category> getSingleCategory(@PathVariable("category") String category)
    {
        return categoryService.getSpecificCategory(category);
    }
}

