package com.practice.Services;

import com.practice.dto.FakeStoreCategoryDto;
import com.practice.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreCategoryService implements CategoryService{

    private RestTemplate restTemplate;
    @Autowired
    public FakeStoreCategoryService(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }
    public Category convertFakeStoretoCategory(FakeStoreCategoryDto fakeStoreCategoryDto)
    {
        Category category=new Category();
        category.setId(fakeStoreCategoryDto.getId());
        category.setTitle(fakeStoreCategoryDto.getTitle());
        category.setCategory(fakeStoreCategoryDto.getCategory());
        category.setPrice(fakeStoreCategoryDto.getPrice());
        category.setDescription(fakeStoreCategoryDto.getDescription());
        category.setImageUrl(fakeStoreCategoryDto.getImage());
        return category;
    }
    @Override
    public List<String> getAllCategories() {

        String[] fakeStoreCategoryDto=restTemplate.getForObject("https://fakestoreapi.com/products/categories", String[].class);
        List<String> categoryList=new ArrayList<>();
        for(String s :fakeStoreCategoryDto)
        {
            categoryList.add(s);
        }
        return categoryList;
    }

    @Override
    public List<Category> getSpecificCategory(String category) {
        FakeStoreCategoryDto[] fakeStoreCategoryDto=restTemplate.getForObject("https://fakestoreapi.com/products/category/"+category, FakeStoreCategoryDto[].class);
        List<Category> categoryList=new ArrayList<>();
        for(FakeStoreCategoryDto c : fakeStoreCategoryDto)
        {
            categoryList.add(convertFakeStoretoCategory(c));
        }
        return categoryList;
    }
}
