package com.JonathanGzzBen.MarinePreservationApi.Service;

import com.JonathanGzzBen.MarinePreservationApi.Model.MarineSpecies;

import java.util.List;

public interface MarineSpeciesService {
    List<MarineSpecies> getMarineSpecies();

    MarineSpecies addNewMarineSpecies(MarineSpecies marineSpecies);

    void deleteMarineSpecies(Long id);
}
