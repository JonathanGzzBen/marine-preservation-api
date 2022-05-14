package com.JonathanGzzBen.MarinePreservationApi.Controller;

import com.JonathanGzzBen.MarinePreservationApi.Model.MarineSpecies;
import com.JonathanGzzBen.MarinePreservationApi.Service.MarineSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/marinespecies")
public class MarineSpeciesController {
    private final MarineSpeciesService marineSpeciesService;

    @Autowired
    public MarineSpeciesController(MarineSpeciesService marineSpeciesService) {
        this.marineSpeciesService = marineSpeciesService;
    }

    @GetMapping
    public List<MarineSpecies> getMarineSpecies(@RequestParam(name = "limit", defaultValue = "0") int limit, @RequestParam(name="offset", defaultValue = "0") int offset) {
        return marineSpeciesService.getMarineSpecies(limit, offset);
    }

    @PostMapping
    public MarineSpecies registerNewMarineSpecies(@RequestBody MarineSpecies marineSpecies) {
        return marineSpeciesService.addNewMarineSpecies(marineSpecies);
    }

    @DeleteMapping("/{id}")
    public void deleteMarineSpecies(@PathVariable Long id) {
        marineSpeciesService.deleteMarineSpecies(id);
    }
}
