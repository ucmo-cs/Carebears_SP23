package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.VaccinationsRequest;
import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.entity.VaccinationEntity;
import com.petvax.petvaxServices.repository.VaccinationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.SystemException;
import java.util.List;
import java.util.stream.Collectors;

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

}