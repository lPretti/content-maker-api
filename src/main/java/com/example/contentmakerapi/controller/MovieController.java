package com.example.contentmakerapi.controller;

import com.example.contentmakerapi.dto.movie.MovieRequestDTO;
import com.example.contentmakerapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping(value = "/movies")
    public ResponseEntity<?> getAllMovies(){
        return ResponseEntity.ok(movieService.listAllMovies());
    }

    @PostMapping(value = "/movies")
    public ResponseEntity<?> createMovie(@RequestBody MovieRequestDTO requestDTO){
        return ResponseEntity.ok(movieService.createMovie(requestDTO));
    }

    @GetMapping(value = "/movies/{id}")
    public  ResponseEntity<?> getDetails(@PathVariable("id") String id){
        return ResponseEntity.ok(movieService.movieGetDetails(id));
    }
}
