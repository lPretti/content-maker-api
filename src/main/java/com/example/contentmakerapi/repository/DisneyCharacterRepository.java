package com.example.contentmakerapi.repository;

import com.example.contentmakerapi.entity.DisneyCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DisneyCharacterRepository extends  MongoRepository<DisneyCharacter, String> {
   Optional<DisneyCharacter> findByName(String name);
   }
