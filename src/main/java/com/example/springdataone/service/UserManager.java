package com.example.springdataone.service;

import com.example.springdataone.repository.UserRepository;
import com.example.springdataone.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManager {
    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET all
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    //GET by ID
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    //POST
    public User save(User user) {
        return userRepository.save(user);
    }

}
