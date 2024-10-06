package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteProductById(Long id){
         if (productRepository.findById(id).isPresent()){
             productRepository.deleteById(id);
             return true;
         }else{
             return false;
         }
    }

    @Override
    public Product addProduct(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product){
        if (productRepository.findById(product.getId()).isPresent()){
           return productRepository.save(product);
        }else{
            return null;
        }
    }
}
