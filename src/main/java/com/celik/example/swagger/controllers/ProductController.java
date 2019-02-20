package com.celik.example.swagger.controllers;

import com.celik.example.swagger.model.Product;
import com.celik.example.swagger.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@RestController
@RequestMapping("/product")
public class ProductController {

    private IProductService productService;

    @Autowired
    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @PostConstruct
    private void init(){
        Product product = new Product();
        product.setProductId("prod-1");
        product.setDescription("Deneme Product");
        product.setImageUrl("https://iamge.iamge.deneme");
        product.setPrice(BigDecimal.valueOf(10));
        productService.createProduct(product);

        product = new Product();
        product.setProductId("prod-2");
        product.setDescription("Deneme Product 2");
        product.setImageUrl("https://iamge.iamge.deneme2");
        product.setPrice(BigDecimal.valueOf(20));
        productService.createProduct(product);
    }

    @GetMapping("/")
    @ResponseBody
    public Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable String id){ return productService.getProductById(id); }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean deleteProduct(@PathVariable String id) {
        try {
            productService.deleteProductById(id);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @PostMapping("/")
    @ResponseBody
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

}
