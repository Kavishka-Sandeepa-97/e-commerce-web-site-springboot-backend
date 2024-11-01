package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")//("localhost:5127")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/getAllCategory")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/getCategoryById/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
    @PostMapping("/createCategory")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }
    @PostMapping("updatecategory")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }



}
