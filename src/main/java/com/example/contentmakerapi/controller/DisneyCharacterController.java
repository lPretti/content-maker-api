package com.example.contentmakerapi.controller;

import com.example.contentmakerapi.dto.CharacterRequestDTO;
import com.example.contentmakerapi.service.DisneyCharacterService;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.PUT, value ="/characters/{id}")
    public ResponseEntity<?> updateCharacter(@RequestBody CharacterRequestDTO requestDTO, @PathVariable("id") String id){
        return ResponseEntity.ok(service.updateCharacter(id, requestDTO));
    }

    @RequestMapping( method = RequestMethod.DELETE, value ="/characters/{id}")
    public void deleteCharacter(@PathVariable("id") String id){
        service.delete(id);
    }
}
