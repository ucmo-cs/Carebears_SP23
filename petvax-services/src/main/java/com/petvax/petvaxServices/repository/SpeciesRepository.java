package com.petvax.petvaxServices.repository;

import com.petvax.petvaxServices.entity.SpeciesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpeciesRepository extends JpaRepository<SpeciesEntity, String> {

    Optional<SpeciesEntity> getSpeciesBySpeciesName(String speciesName);

}
