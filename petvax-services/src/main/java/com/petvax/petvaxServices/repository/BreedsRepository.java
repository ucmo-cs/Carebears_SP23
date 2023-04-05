package com.petvax.petvaxServices.repository;

import com.petvax.petvaxServices.entity.BreedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BreedsRepository extends JpaRepository<BreedEntity, String> {

    Optional<BreedEntity> getBreedByName(String name);

}
