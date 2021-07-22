package com.example.contentmakerapi.service;

import com.example.contentmakerapi.dto.UserRequestDTO;
import com.example.contentmakerapi.dto.UserResponseDTO;
import com.example.contentmakerapi.entity.User;
import com.example.contentmakerapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) return null;

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public UserResponseDTO authenticateUser(UserRequestDTO requestDTO) {
        UserResponseDTO result = new UserResponseDTO("successful authentication");
        try {


            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getUsername(), requestDTO.getPassword()));
        } catch (Exception e) {
            result = new UserResponseDTO("no se pudo procesar la operacion");
        }
        return result;
    }

}
