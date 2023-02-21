package com.petvax.petvaxServices.service;

import com.petvax.petvaxServices.converter.VaccinationsConverter;
import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.entity.VaccinationEntity;
import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.repository.VaccinationsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.SystemException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaccinationsService {

    private static final Logger LOG = LoggerFactory.getLogger(VaccinationsService.class);

    private final VaccinationsRepository vaccinationsRepository;

    private final VaccinationsConverter vaccinationsConverter;

    @Autowired
    public VaccinationsService(final VaccinationsRepository vaccinationsRepository,
                        final VaccinationsConverter vaccinationsConverter) {
        this.vaccinationsRepository = vaccinationsRepository;
        this.vaccinationsConverter = vaccinationsConverter;
    }

    /**
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    public VaccinationsResponse getVaccination(final String name) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the vacciantion object is null then it will throw the NotFoundException exception
        Optional<VaccinationEntity> vaccination = vaccinationsRepository.findByName(name);
        return vaccination.map(vaccinationsConverter::convertVaccinationsToVaccinationResponse).orElseThrow(() -> new NotFoundException("name not found: " + name));
    }

    /**
     * @param type
     * @return
     */
    public List<VaccinationsResponse> getVaccinationByType(final String type) throws SystemException {
        List<VaccinationsResponse> listTypes;
        List<VaccinationEntity> vaccinationTypes = vaccinationsRepository.findByType(type);

        // Convert multiple vaccinationTypes into a response containing a list of types
        listTypes = vaccinationsConverter.convertVaccinationsToVaccinationResponse(vaccinationTypes);
        return listTypes;
    }
}
