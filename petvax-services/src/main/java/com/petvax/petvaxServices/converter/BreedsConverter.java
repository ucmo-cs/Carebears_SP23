package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.BreedsResponse;
import com.petvax.petvaxServices.dto.SpeciesResponse;
import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.entity.BreedEntity;
import com.petvax.petvaxServices.entity.SpeciesEntity;
import com.petvax.petvaxServices.entity.VaccinationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.SystemException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public final class BreedsConverter {

    @Autowired
    private SpeciesConverter speciesConverter;

    public BreedsResponse convertBreedToBreedResponse(final BreedEntity breedEntity) {

        // Creates response with returned value based upon request
        BreedsResponse.Builder breedResponseBuilder = new BreedsResponse.Builder();

        breedResponseBuilder.setUuid(breedEntity.getUuid());
        breedResponseBuilder.setName(breedEntity.getName());

        // Adds species details to response using the vaccinations response
        SpeciesEntity species = breedEntity.getSpeciesEntity();
        SpeciesResponse speciesResponse = speciesConverter.convertSpeciesToSpeciesResponse(species);
        breedResponseBuilder.setSpecies(speciesResponse);

        return breedResponseBuilder.build();
    }

    /**
     * @param objects to be converted
     * @return
     */
    public List<BreedsResponse> convertBreedToBreedResponse(final List<BreedEntity> objects) throws SystemException {
        if (objects == null) {
            throw new SystemException("input was null");
        }
        return objects.stream().map(o -> convertBreedToBreedResponse(o)).collect(Collectors.toList());
    }
}