package com.JonathanGzzBen.MarinePreservationApi.Service;

import com.JonathanGzzBen.MarinePreservationApi.Model.MarineSpecies;
import com.JonathanGzzBen.MarinePreservationApi.Repository.MarineSpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public MarineSpecies addNewMarineSpecies(MarineSpecies marineSpecies) {
        var marineSpeciesOptional = marineSpeciesRepository.findByScientificName(marineSpecies.getScientificName());
        if(marineSpeciesOptional.isPresent()) {
            throw new IllegalStateException("Scientific Name taken");
        }
        return marineSpeciesRepository.save(marineSpecies);
    }
}
