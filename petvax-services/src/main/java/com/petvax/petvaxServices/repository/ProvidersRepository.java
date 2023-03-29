package com.petvax.petvaxServices.repository;

import com.petvax.petvaxServices.entity.OwnerEntity;
import com.petvax.petvaxServices.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProvidersRepository extends JpaRepository<ProviderEntity, String> {

    Optional<ProviderEntity> getProviderByName(String name);

    List<ProviderEntity> getProvidersByCity(String city);

}
