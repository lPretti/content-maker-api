package com.example.contentmakerapi.dto;

import com.example.contentmakerapi.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor

@Setter
@Getter
public class CharacterDTO {
    private String _id;
    private String name;
    private String image;
    private int age;
    private double weight;
    private String history;
    private ArrayList<Movie> movies;

    public CharacterDTO(String _id, String name, String image, int age, double weight, String history, ArrayList<Movie> movies) {
        this._id = _id;
        this.name = name;
        this.image = image;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.movies = movies;
    }
}
