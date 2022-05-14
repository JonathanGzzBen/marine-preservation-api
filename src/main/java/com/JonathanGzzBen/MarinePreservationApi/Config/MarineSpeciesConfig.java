package com.JonathanGzzBen.MarinePreservationApi.Config;

import com.JonathanGzzBen.MarinePreservationApi.Model.MarineSpecies;
import com.JonathanGzzBen.MarinePreservationApi.Repository.MarineSpeciesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MarineSpeciesConfig {
    @Bean
    CommandLineRunner commandLineRunner(MarineSpeciesRepository marineSpeciesRepository) {
        return args -> marineSpeciesRepository.saveAll(List.of(
                new MarineSpecies(1L, "Scientific Name 1", "Biology 1", "Alias 1, Alias 2", "Population 1", "Image URL 1"),
                new MarineSpecies(2L, "Scientific Name 2", "Biology 2", "Alias 3, Alias 4", "Population 2", "Image URL 2")
        ));
    }
}
