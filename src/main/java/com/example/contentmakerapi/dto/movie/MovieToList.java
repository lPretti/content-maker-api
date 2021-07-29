package com.example.contentmakerapi.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class MovieToList {
    private String image;
    private String title;
    private Date date;
}
