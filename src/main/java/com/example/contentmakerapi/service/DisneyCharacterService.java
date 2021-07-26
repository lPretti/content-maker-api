package com.example.contentmakerapi.service;

import com.example.contentmakerapi.dto.CharacterResponseDTO;
import com.example.contentmakerapi.dto.CharacterToListDTO;
import com.example.contentmakerapi.entity.DisneyCharacter;
import com.example.contentmakerapi.repository.DisneyCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisneyCharacterService {
    @Autowired
    DisneyCharacterRepository repository;

    public CharacterResponseDTO listAllCharacters(){
        ArrayList<CharacterToListDTO> result = new ArrayList<>();
        final List<DisneyCharacter> allCharacters = repository.findAll();

        for (DisneyCharacter c:allCharacters) {
            result.add(new CharacterToListDTO(c.getImage(),c.getName()));
        }

        return  new CharacterResponseDTO(result);
    }




}
