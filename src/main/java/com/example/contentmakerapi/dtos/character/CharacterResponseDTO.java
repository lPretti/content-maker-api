package com.example.contentmakerapi.dtos.character;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Setter
@Getter
public class CharacterResponseDTO {
    private String _id;
    private String name;
    private String image;
    private int age;
    private double weight;
    private String history;
    private ArrayList<String> movies;

    public CharacterResponseDTO(String _id, String name, String image, int age, double weight, String history, ArrayList<String> movies) {
        this._id = _id;
        this.name = name;
        this.image = image;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "CharacterResponseDTO{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", history='" + history + '\'' +
                ", movies=" + movies +
                '}';
    }
}
