package com.petvax.petvaxServices.repository;

import com.petvax.petvaxServices.entity.VaccinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VaccinationsRepository extends JpaRepository<VaccinationEntity, Integer> {

    Optional<VaccinationEntity> findByName(String name);

    List<VaccinationEntity> findByType(String type);

    List<VaccinationEntity> findAll();

}
