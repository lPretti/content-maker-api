package com.example.contentmakerapi.repository;

import com.example.contentmakerapi.entity.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String>{
    Optional<UserModel> findByUsername(String username);
}
