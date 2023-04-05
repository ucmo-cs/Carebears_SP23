package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.VaccinationRecordResponse;
import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.entity.VaccinationEntity;
import com.petvax.petvaxServices.entity.VaccinationRecordEntity;

import com.petvax.petvaxServices.repository.VaccinationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class VaccinationRecordConverter {

    @Autowired
    private VaccinationsConverter vaccinationsConverter;

    public VaccinationRecordResponse convertVaccinationRecordToVaccinationRecordResponse(final VaccinationRecordEntity vaccinationRecordEntity) {
        VaccinationRecordResponse.Builder vaccinationRecordResponseBuilder = new VaccinationRecordResponse.Builder();

        // Adds vaccination details to response using the vaccinations response
        VaccinationEntity vaccination = vaccinationRecordEntity.getVaccinationEntity();
        VaccinationsResponse vaccinationsResponse = vaccinationsConverter.convertVaccinationsToVaccinationResponse(vaccination);
        vaccinationRecordResponseBuilder.setVacciantion(vaccinationsResponse);

        // Creates response with returned value based upon request
        vaccinationRecordResponseBuilder.setVaccinationDate(vaccinationRecordEntity.getVaccinationDate());
        vaccinationRecordResponseBuilder.setProvider(vaccinationRecordEntity.getProviderEntity());
        vaccinationRecordResponseBuilder.setActive(vaccinationRecordEntity.getActive());

        return vaccinationRecordResponseBuilder.build();
    }
}