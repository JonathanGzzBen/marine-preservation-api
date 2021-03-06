package com.JonathanGzzBen.MarinePreservationApi.Service;

import com.JonathanGzzBen.MarinePreservationApi.Model.MarineSpecies;
import com.JonathanGzzBen.MarinePreservationApi.Repository.MarineSpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarineSpeciesServiceJpa implements MarineSpeciesService {
    private final MarineSpeciesRepository marineSpeciesRepository;

    @Autowired
    public MarineSpeciesServiceJpa(MarineSpeciesRepository marineSpeciesRepository) {
        this.marineSpeciesRepository = marineSpeciesRepository;
    }

    @Override
    public List<MarineSpecies> getMarineSpecies(int limit, int offset) {
        if (!(limit == 0 && offset == 0)) {
            return marineSpeciesRepository.findAll(PageRequest.of(offset, limit, Sort.by(Sort.Direction.ASC, "id"))).getContent();
        }
        return marineSpeciesRepository.findAll();
    }

    @Override
    public MarineSpecies addNewMarineSpecies(MarineSpecies marineSpecies) {
        var marineSpeciesOptional = marineSpeciesRepository.findByScientificName(marineSpecies.getScientificName());
        if (marineSpeciesOptional.isPresent()) {
            throw new IllegalStateException("Scientific Name taken");
        }
        return marineSpeciesRepository.save(marineSpecies);
    }

    @Override
    public void deleteMarineSpecies(Long id) {
        marineSpeciesRepository.deleteById(id);
    }

    @Override
    public List<MarineSpecies> getMarineSpeciesByAlias(String alias) {
        return marineSpeciesRepository.findByAlias(alias);
    }
}
