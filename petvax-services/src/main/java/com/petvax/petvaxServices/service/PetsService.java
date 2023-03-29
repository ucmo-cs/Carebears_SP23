package com.petvax.petvaxServices.service;

import com.petvax.petvaxServices.converter.PetsConverter;
import com.petvax.petvaxServices.dto.PetsResponse;
import com.petvax.petvaxServices.entity.PetEntity;
import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.repository.PetsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.SystemException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PetsService {
    private static final Logger LOG = LoggerFactory.getLogger(PetsService.class);

    private final PetsRepository petsRepository;

    private final PetsConverter petsConverter;

    @Autowired
    public PetsService(final PetsRepository petsRepository,
                               final PetsConverter petsConverter) {
        this.petsRepository = petsRepository;
        this.petsConverter = petsConverter;
    }

    /**
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    public PetsResponse getPet(final String name) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the pet object is null then it will throw the NotFoundException exception
        Optional<PetEntity> pet = petsRepository.findByName(name);
        return pet.map(petsConverter::convertPetsToPetResponse).orElseThrow(() -> new NotFoundException(String.format("name not found: [%s]", name)));
    }

    /**
     * @param uuid
     * @return
     */
    @Transactional(readOnly = true)
    public PetsResponse getPetByUuid(final String uuid) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the pet object is null then it will throw the NotFoundException exception
        Optional<PetEntity> pet = petsRepository.findByUuid(uuid);
        return pet.map(petsConverter::convertPetsToPetResponse).orElseThrow(() -> new NotFoundException(String.format("Id not found: [%s]", uuid)));
    }

    /**
     * @param speciesID
     * @return
     */
    @Transactional(readOnly = true)
    public PetsResponse getPetBySpeciesID(final String speciesID) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the pet object is null then it will throw the NotFoundException exception
        Optional<PetEntity> pet = petsRepository.findByUuid(speciesID);
        return pet.map(petsConverter::convertPetsToPetResponse).orElseThrow(() -> new NotFoundException(String.format("Id not found: [%s]", speciesID)));
    }

    /**
     * @param breedID
     * @return
     */
    @Transactional(readOnly = true)
    public PetsResponse getPetByBreedID(final String breedID) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the pet object is null then it will throw the NotFoundException exception
        Optional<PetEntity> pet = petsRepository.findByUuid(breedID);
        return pet.map(petsConverter::convertPetsToPetResponse).orElseThrow(() -> new NotFoundException(String.format("Id not found: [%s]", breedID)));
    }

    /**
     * @param ownerID
     * @return
     */
    @Transactional(readOnly = true)
    public List<PetsResponse> getPetByOwnerID(boolean active,
                                                                       final String ownerID) throws SystemException {

        List<PetEntity> petEntities = petsRepository.findByOwnerID(ownerID);

        // Checks if the list contains value or not
        // Throws an exception if the list is empty
        if (petEntities.isEmpty()) {
            throw new NotFoundException(String.format("No vaccination records found for pet with ownerID: [%s]", ownerID));
        }

        // Iterate through each pet to determine if 'active' is true or not
        // If true adds to the petStream variable. Otherwise, doesn't.
        Stream<PetEntity> petStream = petEntities.stream();
        if (active) {
            petStream = petStream.filter(petEntity -> petEntity.getActive());
        }

        return petStream
                .map(petsConverter::convertPetsToPetResponse)
                .collect(Collectors.toList());
    }

    /**
     * @param age
     * @return
     */
    @Transactional(readOnly = true)
    public PetsResponse getPetByAge(final String age) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the pet object is null then it will throw the NotFoundException exception
        Optional<PetEntity> pet = petsRepository.findByUuid(age);
        return pet.map(petsConverter::convertPetsToPetResponse).orElseThrow(() -> new NotFoundException(String.format("Id not found: [%s]", age)));
    }
}
