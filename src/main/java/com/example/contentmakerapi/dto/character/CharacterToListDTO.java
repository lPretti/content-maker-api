package com.example.contentmakerapi.dto.character;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CharacterToListDTO {
    private String image;
    private String name;

    @Override
    public String toString() {
        return "Character{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
