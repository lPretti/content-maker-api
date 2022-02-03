package com.example.contentmakerapi.dtos.movie;

import com.example.contentmakerapi.entities.DisneyCharacter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovieRequestDTO {
    private String image;
    private String title;
    private LocalDate date;
    private int rating;
    private ArrayList<DisneyCharacter> cast;
}
