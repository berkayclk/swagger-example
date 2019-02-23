package com.celik.example.swagger.controllers;

import com.celik.example.swagger.model.Product;
import com.celik.example.swagger.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@RestController
@RequestMapping("/product")
@Api(value="eCommerce", description="Product operations for eCommerce")
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
        product.setProductId("prod-99");
        product.setDescription("Deneme Product 2");
        product.setImageUrl("https://iamge.iamge.deneme2");
        product.setPrice(BigDecimal.valueOf(20));
        productService.createProduct(product);
    }



    @ApiOperation(value = "View a list of available products", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/")
    @ResponseBody
    public Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @ApiOperation(value = "Search a product with an ID",response = Product.class)
    @GetMapping("/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable String id){ return productService.getProductById(id); }

    @ApiOperation(value = "Delete a product with an ID",response = Boolean.class)
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

    @ApiOperation(value = "Add a product to Repository",response = Product.class)
    @PostMapping("/")
    @ResponseBody
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

}
