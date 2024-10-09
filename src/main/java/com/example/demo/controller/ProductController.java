package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto product){
         try {
           return ResponseEntity.status(HttpStatus.CREATED).body(  productService.addProduct(product));
         }catch (Exception e){
             return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
         }
    }

    @PatchMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product= productService.getProductById(id);
        if (product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}
