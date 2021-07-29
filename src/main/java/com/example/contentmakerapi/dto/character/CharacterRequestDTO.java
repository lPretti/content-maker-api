package com.example.contentmakerapi.dto.character;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Setter
@Getter
public class CharacterRequestDTO {
    private String image;
    private String name;
    private int age;
    private double weight;
    private String history;
    private ArrayList<String> movies_names;
}
