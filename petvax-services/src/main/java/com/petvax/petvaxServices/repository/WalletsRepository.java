package com.petvax.petvaxServices.repository;

import com.petvax.petvaxServices.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletsRepository extends JpaRepository<WalletEntity, String>{
    Optional<WalletEntity> findByWalletId(String walletId);
}
