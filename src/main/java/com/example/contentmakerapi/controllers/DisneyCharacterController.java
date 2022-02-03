package com.example.contentmakerapi.controllers;

import com.example.contentmakerapi.dtos.character.CharacterRequestDTO;
import com.example.contentmakerapi.services.DisneyCharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DisneyCharacterController {

    private DisneyCharacterService service;

    public DisneyCharacterController(DisneyCharacterService service) {
        this.service = service;
    }

    @GetMapping("/characters")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.listAllCharacters());
    }

    @PostMapping( value = "/characters")
    public ResponseEntity<?> createCharacter(@RequestBody CharacterRequestDTO requestDTO){
        return ResponseEntity.ok(service.createCharacter(requestDTO));
    }

    @CrossOrigin("http://localhost:8080/")
    @PutMapping(value ="/characters/{id}")
    public ResponseEntity<?> updateCharacter(@RequestBody CharacterRequestDTO requestDTO, @PathVariable("id") String id){
        return ResponseEntity.ok(service.updateCharacter(id, requestDTO));
    }

    @DeleteMapping(value ="/characters/{id}")
    public void deleteCharacter(@PathVariable("id") String id){
        service.delete(id);
    }

    @GetMapping("/characters/details")
    public ResponseEntity<?>getCharacterDetails(@RequestBody String id){
        return ResponseEntity.ok(service.getCharactersDetails(id));
    }
}
