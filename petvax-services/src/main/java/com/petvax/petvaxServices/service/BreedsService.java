package com.petvax.petvaxServices.service;

import com.petvax.petvaxServices.converter.BreedsConverter;
import com.petvax.petvaxServices.dto.BreedsResponse;
import com.petvax.petvaxServices.entity.BreedEntity;
import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.repository.BreedsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BreedsService {

    private static final Logger LOG = LoggerFactory.getLogger(BreedsService.class);

    private final BreedsRepository breedsRepository;
    private final BreedsConverter breedsConverter;

    @Autowired
    public BreedsService(BreedsRepository breedsRepository, BreedsConverter breedsConverter) {
        this.breedsRepository = breedsRepository;
        this.breedsConverter = breedsConverter;
    }

    /**
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    public BreedsResponse getBreedByName(final String name) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the Breed object is null then it will throw the NotFoundException exception
        Optional<BreedEntity> breed = breedsRepository.getBreedByName(name);
        return breed.map(breedsConverter::convertBreedToBreedResponse).orElseThrow(() -> new NotFoundException(String.format("name not found: [%s]", name)));
    }
}
