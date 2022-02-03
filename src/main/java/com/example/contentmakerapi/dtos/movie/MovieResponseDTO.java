package com.example.contentmakerapi.dtos.movie;

import com.example.contentmakerapi.entities.DisneyCharacter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@Setter
@Getter
public class MovieResponseDTO {
    private String _id;
    private String image;
    private String title;
    private LocalDate date;
    private int rating;
    private ArrayList<DisneyCharacter> cast;

    @Override
    public String toString() {
        return "MovieResponseDTO{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", rating=" + rating +
                ", cast=" + cast +
                '}';
    }
}
