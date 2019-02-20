package com.celik.example.swagger.service;

import com.celik.example.swagger.model.Product;
import com.celik.example.swagger.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class ProductService implements  IProductService {

    ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long Id) {
        return productRepository.findById(Id).get();
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(Long Id) {
         productRepository.deleteById(Id);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
