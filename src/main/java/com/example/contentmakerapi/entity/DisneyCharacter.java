package com.example.contentmakerapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Setter
@Getter
@Document(collection = "characters")
public class DisneyCharacter {
    @Id
    private String _id;
    private String name;
    private int age;
    private double weight;
    private String history;
    private ArrayList <Movie> movies;

    public DisneyCharacter(String name, int age, double weight, String history) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.movies = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "DisneyCharacter{" +
                "name='" + name + '\'' +
                ", history='" + history + '\'' +
                '}';
    }


}
