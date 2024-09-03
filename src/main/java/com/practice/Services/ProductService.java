package com.practice.Services;

import com.practice.models.Product;

import java.util.List;

public interface ProductService {

    Product getsingleProduct(Long id);
    Product addNewProduct(Product product);
    List<Product> getAllProducts();
    Product updateProduct(Long id,Product product);
}
