package com.example.contentmakerapi.service;

import com.example.contentmakerapi.dto.character.CharacterListResponseDTO;
import com.example.contentmakerapi.dto.character.CharacterToListDTO;
import com.example.contentmakerapi.dto.movie.MovieDTO;
import com.example.contentmakerapi.dto.movie.MovieListResponseDTO;
import com.example.contentmakerapi.dto.movie.MovieRequestDTO;
import com.example.contentmakerapi.dto.movie.MovieToList;
import com.example.contentmakerapi.entity.DisneyCharacter;
import com.example.contentmakerapi.entity.Movie;
import com.example.contentmakerapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public MovieListResponseDTO listAllMovies() {
        final List<Movie> moviesStored = (List<Movie>) movieRepository.findAll();
        ArrayList<MovieToList> responseDto_data = new ArrayList<>();

        for (Movie m : moviesStored) {
            responseDto_data.add(new MovieToList(m.getImage(),m.getTitle(),m.getDate()));
        }

        return  new MovieListResponseDTO(responseDto_data);
    }


    public MovieDTO createMovie(MovieRequestDTO requestDTO) {
        return null;
    }
}
