package com.celik.example.swagger.service;

import com.celik.example.swagger.model.Product;


public interface IProductService {

    public Product getProductById(String Id);

    public Iterable<Product> getAllProducts();

    public void deleteProductById(String Id);

    public Product updateProduct(Product product);

    public Product createProduct(Product product);
}
