package com.example.contentmakerapi.service;

import com.example.contentmakerapi.controller.BadRequestException;
import com.example.contentmakerapi.dto.UserRequestDTO;
import com.example.contentmakerapi.entity.User;
import com.example.contentmakerapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Test
    void registerUser(){
        final User user = new User("test@test.com", "'");
        final UserRequestDTO userRequestDTO = new UserRequestDTO(user.getEmail(),user.getPassword());



    }



}

