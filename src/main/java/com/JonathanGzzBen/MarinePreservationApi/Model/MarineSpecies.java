package com.JonathanGzzBen.MarinePreservationApi.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarineSpecies {
    private Long id;
    private String scientificName;
    private String biology;
    private String[] aliases;
    private String population;
    private String imageUrl;
}
