package com.petvax.petvaxServices.service;

import com.petvax.petvaxServices.converter.OwnersConverter;
import com.petvax.petvaxServices.dto.OwnersResponse;
import com.petvax.petvaxServices.entity.OwnerEntity;
import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.repository.OwnersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OwnersService {

    private static final Logger LOG = LoggerFactory.getLogger(OwnersService.class);

    private final OwnersRepository ownersRepository;
    private final OwnersConverter ownersConverter;

    @Autowired
    public OwnersService(OwnersRepository ownersRepository, OwnersConverter ownersConverter) {
        this.ownersRepository = ownersRepository;
        this.ownersConverter = ownersConverter;
    }

    /**
     * @param uuid
     * @return
     */
    @Transactional(readOnly = true)
    public OwnersResponse findOwnerByUuid(final String uuid) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the owner object is null then it will throw the NotFoundException exception
        Optional<OwnerEntity> owner = ownersRepository.findOwnerByUuid(uuid);
        return owner.map(ownersConverter::convertOwnerToOwnerResponse).orElseThrow(() -> new NotFoundException(String.format("Id not found: [%s]", uuid)));
    }
}
