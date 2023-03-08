package com.petvax.petvaxServices.service;

import com.petvax.petvaxServices.converter.VaccinationRecordConverter;
import com.petvax.petvaxServices.converter.VaccinationsConverter;
import com.petvax.petvaxServices.dto.VaccinationRecordResponse;
import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.entity.VaccinationEntity;
import com.petvax.petvaxServices.entity.VaccinationRecordEntity;
import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.repository.VaccinationRecordRepository;
import com.petvax.petvaxServices.repository.VaccinationsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.SystemException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VaccinationRecordService {

    private static final Logger LOG = LoggerFactory.getLogger(VaccinationsService.class);

    private final VaccinationRecordRepository vaccinationRecordRepository;

    private final VaccinationRecordConverter vaccinationRecordConverter;
    private String active;

    @Autowired
    public VaccinationRecordService(final VaccinationRecordRepository vaccinationRecordRepository,
                               final VaccinationRecordConverter vaccinationRecordConverter) {
        this.vaccinationRecordRepository = vaccinationRecordRepository;
        this.vaccinationRecordConverter = vaccinationRecordConverter;
    }

    /**
     * @param petId
     * @return
     */
    @Transactional(readOnly = true)
    public List<VaccinationRecordResponse> getVaccinationRecordByPetId(boolean active,
                                                                        final String petId) throws SystemException {

        List<VaccinationRecordEntity> vaccinationRecordEntities = vaccinationRecordRepository.findByPetId(petId);

        // Checks if the list contains value or not
        // Throws an exception if the list is empty
        if (vaccinationRecordEntities.isEmpty()) {
            throw new NotFoundException(String.format("No vaccination records found for pet with id: [%s]", petId));
        }

        // Iterate through each vaccination record to determine if 'active' is true or not
        // If true adds to the vaccinationRecordStream variable. Otherwise, doesn't.
        Stream<VaccinationRecordEntity> vaccinationRecordStream = vaccinationRecordEntities.stream();
        if (active) {
            vaccinationRecordStream = vaccinationRecordStream.filter(vaccinationRecordEntity -> vaccinationRecordEntity.getActive());
        }

        return vaccinationRecordStream
                .map(vaccinationRecordConverter::convertVaccinationRecordToVaccinationRecordResponse)
                .collect(Collectors.toList());
    }
}
