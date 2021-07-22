package com.example.contentmakerapi.controller;


import com.example.contentmakerapi.dto.UserRequestDTO;
import com.example.contentmakerapi.dto.UserResponseDTO;
import com.example.contentmakerapi.entity.User;
import com.example.contentmakerapi.repository.UserRepository;
import com.example.contentmakerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDTO requestDTO) {
        User user = new User(requestDTO.getUsername(),requestDTO.getPassword());
        try {
            userRepository.save(user);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("no se pudo procesar la operación");

        }
        return ResponseEntity.ok(new UserResponseDTO("user added with success"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRequestDTO requestDTO) {
       return ResponseEntity.ok( userService.authenticateUser(requestDTO));
    }
}