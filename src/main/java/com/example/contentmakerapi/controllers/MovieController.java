package com.example.contentmakerapi.controllers;

import com.example.contentmakerapi.dtos.movie.MovieListResponseDTO;
import com.example.contentmakerapi.dtos.movie.MovieRequestDTO;
import com.example.contentmakerapi.dtos.movie.MovieResponseDTO;
import com.example.contentmakerapi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/movies")
    public ResponseEntity<MovieListResponseDTO> getAllMovies(){
        return ResponseEntity.ok(movieService.listAllMovies());
    }

    @PostMapping(value = "/movies")
    public ResponseEntity<MovieResponseDTO> createMovie(@RequestBody MovieRequestDTO requestDTO){
        return ResponseEntity.ok(movieService.createMovie(requestDTO));
    }

    @GetMapping(value = "/movies/details")
    public  ResponseEntity<MovieResponseDTO> getDetails(@RequestBody String id){
        return ResponseEntity.ok(movieService.movieGetDetails(id));
    }
}
