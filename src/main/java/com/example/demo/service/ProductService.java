package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {

   List<Product> getAllProduct();
   Product getProductById(Long id);
   boolean deleteProductById(Long id);
   Product addProduct(ProductDto productDto);
   Product updateProduct(Product product);

}
