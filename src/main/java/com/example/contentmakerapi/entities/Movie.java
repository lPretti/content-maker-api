package com.example.contentmakerapi.entities;

import com.example.contentmakerapi.dtos.movie.MovieResponseDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;

@Setter
@Getter
@Document(collection = "movies")
public class Movie {
    @Id
    private String _id;
    private String image;
    private String title;
    private LocalDate date;
    private int rating;
    private ArrayList<DisneyCharacter> cast;

    public Movie(String image, String title, LocalDate date, int rating, ArrayList<DisneyCharacter> cast) {

        this.image = image;
        this.title = title;
        this.date = date;
        this.rating = rating;
        this.cast = cast;
    }

    public MovieResponseDTO toDTO(){
        return new MovieResponseDTO(
                this._id,
                this.image,
                this.title,
                this.date,
                this.rating,
                this.cast
        );
    }
}
