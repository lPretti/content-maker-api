package com.example.contentmakerapi.service;

import com.example.contentmakerapi.auth.JwtUtils;
import com.example.contentmakerapi.auth.UserAuthException;
import com.example.contentmakerapi.dto.UserRequestDTO;
import com.example.contentmakerapi.dto.UserResponseDTO;
import com.example.contentmakerapi.entity.UserModel;
import com.example.contentmakerapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> optionalUser = userRepository.findByUsername(username);

     //   if (!optionalUser.isPresent()) throw new UserAuthException("Username is null or empty");
        if (optionalUser.isEmpty()) throw new UserAuthException("Username is null or empty");

        return new User(optionalUser.get().getUsername(),optionalUser.get().getPassword(),new ArrayList<>());
    }

    public UserResponseDTO authenticateUser(UserRequestDTO requestDTO) {
        final UserDetails user = loadUserByUsername(requestDTO.getUsername());

        if(user == null){
            throw  new UserAuthException("User don't exist");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        return new UserResponseDTO(jwtUtils.generateToken(user));
    }

    public UserResponseDTO registerUser(UserRequestDTO requestDTO){

        validateRequestFields(requestDTO);
        if(loadUserByUsername(requestDTO.getUsername()) != null){
            throw new UserAuthException("User already exist");
        }

        userRepository.save(new UserModel(requestDTO.getUsername(), requestDTO.getPassword()));
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
