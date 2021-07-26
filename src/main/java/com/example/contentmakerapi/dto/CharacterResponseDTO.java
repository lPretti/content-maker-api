package com.example.contentmakerapi.dto;

import com.example.contentmakerapi.entity.DisneyCharacter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class CharacterResponseDTO {
    private List<?> characters;
}
