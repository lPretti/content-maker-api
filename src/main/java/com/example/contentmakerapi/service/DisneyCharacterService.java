package com.example.contentmakerapi.service;

import com.example.contentmakerapi.dto.CharacterDTO;
import com.example.contentmakerapi.dto.CharacterRequestDTO;
import com.example.contentmakerapi.dto.ListCharacterResponseDTO;
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

    public ListCharacterResponseDTO listAllCharacters(){
        ArrayList<CharacterToListDTO> result = new ArrayList<>();
        final List<DisneyCharacter> charactersStored = repository.findAll();

        for (DisneyCharacter c:charactersStored) {
            result.add(new CharacterToListDTO(c.getImage(),c.getName()));
        }
        return  new ListCharacterResponseDTO(result);
    }


    public CharacterDTO createCharacter(CharacterRequestDTO requestDTO) {
        validateRequestFields(requestDTO);
        if(repository.findByName(requestDTO.getName()).isPresent()){
            throw new CharacterServiceException("The Disney Character already exist");
        }

        final DisneyCharacter character = new DisneyCharacter(requestDTO.getName(), requestDTO.getImage(), requestDTO.getAge(), requestDTO.getWeight(), requestDTO.getHistory());

        return repository.save(character).toDTO();
    }

    private void validateRequestFields(CharacterRequestDTO requestDTO) {
        if (requestDTO == null) {
            throw new CharacterServiceException("request is empty or null");
        }
        if(requestDTO.getName() == null || requestDTO.getName().equals("")){
            throw  new CharacterServiceException("name is empty or null");
        }
        if(requestDTO.getImage() == null || requestDTO.getImage().equals("")){
            throw  new CharacterServiceException("image is empty or null");
        }
        if(requestDTO.getAge() < 0 ){
            throw  new CharacterServiceException("age is incorrect");
        }
        if(requestDTO.getWeight() < 0.0 ){
            throw  new CharacterServiceException("weigh is incorrect");
        }
        if(requestDTO.getHistory() == null || requestDTO.getHistory().equals("")){
            throw  new CharacterServiceException("history is empty or null");
        }
    }
}
