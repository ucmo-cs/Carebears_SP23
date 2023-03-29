package com.petvax.petvaxServices.repository;

import com.petvax.petvaxServices.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetsRepository extends JpaRepository<PetEntity, String>{

    Optional<PetEntity> findByName(String name);

    List<PetEntity> findAll();

    List<PetEntity> findByOwnerID(String ownerID);

    Optional<PetEntity> findByUuid(String uuid);
}
