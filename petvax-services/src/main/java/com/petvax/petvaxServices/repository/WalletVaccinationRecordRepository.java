package com.petvax.petvaxServices.repository;

import com.petvax.petvaxServices.entity.WalletVaccinationRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletVaccinationRecordRepository extends JpaRepository<WalletVaccinationRecordEntity, String> {
    List<WalletVaccinationRecordEntity> findVaccinationRecordByWalletId(String walletId);
}
