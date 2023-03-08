package com.petvax.petvaxServices.repository;

import com.petvax.petvaxServices.entity.VaccinationRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationRecordRepository extends JpaRepository<VaccinationRecordEntity, String> {
    List<VaccinationRecordEntity> findByPetId(String petId);
}
