package com.example.contentmakerapi.repository;

import com.example.contentmakerapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

   User findByEmail(String email);
}
