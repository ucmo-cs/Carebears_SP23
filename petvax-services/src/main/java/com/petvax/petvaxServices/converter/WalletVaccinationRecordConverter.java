package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.VaccinationRecordResponse;
import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.dto.WalletVaccinationRecordResponse;
import com.petvax.petvaxServices.entity.VaccinationEntity;
import com.petvax.petvaxServices.entity.VaccinationRecordEntity;
import com.petvax.petvaxServices.entity.WalletVaccinationRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class WalletVaccinationRecordConverter {

    @Autowired
    private VaccinationsConverter vaccinationsConverter;

    public WalletVaccinationRecordResponse convertWalletVaccinationRecordToWalletVaccinationRecordResponse(final WalletVaccinationRecordEntity walletVaccinationRecordEntity) {
        WalletVaccinationRecordResponse.Builder walletVaccinationRecordResponseBuilder = new WalletVaccinationRecordResponse.Builder();

        // Adds vaccination details to response using the vaccinations response
        VaccinationEntity vaccination = walletVaccinationRecordEntity.getVaccinationEntity();
        VaccinationsResponse vaccinationsResponse = vaccinationsConverter.convertVaccinationsToVaccinationResponse(vaccination);
        walletVaccinationRecordResponseBuilder.setVacciantion(vaccinationsResponse);

        // Creates response with returned value based upon request
        walletVaccinationRecordResponseBuilder.setWalletId(walletVaccinationRecordEntity.getWalletId());
        walletVaccinationRecordResponseBuilder.setWalletVaccinationDate(walletVaccinationRecordEntity.getVaccinationDate());
        walletVaccinationRecordResponseBuilder.setActive(walletVaccinationRecordEntity.getActive());

        return walletVaccinationRecordResponseBuilder.build();
    }
}