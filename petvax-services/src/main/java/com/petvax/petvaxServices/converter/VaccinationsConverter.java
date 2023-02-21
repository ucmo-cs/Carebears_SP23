package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.entity.VaccinationEntity;
import com.petvax.petvaxServices.repository.VaccinationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VaccinationsConverter {

    private final VaccinationsRepository vaccinationsRepository;

    @Autowired
    public VaccinationsConverter(final VaccinationsRepository vaccinationsRepository) {
        this.vaccinationsRepository = vaccinationsRepository;
    }

    public VaccinationsResponse convertVaccinationsToVaccinationResponse(final VaccinationEntity vaccinationEntity) {

        // Creates response with returned value based upon request
        VaccinationsResponse.Builder vaccinationResponseBuilder = new VaccinationsResponse.Builder();

        vaccinationResponseBuilder.setName(vaccinationEntity.getName());
        vaccinationResponseBuilder.setType(vaccinationEntity.getType());
        vaccinationResponseBuilder.setAge(vaccinationEntity.getAge());
        vaccinationResponseBuilder.setFrequency(vaccinationEntity.getFrequency());
        vaccinationResponseBuilder.setSpecies(vaccinationEntity.getSpecies());
        vaccinationResponseBuilder.setCreatedDate(vaccinationEntity.getCreatedDate());

        return vaccinationResponseBuilder.build();
    }
}