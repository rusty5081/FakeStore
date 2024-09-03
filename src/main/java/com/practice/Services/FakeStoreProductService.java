package com.practice.Services;

import com.practice.Exception.ProductDoesntExist;
import com.practice.controller.ProductController;
import com.practice.dto.FakeStoreProductDto;
import com.practice.models.Category;
import com.practice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class FakeStoreProductService implements  ProductService{
    private RestTemplate restTemplate;
    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }
    private Product covertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto)
    {
        Product product=new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setId((fakeStoreProductDto.getId()));
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageURL(fakeStoreProductDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setCategory(fakeStoreProductDto.getCategory());
        return product;
    }
    private FakeStoreProductDto covertProductToFakeStoreProduct(Product product)
    {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageURL());
        fakeStoreProductDto.setCategory(product.getCategory().getCategory());
        return fakeStoreProductDto;
    }
    @Override
    public Product getsingleProduct(Long id) throws ProductDoesntExist {
        FakeStoreProductDto productDto=restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        if(productDto==null)
        {
            throw new ProductDoesntExist("Product with id:"+id+" doesn't exist");
        }
        return covertFakeStoreProductToProduct(productDto);
    }

    @Override
    public Product addNewProduct(Product product) {

        restTemplate.postForObject("https://fakestoreapi.com/products",covertProductToFakeStoreProduct(product),FakeStoreProductDto.class);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto [] productDtoList= restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> productsList=new ArrayList<>();
        for(FakeStoreProductDto dto : productDtoList)
        {
            productsList.add(covertFakeStoreProductToProduct(dto));
        }
        return productsList;
    }

    @Override
    public Product updateProduct(Long id,Product product) {
        restTemplate.patchForObject("https://fakestoreapi.com/products/"+id,covertProductToFakeStoreProduct(product),FakeStoreProductDto.class);

        return product;
    }


}
