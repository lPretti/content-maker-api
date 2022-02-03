package com.example.contentmakerapi.services;

import com.example.contentmakerapi.auth.JwtUtils;
import com.example.contentmakerapi.dtos.user.UserRequestDTO;
import com.example.contentmakerapi.dtos.user.UserResponseDTO;
import com.example.contentmakerapi.entities.User;
import com.example.contentmakerapi.repositories.UserRepository;
import com.example.contentmakerapi.services.exception.UserAuthException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) throw new UserAuthException("Username is null or empty");

        return new org.springframework.security.core.userdetails.User(optionalUser.get().getUsername(),optionalUser.get().getPassword(),new ArrayList<>());
    }

    public UserResponseDTO authenticateUser(UserRequestDTO requestDTO) {
        final UserDetails user = loadUserByUsername(requestDTO.getUsername());

        if(user == null){
            throw new UserAuthException("User don't exist");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        return new UserResponseDTO(jwtUtils.generateToken(user));
    }

    public UserResponseDTO registerUser(UserRequestDTO requestDTO){

        validateRequestFields(requestDTO);
        if(userRepository.findByUsername(requestDTO.getUsername()).isPresent()){
            throw new UserAuthException("User already exist");
        }

        userRepository.save(new User(requestDTO.getUsername(), requestDTO.getPassword()));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getUsername(), requestDTO.getPassword()));

        return  new UserResponseDTO(jwtUtils.generateToken(loadUserByUsername(requestDTO.getUsername())));
    }

    private void validateRequestFields(UserRequestDTO requestDTO){
        if(requestDTO.getUsername() == null || requestDTO.getUsername().equals("")){
            throw new UserAuthException("Username is null or empty");
        }
        if(requestDTO.getPassword() == null || requestDTO.getPassword().equals("")){
            throw new UserAuthException("Password is null or empty");
        }
    }
}
