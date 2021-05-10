package com.example.springdataone.service;

import com.example.springdataone.repository.UserDtoRepository;
import com.example.springdataone.repository.UserRepository;
import com.example.springdataone.repository.entity.User;
import com.example.springdataone.repository.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDtoManager {

    private UserDtoRepository userDtoRepository;

    @Autowired
    public UserDtoManager(UserDtoRepository userDtoRepository) {
        this.userDtoRepository = userDtoRepository;
    }

    // GET all
    public Iterable<UserDto> findAll() {
        return userDtoRepository.findAll();
    }

    //GET by name
    public Optional<UserDto> findByName(String name) {
        return userDtoRepository.findByName(name);
    }

    //POST
    public UserDto save(UserDto userDto) {
        return userDtoRepository.save(userDto);

    }
}



