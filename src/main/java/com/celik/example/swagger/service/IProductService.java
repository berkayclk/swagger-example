package com.celik.example.swagger.service;

import com.celik.example.swagger.model.Product;


public interface IProductService {

    public Product getProductById(Long Id);

    public Iterable<Product> getAllProducts();

    public void deleteProductById(Long Id);

    public Product updateProduct(Product product);

    public Product createProduct(Product product);
}
