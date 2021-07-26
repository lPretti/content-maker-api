package com.example.contentmakerapi.repository;

import com.example.contentmakerapi.entity.DisneyCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DisneyCharacterRepository extends MongoRepository<DisneyCharacter,String> {
}
