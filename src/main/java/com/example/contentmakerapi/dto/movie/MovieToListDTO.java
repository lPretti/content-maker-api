package com.example.contentmakerapi.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class MovieToListDTO {
    private String image;
    private String title;
    private LocalDate date;

    @Override
    public String toString() {
        return "Movie {" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
