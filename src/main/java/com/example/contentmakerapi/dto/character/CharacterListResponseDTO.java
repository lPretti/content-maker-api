package com.example.contentmakerapi.dto.character;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class CharacterListResponseDTO {
    private List<?> characters;
}
