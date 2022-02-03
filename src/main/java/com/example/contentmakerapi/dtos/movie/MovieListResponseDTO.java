package com.example.contentmakerapi.dtos.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class MovieListResponseDTO {
    private List<?> movies;
}
