package com.JonathanGzzBen.MarinePreservationApi.Repository;

import com.JonathanGzzBen.MarinePreservationApi.Model.MarineSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarineSpeciesRepository extends JpaRepository<MarineSpecies, Long> {
    @Query("SELECT ms FROM MarineSpecies ms WHERE ms.scientificName = ?1")
    Optional<MarineSpecies> findByScientificName(String scientificName);
}
