package com.example.contentmakerapi.controllers;

import com.example.contentmakerapi.dtos.user.UserRequestDTO;
import com.example.contentmakerapi.services.UserAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    private UserAuthService userService;

    public AuthenticationController(UserAuthService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDTO requestDTO) {
        return ResponseEntity.ok( userService.registerUser(requestDTO));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRequestDTO requestDTO) {
       return ResponseEntity.ok( userService.authenticateUser(requestDTO));
    }
}