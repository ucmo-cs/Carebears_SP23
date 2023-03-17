package com.petvax.petvaxServices.repository;

import com.petvax.petvaxServices.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnersRepository extends JpaRepository<OwnerEntity, String> {

    Optional<OwnerEntity> findOwnerByUserName(String username);

}
