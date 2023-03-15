package com.petvax.petvaxServices.service;

import com.petvax.petvaxServices.converter.VaccinationsConverter;
import com.petvax.petvaxServices.dto.VaccinationsRequest;
import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.entity.VaccinationEntity;
import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.repository.VaccinationsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.SystemException;
import java.util.List;
import java.util.Optional;

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
        return vaccination.map(vaccinationsConverter::convertVaccinationsToVaccinationResponse).orElseThrow(() -> new NotFoundException(String.format("name not found: [%s]", name)));
    }

    /**
     * @param uuid
     * @return
     */
    @Transactional(readOnly = true)
    public VaccinationsResponse getVaccinationByUuid(final String uuid) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the vacciantion object is null then it will throw the NotFoundException exception
        Optional<VaccinationEntity> vaccination = vaccinationsRepository.findByUuid(uuid);
        return vaccination.map(vaccinationsConverter::convertVaccinationsToVaccinationResponse).orElseThrow(() -> new NotFoundException(String.format("Id not found: [%s]", uuid)));
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

    /**
     * @param vaccinationRequest
     */
    @Transactional
    public VaccinationsResponse createVaccination(final VaccinationsRequest vaccinationRequest) {
        VaccinationEntity vaccination = vaccinationsConverter.convertVaccinationRequestToVaccination(vaccinationRequest);
        vaccination = vaccinationsRepository.save(vaccination);
        return vaccinationsConverter.convertVaccinationsToVaccinationResponse(vaccination);
    }

    /**
     * @param vaccinationRequest
     */
    @Transactional
    public VaccinationsResponse updateVaccination(final VaccinationsRequest vaccinationRequest, final String vaccinationId) {
        VaccinationsResponse existingVaccination = getVaccinationByUuid(vaccinationId);

        // Throws NotFoundException, if no vaccinationId is passed
        if (vaccinationId == null) {
            throw new NotFoundException(String.format("Could not find vaccination with id: [%s]", vaccinationId));
        }

        // If no value is passed in the vaccination request, then the existing value (obtained from appropriate VaccinationResponse)
        // will be used in PUT request. Otherwise, will use the updated value to update the value with value passed in the vaccination request
        VaccinationsRequest updatedVaccination = new VaccinationsRequest.Builder()
                .setUuid(vaccinationId)
                .setName(vaccinationRequest.getName() == null ? existingVaccination.getName() : vaccinationRequest.getName())
                .setType(vaccinationRequest.getType() == null ? existingVaccination.getType() : vaccinationRequest.getType())
                .setAge(vaccinationRequest.getAge() == null ? existingVaccination.getAge() : vaccinationRequest.getAge())
                .setFrequency(vaccinationRequest.getFrequency() == null ? existingVaccination.getFrequency() : vaccinationRequest.getFrequency())
                .setSpecies(vaccinationRequest.getSpecies() == null ? existingVaccination.getSpecies() : vaccinationRequest.getSpecies())
                .build();

        VaccinationEntity updatedVaccinationEntity = vaccinationsConverter.convertVaccinationRequestToVaccination(updatedVaccination);

        VaccinationEntity savedVaccination = vaccinationsRepository.save(updatedVaccinationEntity);
        return vaccinationsConverter.convertVaccinationsToVaccinationResponse(savedVaccination);

    }

    /**
     *
     */
    @Transactional
    public void deleteVaccination(final String vaccinationId) {
        // Attempts to delete vaccination using the passed vaccinationId
        // If an empty result is returned (exception for no value) i is caught
        // and NOtFoundException is thrown to display message to user
        try {
            vaccinationsRepository.deleteById(vaccinationId);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(String.format("Vaccination with id [%s] not found",
                    vaccinationId));
        }
    }
}
