package com.JonathanGzzBen.MarinePreservationApi.Service;

import com.JonathanGzzBen.MarinePreservationApi.Model.MarineSpecies;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarineSpeciesServiceJpa  implements MarineSpeciesService{

    @Override
    public List<MarineSpecies> getMarineSpecies() {
        return List.of(
                new MarineSpecies(1L, "comes", "comes", new String[]{"1", "2"}, "population", "imageUrl")
        );
    }
}
