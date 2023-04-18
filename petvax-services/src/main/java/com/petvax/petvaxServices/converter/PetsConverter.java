package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.BreedsResponse;
import com.petvax.petvaxServices.dto.PetsResponse;
import com.petvax.petvaxServices.dto.SpeciesResponse;
import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.entity.BreedEntity;
import com.petvax.petvaxServices.entity.PetEntity;
import com.petvax.petvaxServices.entity.SpeciesEntity;
import com.petvax.petvaxServices.entity.VaccinationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetsConverter {

    @Autowired
    private SpeciesConverter speciesConverter;

    @Autowired
    private BreedsConverter breedsConverter;

    public PetsResponse convertPetsToPetResponse(final PetEntity petEntity) {

        // Creates response with returned value based upon request
        PetsResponse.Builder petResponseBuilder = new PetsResponse.Builder();

        // Adds species details to response using the species response
        SpeciesEntity species = petEntity.getSpeciesEntity();
        SpeciesResponse speciesResponse = speciesConverter.convertSpeciesToSpeciesResponse(species);
        petResponseBuilder.setSpecies(speciesResponse);

        // Adds breed details to response using the breed response
        BreedEntity breed = petEntity.getBreedEntity();
        BreedsResponse breedsResponse = breedsConverter.convertBreedToBreedResponse(breed);
        petResponseBuilder.setBreed(breedsResponse);

        // Creates response with returned value based upon request
        petResponseBuilder.setUuid(petEntity.getUuid());
        petResponseBuilder.setName(petEntity.getName());
        petResponseBuilder.setOwnerID(petEntity.getOwnerID());
        petResponseBuilder.setAge(petEntity.getAge());
        petResponseBuilder.setActive(petEntity.getActive());

        return petResponseBuilder.build();
    }
}
