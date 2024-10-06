package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.entity.User;
import com.example.demo.service.CategoryService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/getAllUser")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/getUserbyId/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserByID(id);
    }



}
