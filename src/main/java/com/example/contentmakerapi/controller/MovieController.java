package com.example.contentmakerapi.controller;

import com.example.contentmakerapi.dto.character.CharacterRequestDTO;
import com.example.contentmakerapi.dto.movie.MovieRequestDTO;
import com.example.contentmakerapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping( value = "/movies")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(movieService.listAllMovies());
    }

    @PostMapping( value = "/movies")
    public ResponseEntity<?> createCharacter(@RequestBody MovieRequestDTO requestDTO){
        return ResponseEntity.ok(movieService.createMovie(requestDTO));
    }

}
