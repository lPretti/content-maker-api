package com.example.contentmakerapi.dto.movie;

import com.example.contentmakerapi.entity.DisneyCharacter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;


@AllArgsConstructor
@Setter
@Getter
public class MovieDTO {
    private int _id;
    private String image;
    private String title;
    private Date date;
    private int rating;
    private ArrayList<DisneyCharacter> cast;

}
