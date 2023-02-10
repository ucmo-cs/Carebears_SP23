package com.petvax.vaccinations.repository;

import com.petvax.vaccinations.entity.VaccinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationsRepository extends JpaRepository<VaccinationEntity, Integer> {

    VaccinationEntity findByName(String name);

    List<VaccinationEntity> findAll();

}
