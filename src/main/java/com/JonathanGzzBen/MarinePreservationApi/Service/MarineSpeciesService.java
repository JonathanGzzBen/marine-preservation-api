package com.JonathanGzzBen.MarinePreservationApi.Service;

import com.JonathanGzzBen.MarinePreservationApi.Model.MarineSpecies;

import java.util.List;

public interface MarineSpeciesService {
    List<MarineSpecies> getMarineSpecies(int limit, int offset);

    MarineSpecies addNewMarineSpecies(MarineSpecies marineSpecies);

    void deleteMarineSpecies(Long id);

    List<MarineSpecies> getMarineSpeciesByAlias(String alias);
}
