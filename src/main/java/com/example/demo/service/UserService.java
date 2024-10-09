package com.example.demo.service;

import java.util.List;


import com.example.demo.dto.UserPasswordDto;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);

    User getUserByID(Long id);

    User updateUserPassword(Long id, UserPasswordDto userPasswordDto);

}
