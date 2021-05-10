package com.example.springdataone;

import com.example.springdataone.configuration.PasswordEncoderConfig;
import com.example.springdataone.repository.entity.User;
import com.example.springdataone.repository.entity.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDtoBuilder {

    private User user;
    private UserDto userDto;

    public UserDtoBuilder() {
    }

    public UserDtoBuilder(User user, UserDto userDto) {
        this.user = user;
        this.userDto = userDto;
    }

    public void setNewName() {
        userDto.setName(user.getName());
    }

    public void setNewPassword() {
        PasswordEncoder pass = new PasswordEncoderConfig().passwordEncoder();
        userDto.setPasswordHash(pass.encode(user.getPassword()));
    }

    public void setNewRole() {
        userDto.setRole(user.getRole());
    }
}
