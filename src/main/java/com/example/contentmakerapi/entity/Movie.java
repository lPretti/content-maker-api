package com.example.contentmakerapi.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
@Document(collection = "movies")
public class Movie {
    @Id
    private int _id;
    private String image;
    private String title;
    private Date date;
    private int rating;
    private ArrayList<DisneyCharacter> cast;


    public Movie(String image, String title, Date date, int rating) {
        this.image = image;
        this.title = title;
        this.date = date;
        this.rating = rating;
        this.cast = new ArrayList<>();
    }
}
