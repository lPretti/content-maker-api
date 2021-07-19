package com.example.contentmakerapi.controller;


import com.example.contentmakerapi.dto.UserRequestDTO;
import com.example.contentmakerapi.dto.UserResponseDTO;
import com.example.contentmakerapi.entity.User;
import com.example.contentmakerapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDTO requestDTO) {
        User user = new User(requestDTO.getUsername(),requestDTO.getPassword());
        try {
            userRepository.save(user);
        }catch (Exception e){
            return ResponseEntity.ok(new UserResponseDTO("no se pudo procesar la operacion"));

        }


        return ResponseEntity.ok(new UserResponseDTO("usuario agregado con exito"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRequestDTO requestDTO) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getUsername(), requestDTO.getPassword()));
        }catch (Exception e){
            return ResponseEntity.ok(new UserResponseDTO("no se pudo procesar la operacion"));


        }
        return ResponseEntity.ok(new UserResponseDTO("usuario autenticado con exito"));
    }
}