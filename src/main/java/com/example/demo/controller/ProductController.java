package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private  ProductService productService;

    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping("/addProduct")
    public Product saveProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PatchMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

}
