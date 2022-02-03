package com.example.contentmakerapi.services;

import com.example.contentmakerapi.dtos.movie.MovieResponseDTO;
import com.example.contentmakerapi.dtos.movie.MovieListResponseDTO;
import com.example.contentmakerapi.dtos.movie.MovieRequestDTO;
import com.example.contentmakerapi.dtos.movie.MovieToListDTO;
import com.example.contentmakerapi.entities.Movie;
import com.example.contentmakerapi.repositories.MovieRepository;
import com.example.contentmakerapi.services.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public MovieListResponseDTO listAllMovies() {
        final List<Movie> moviesStored = movieRepository.findAll();
        ArrayList<MovieToListDTO> responseDto_data = new ArrayList<>();

        for (Movie m : moviesStored) {
            responseDto_data.add(new MovieToListDTO(m.getImage(),m.getTitle(),m.getDate()));
        }

        return  new MovieListResponseDTO(responseDto_data);
    }


    public MovieResponseDTO createMovie(MovieRequestDTO requestDTO) {
        validateRequestFields(requestDTO);
        final Optional<Movie> optionalMovie = movieRepository.findByTitle(requestDTO.getTitle());

        if(optionalMovie.isPresent()){
            throw new ServiceException("Movie already exist");
        }

        final Movie movie = new Movie(requestDTO.getImage(),requestDTO.getTitle(),requestDTO.getDate(),requestDTO.getRating(),requestDTO.getCast());

        return movieRepository.save(movie).toDTO();
    }

    public MovieResponseDTO movieGetDetails(String id) {
        final Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isEmpty()){
            throw new ServiceException("Movie doesn't exist");
        }
        return  optionalMovie.get().toDTO();

    }

    private void validateRequestFields(MovieRequestDTO requestDTO) {
        if (requestDTO == null) {
            throw new ServiceException("request is empty or null");
        }
        if(requestDTO.getTitle() == null || requestDTO.getTitle().equals("")){
            throw  new ServiceException("title is empty or null");
        }
        if(requestDTO.getImage() == null || requestDTO.getImage().equals("")){
            throw  new ServiceException("image is empty or null");
        }
        if(requestDTO.getDate() == null ){
            throw  new ServiceException("date is null");
        }
        if(requestDTO.getRating() < 1 || requestDTO.getRating() > 5){
            throw  new ServiceException("rating is incorrect");
        }
    }
}
