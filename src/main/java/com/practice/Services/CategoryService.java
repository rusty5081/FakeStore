package com.practice.Services;

import com.practice.models.Category;
import com.practice.models.Product;

import java.util.List;

public interface CategoryService {

    public List<String> getAllCategories();
    public List<Category> getSpecificCategory(String category);

}
