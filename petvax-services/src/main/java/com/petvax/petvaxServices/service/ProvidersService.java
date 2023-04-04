package com.petvax.petvaxServices.service;

import com.petvax.petvaxServices.converter.ProvidersConverter;
import com.petvax.petvaxServices.dto.ProvidersResponse;
import com.petvax.petvaxServices.entity.ProviderEntity;
import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.repository.ProvidersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.SystemException;
import java.util.List;
import java.util.Optional;

@Service
public class ProvidersService {

    private static final Logger LOG = LoggerFactory.getLogger(ProvidersService.class);

    private final ProvidersRepository providersRepository;
    private final ProvidersConverter providersConverter;

    @Autowired
    public ProvidersService(ProvidersRepository providersRepository, ProvidersConverter providersConverter) {
        this.providersRepository = providersRepository;
        this.providersConverter = providersConverter;
    }

    /**
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    public ProvidersResponse getProviderByName(final String name) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the provider object is null then it will throw the NotFoundException exception
        Optional<ProviderEntity> owner = providersRepository.getProviderByName(name);
        return owner.map(providersConverter::convertProviderToProviderResponse).orElseThrow(() -> new NotFoundException(String.format("name not found: [%s]", name)));
    }

    /**
     * @param city
     * @return
     */
    public List<ProvidersResponse> getProvidersByCity(final String city) throws SystemException {
        List<ProvidersResponse> providerList;
        List<ProviderEntity> providers = providersRepository.getProvidersByCity(city);

        // Convert multiple vaccinationTypes into a response containing a list of types
        providerList = providersConverter.convertProviderToProviderResponse(providers);
        return providerList;
    }
}
