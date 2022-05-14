package com.JonathanGzzBen.MarinePreservationApi.Repository;

import com.JonathanGzzBen.MarinePreservationApi.Model.MarineSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarineSpeciesRepository extends JpaRepository<MarineSpecies, Long> {
}
