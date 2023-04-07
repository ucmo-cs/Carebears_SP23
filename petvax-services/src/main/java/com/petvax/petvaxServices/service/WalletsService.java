package com.petvax.petvaxServices.service;

import com.petvax.petvaxServices.converter.WalletsConverter;
import com.petvax.petvaxServices.dto.WalletsResponse;
import com.petvax.petvaxServices.entity.WalletEntity;
import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.repository.WalletsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class WalletsService {
    private static final Logger LOG = LoggerFactory.getLogger(WalletsService.class);

    private final WalletsRepository walletsRepository;

    private final WalletsConverter walletsConverter;

    @Autowired
    public WalletsService(WalletsRepository walletsRepository, WalletsConverter walletsConverter) {
        this.walletsRepository = walletsRepository;
        this.walletsConverter = walletsConverter;
    }

    /**
     * @param walletId
     * @return
     */
    @Transactional(readOnly = true)
    public WalletsResponse getWalletByWalletId(final String walletId) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the wallet object is null then it will throw the NotFoundException exception
        Optional<WalletEntity> wallet = walletsRepository.findByWalletId(walletId);
        return wallet.map(walletsConverter::convertWalletsToWalletResponse).orElseThrow(() -> new NotFoundException(String.format("Id not found: [%s]", walletId)));
    }
}
