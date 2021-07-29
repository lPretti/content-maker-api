package com.example.contentmakerapi.dto.movie;

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
