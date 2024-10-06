package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Category;


public interface CategoryService {
    List<Category> getAllCategory();
    Category addCategory(Category category);
    Category updateCategory(Category category);

}
