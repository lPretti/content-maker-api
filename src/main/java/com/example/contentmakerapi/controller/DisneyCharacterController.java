package com.example.contentmakerapi.controller;

import com.example.contentmakerapi.dto.CharacterRequestDTO;
import com.example.contentmakerapi.service.DisneyCharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DisneyCharacterController {
    @Autowired
    DisneyCharacterService service;

    @GetMapping("/characters")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.listAllCharacters());
    }

    @PostMapping( value = "/characters")
    public ResponseEntity<?> createCharacter(@RequestBody CharacterRequestDTO requestDTO){
        return ResponseEntity.ok(service.createCharacter(requestDTO));
    }

    @PutMapping(value ="/characters/{id}")
    public ResponseEntity<?> updateCharacter(@PathVariable String name,@RequestBody CharacterRequestDTO requestDTO){
        return ResponseEntity.ok(service.updateCharacter(name, requestDTO));
    }

    @DeleteMapping(value = "/characters/{id}")
    public void deleteCharacter(@PathVariable String id){
        service.delete(id);
    }
}
