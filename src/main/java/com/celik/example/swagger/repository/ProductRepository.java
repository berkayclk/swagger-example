package com.celik.example.swagger.repository;

import com.celik.example.swagger.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findProductByProductId(String productId);

    void deleteByProductId(String productId);
}
