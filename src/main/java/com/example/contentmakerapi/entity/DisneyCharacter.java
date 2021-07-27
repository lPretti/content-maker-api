package com.example.contentmakerapi.entity;

import com.example.contentmakerapi.dto.CharacterDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@NoArgsConstructor
@Setter
@Getter
@Document(collection = "characters")
public class DisneyCharacter {
    @Id
    private String _id;
    private String name;
    private String image;
    private int age;
    private double weight;
    private String history;
    private ArrayList <String> movies;

    public DisneyCharacter(String name, String image, int age, double weight, String history) {
        this.name = name;
        this.image = image;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.movies = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "DisneyCharacter{" +
                "name='" + name + '\'' +
                ", history='" + history + '\'' +
                '}';
    }

    public CharacterDTO toDTO(){
        return new CharacterDTO(
          this._id,
          this.name,
          this.image,
          this.age,
          this.weight,
          this.history,
          this.movies
        );
    }


}
