package com.example.contentmakerapi.repositories;

import com.example.contentmakerapi.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String> {
    Optional<Movie> findByTitle(String title);
}