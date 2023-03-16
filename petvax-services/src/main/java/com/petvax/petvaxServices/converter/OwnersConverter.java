package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.OwnersResponse;
import com.petvax.petvaxServices.entity.OwnerEntity;
import org.springframework.stereotype.Component;

@Component
public final class OwnersConverter {

    public OwnersResponse convertOwnerToOwnerResponse(final OwnerEntity ownerEntity) {

        // Creates response with returned value based upon request
        OwnersResponse.Builder ownerResponseBuilder = new OwnersResponse.Builder();

        ownerResponseBuilder.setUUID(ownerEntity.getUuid());
        ownerResponseBuilder.setFName(ownerEntity.getFname());
        ownerResponseBuilder.setLName(ownerEntity.getLname());
        ownerResponseBuilder.setAddress1(ownerEntity.getAddress1());
        ownerResponseBuilder.setAddress2(ownerEntity.getAddress2());
        ownerResponseBuilder.setCity(ownerEntity.getCity());
        ownerResponseBuilder.setState(ownerEntity.getState());
        ownerResponseBuilder.setZipCode(ownerEntity.getZipCode());
        ownerResponseBuilder.setEmail(ownerEntity.getEmail());
        ownerResponseBuilder.setCreatedDate(ownerEntity.getCreatedDate());

        return ownerResponseBuilder.build();
    }
}