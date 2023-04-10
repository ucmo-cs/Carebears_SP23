package com.petvax.petvaxServices.repository;

import com.petvax.petvaxServices.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletsRepository extends JpaRepository<WalletEntity, String>{
    List<WalletEntity> findByPetId(String petId);
    Optional<WalletEntity> findByWalletId(String walletId);
}
