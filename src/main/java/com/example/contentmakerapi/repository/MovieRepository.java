package com.example.contentmakerapi.repository;

import com.example.contentmakerapi.entity.DisneyCharacter;
import com.example.contentmakerapi.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String> {
    Optional<Movie> findByTitle(String title);
}