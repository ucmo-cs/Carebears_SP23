package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.PetsResponse;
import com.petvax.petvaxServices.entity.PetEntity;
import org.springframework.stereotype.Component;

@Component
public class PetsConverter {

    public PetsResponse convertPetsToPetResponse(final PetEntity petEntity) {

        // Creates response with returned value based upon request
        PetsResponse.Builder petResponseBuilder = new PetsResponse.Builder();

        petResponseBuilder.setUuid(petEntity.getUuid());
        petResponseBuilder.setName(petEntity.getName());
        petResponseBuilder.setSpeciesID(petEntity.getSpeciesID());
        petResponseBuilder.setBreedID(petEntity.getBreedID());
        petResponseBuilder.setOwnerID(petEntity.getOwnerID());
        petResponseBuilder.setAge(petEntity.getAge());
        petResponseBuilder.setActive(petEntity.getActive());

        return petResponseBuilder.build();
    }
}
