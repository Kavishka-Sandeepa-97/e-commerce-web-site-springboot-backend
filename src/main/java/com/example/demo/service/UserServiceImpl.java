package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserPasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
      return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByID(Long id) {
        return userRepository.findById(id).orElse(null);
        
    }

    @Override
    public User updateUserPassword(Long id,UserPasswordDto userPasswordDto) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setPassword(userPasswordDto.getPassword());
            return userRepository.save(user);

        }else {return null;}

    }

}
