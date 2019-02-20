package com.celik.example.swagger.service;

import com.celik.example.swagger.model.Product;
import com.celik.example.swagger.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService implements  IProductService {

    ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(String Id) {
        return productRepository.findProductByProductId(Id);
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(String Id) {
         productRepository.deleteByProductId(Id);
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
