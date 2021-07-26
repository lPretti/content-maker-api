package com.example.contentmakerapi.service;

import com.example.contentmakerapi.dto.CharacterResponseDTO;
import com.example.contentmakerapi.entity.DisneyCharacter;
import com.example.contentmakerapi.repository.DisneyCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisneyCharacterService {
    @Autowired
    DisneyCharacterRepository repository;

    public CharacterResponseDTO listAllCharacters(){

        final List<DisneyCharacter> all = repository.findAll();

        return  new CharacterResponseDTO(null);
    }




}
