package com.practice.controller;

import com.practice.Services.ProductService;
import com.practice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService=productService;
    }
    @GetMapping
    public List<Product> getAllProducts(){

        try {
            return productService.getAllProducts();
        }
        finally {
            return null;
        }
    }
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productService.getsingleProduct(id);
    }
    @PostMapping
    public Product addNewProduct(@RequestBody Product product)
    {
        return productService.addNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product)
    {
        return productService.updateProduct(id,product);
    }
    @PutMapping("/{id}")
    public void replaceProduct(@PathVariable("id") Long id, @RequestBody Product product)
    {

    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {

    }

}