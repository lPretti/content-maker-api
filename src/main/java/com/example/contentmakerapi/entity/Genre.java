package com.example.contentmakerapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Setter
@Getter
@Document(collection = "genre")
public class Genre {
    @Id
    private String _id;
    private String name;
    private String image;
    private ArrayList<Movie> movies;

    public Genre(String name, String image, ArrayList<Movie> movies) {
        this.name = name;
        this.image = image;
        this.movies = movies;
    }
}
