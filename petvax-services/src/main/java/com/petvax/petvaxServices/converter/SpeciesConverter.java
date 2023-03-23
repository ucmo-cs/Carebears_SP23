package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.SpeciesResponse;
import com.petvax.petvaxServices.entity.SpeciesEntity;
import org.springframework.stereotype.Component;

@Component
public final class SpeciesConverter {

    public SpeciesResponse convertSpeciesToSpeciesResponse(SpeciesEntity speciesEntity) {
        // Creates response with returned value based upon request
        SpeciesResponse.Builder specieResponseBuilder = new SpeciesResponse.Builder();

        specieResponseBuilder.setUuid(speciesEntity.getUuid());
        specieResponseBuilder.setSpeciesName(speciesEntity.getSpeciesName());

        return specieResponseBuilder.build();
    }

}