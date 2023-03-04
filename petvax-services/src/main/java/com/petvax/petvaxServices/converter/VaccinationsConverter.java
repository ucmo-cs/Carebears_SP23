package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.VaccinationsRequest;
import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.entity.VaccinationEntity;
import org.springframework.stereotype.Component;

import javax.transaction.SystemException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public final class VaccinationsConverter {

    public VaccinationsResponse convertVaccinationsToVaccinationResponse(final VaccinationEntity vaccinationEntity) {

        // Creates response with returned value based upon request
        VaccinationsResponse.Builder vaccinationResponseBuilder = new VaccinationsResponse.Builder();

        vaccinationResponseBuilder.setUuid(vaccinationEntity.getUuid());
        vaccinationResponseBuilder.setName(vaccinationEntity.getName());
        vaccinationResponseBuilder.setType(vaccinationEntity.getType());
        vaccinationResponseBuilder.setAge(vaccinationEntity.getAge());
        vaccinationResponseBuilder.setFrequency(vaccinationEntity.getFrequency());
        vaccinationResponseBuilder.setSpecies(vaccinationEntity.getSpecies());
        vaccinationResponseBuilder.setCreatedDate(vaccinationEntity.getCreatedDate());

        return vaccinationResponseBuilder.build();
    }

    /**
     * @param objects to be converted
     * @return
     */
    public List<VaccinationsResponse> convertVaccinationsToVaccinationResponse(final List<VaccinationEntity> objects) throws SystemException {
        if (objects == null) {
            throw new SystemException("input was null");
        }
        return objects.stream().map(o -> convertVaccinationsToVaccinationResponse(o)).collect(Collectors.toList());
    }

    public VaccinationEntity convertVaccinationRequestToVaccination(final VaccinationsRequest vaccinationsRequest) {
        VaccinationEntity vaccination = new VaccinationEntity();

        vaccination.setUuid(vaccinationsRequest.getUuid());
        vaccination.setName(vaccinationsRequest.getName());
        vaccination.setType(vaccinationsRequest.getType());
        vaccination.setAge(vaccinationsRequest.getAge());
        vaccination.setFrequency(vaccinationsRequest.getFrequency());
        vaccination.setSpecies(vaccinationsRequest.getSpecies());
        vaccination.setCreatedDate(vaccinationsRequest.getCreatedDate());

        return vaccination;
    }

}