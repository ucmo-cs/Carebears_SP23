package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.ProvidersResponse;
import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.entity.ProviderEntity;
import com.petvax.petvaxServices.entity.VaccinationEntity;
import org.springframework.stereotype.Component;

import javax.transaction.SystemException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public final class ProvidersConverter {

    public ProvidersResponse convertProviderToProviderResponse(final ProviderEntity providerEntity) {

        // Creates response with returned value based upon request
        ProvidersResponse.Builder providersResponseBuilder = new ProvidersResponse.Builder();

        providersResponseBuilder.setUUID(providerEntity.getUuid());
        providersResponseBuilder.setName(providerEntity.getName());
        providersResponseBuilder.setAddress1(providerEntity.getAddress1());
        providersResponseBuilder.setAddress2(providerEntity.getAddress2());
        providersResponseBuilder.setCity(providerEntity.getCity());
        providersResponseBuilder.setState(providerEntity.getState());
        providersResponseBuilder.setZipCode(providerEntity.getZipCode());
        providersResponseBuilder.setEmail(providerEntity.getEmail());
        providersResponseBuilder.setCreatedDate(providerEntity.getCreatedDate());

        return providersResponseBuilder.build();
    }

    /**
     * @param objects to be converted
     * @return
     */
    public List<ProvidersResponse> convertProviderToProviderResponse(final List<ProviderEntity> objects) throws SystemException {
        if (objects == null) {
            throw new SystemException("input was null");
        }
        return objects.stream().map(o -> convertProviderToProviderResponse(o)).collect(Collectors.toList());
    }
}