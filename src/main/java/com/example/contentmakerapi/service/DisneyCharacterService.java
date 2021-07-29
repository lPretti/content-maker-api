package com.example.contentmakerapi.service;

import com.example.contentmakerapi.dto.character.CharacterResponseDTO;
import com.example.contentmakerapi.dto.character.CharacterRequestDTO;
import com.example.contentmakerapi.dto.character.CharacterListResponseDTO;
import com.example.contentmakerapi.dto.character.CharacterToListDTO;
import com.example.contentmakerapi.entity.DisneyCharacter;
import com.example.contentmakerapi.repository.DisneyCharacterRepository;
import com.example.contentmakerapi.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DisneyCharacterService {

    @Autowired
    DisneyCharacterRepository repository;

    public CharacterListResponseDTO listAllCharacters(){
        final List<DisneyCharacter> charactersStored = (List<DisneyCharacter>) repository.findAll();
        ArrayList<CharacterToListDTO> responseDto_data = new ArrayList<>();

        for (DisneyCharacter c:charactersStored) {
            responseDto_data.add(new CharacterToListDTO(c.getImage(),c.getName()));
        }

        return  new CharacterListResponseDTO(responseDto_data);
    }


    public CharacterResponseDTO createCharacter(CharacterRequestDTO requestDTO) {
        validateRequestFields(requestDTO);
        final Optional<DisneyCharacter> byName = repository.findByName(requestDTO.getName());
        if(byName.isPresent()){
            throw new ServiceException("The Disney Character already exist");
        }

        final DisneyCharacter character = new DisneyCharacter(requestDTO.getName(), requestDTO.getImage(), requestDTO.getAge(), requestDTO.getWeight(), requestDTO.getHistory());

        return repository.save(character).toDTO();
    }

    public CharacterResponseDTO updateCharacter(String id, CharacterRequestDTO requestDTO) {
        Optional<DisneyCharacter> optionalCharacter = repository.findByName(id);
        DisneyCharacter character;

         if(optionalCharacter.isEmpty()){
             character = new DisneyCharacter();
         }else{
             character = optionalCharacter.get();
             repository.deleteById(id);
         }

         character.setImage(requestDTO.getImage());
         character.setName(requestDTO.getName());
         character.setAge(requestDTO.getAge());
         character.setWeight(requestDTO.getWeight());
         character.setHistory(requestDTO.getHistory());
         character.setMovies(requestDTO.getMovies_names());

        return repository.save(character).toDTO();
    }


    public void delete(String id){
            repository.deleteById(id);
    }

    private void validateRequestFields(CharacterRequestDTO requestDTO) {
        if (requestDTO == null) {
            throw new ServiceException("request is empty or null");
        }
        if(requestDTO.getName() == null || requestDTO.getName().equals("")){
            throw  new ServiceException("name is empty or null");
        }
        if(requestDTO.getImage() == null || requestDTO.getImage().equals("")){
            throw  new ServiceException("image is empty or null");
        }
        if(requestDTO.getAge() < 0 ){
            throw  new ServiceException("age is incorrect");
        }
        if(requestDTO.getWeight() < 0.0 ){
            throw  new ServiceException("weigh is incorrect");
        }
        if(requestDTO.getHistory() == null || requestDTO.getHistory().equals("")){
            throw  new ServiceException("history is empty or null");
        }
    }
}
