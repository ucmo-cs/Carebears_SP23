package com.petvax.petvaxServices.service;

import com.petvax.petvaxServices.converter.SpeciesConverter;
import com.petvax.petvaxServices.dto.SpeciesResponse;
import com.petvax.petvaxServices.entity.BreedEntity;
import com.petvax.petvaxServices.entity.SpeciesEntity;
import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.repository.SpeciesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SpeciesService {

    private static final Logger LOG = LoggerFactory.getLogger(SpeciesService.class);

    private final SpeciesRepository speciesRepository;
    private final SpeciesConverter speciesConverter;

    @Autowired
    public SpeciesService(SpeciesRepository speciesRepository, SpeciesConverter speciesConverter) {
        this.speciesRepository = speciesRepository;
        this.speciesConverter = speciesConverter;
    }

    /**
     * @param speciesName
     * @return
     */
    @Transactional(readOnly = true)
    public SpeciesResponse getSpeciesByName(String speciesName) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the Species object is null then it will throw the NotFoundException exception
        Optional<SpeciesEntity> species = speciesRepository.getSpeciesBySpeciesName(speciesName);
        return species.map(speciesConverter::convertSpeciesToSpeciesResponse).orElseThrow(() -> new NotFoundException(String.format("species not found: [%s]", speciesName)));
    }
}
