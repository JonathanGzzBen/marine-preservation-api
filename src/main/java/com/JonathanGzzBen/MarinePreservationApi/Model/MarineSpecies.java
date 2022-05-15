package com.JonathanGzzBen.MarinePreservationApi.Model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    @Column(columnDefinition = "TEXT")
    private String biology;
    private String aliases; // Comma-separated aliases
    private String population;
    private String imageUrl;
}
