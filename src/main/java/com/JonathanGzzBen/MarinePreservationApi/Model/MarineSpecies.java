package com.JonathanGzzBen.MarinePreservationApi.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class MarineSpecies {
    @Id
    @SequenceGenerator(
            name = "marine_species_sequence",
            sequenceName = "marine_species_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "marine_species_sequence"
    )
    private Long id;
    private String scientificName;
    private String biology;
    private String aliases; // Comma-separated aliases
    private String population;
    private String imageUrl;
}
