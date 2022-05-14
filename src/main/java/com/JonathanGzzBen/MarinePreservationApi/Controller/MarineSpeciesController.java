package com.JonathanGzzBen.MarinePreservationApi.Controller;

import com.JonathanGzzBen.MarinePreservationApi.Model.MarineSpecies;
import com.JonathanGzzBen.MarinePreservationApi.Service.MarineSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarineSpeciesController {
    private final MarineSpeciesService marineSpeciesService;

    @Autowired
    public MarineSpeciesController(MarineSpeciesService marineSpeciesService) {
        this.marineSpeciesService = marineSpeciesService;
    }

    @GetMapping
    public List<MarineSpecies> getSpecies() {
        return marineSpeciesService.getMarineSpecies();
    }
}
