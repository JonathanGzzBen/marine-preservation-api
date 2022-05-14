package com.JonathanGzzBen.MarinePreservationApi.Service;

import com.JonathanGzzBen.MarinePreservationApi.Model.MarineSpecies;
import com.JonathanGzzBen.MarinePreservationApi.Repository.MarineSpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarineSpeciesServiceJpa  implements MarineSpeciesService{
    private final MarineSpeciesRepository marineSpeciesRepository;

    @Autowired
    public MarineSpeciesServiceJpa(MarineSpeciesRepository marineSpeciesRepository) {
        this.marineSpeciesRepository = marineSpeciesRepository;
    }

    @Override
    public List<MarineSpecies> getMarineSpecies() {
        return marineSpeciesRepository.findAll();
    }
}
