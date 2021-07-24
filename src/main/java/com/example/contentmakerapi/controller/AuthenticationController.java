package com.example.contentmakerapi.controller;


import com.example.contentmakerapi.dto.UserRequestDTO;
import com.example.contentmakerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDTO requestDTO) {
        return ResponseEntity.ok( userService.registerUser(requestDTO));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRequestDTO requestDTO) {
       return ResponseEntity.ok( userService.authenticateUser(requestDTO));
    }
}