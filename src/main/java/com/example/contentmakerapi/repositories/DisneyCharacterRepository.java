package com.example.contentmakerapi.repositories;

import com.example.contentmakerapi.entities.DisneyCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DisneyCharacterRepository extends  MongoRepository<DisneyCharacter, String> {
   Optional<DisneyCharacter> findByName(String name);
   }
