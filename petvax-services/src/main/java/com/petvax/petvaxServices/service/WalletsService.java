package com.petvax.petvaxServices.service;

import com.petvax.petvaxServices.converter.WalletsConverter;
import com.petvax.petvaxServices.dto.VaccinationsRequest;
import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.dto.WalletsRequest;
import com.petvax.petvaxServices.dto.WalletsResponse;
import com.petvax.petvaxServices.entity.VaccinationEntity;
import com.petvax.petvaxServices.entity.WalletEntity;
import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.repository.WalletsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.SystemException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * @param petId
     * @return
     */
    @Transactional(readOnly = true)
    public List<WalletsResponse> getWalletByPetId(boolean active,
                                                                       final String petId) throws SystemException {

        List<WalletEntity> walletEntities = walletsRepository.findByPetId(petId);

        // Checks if the list contains value or not
        // Throws an exception if the list is empty
        if (walletEntities.isEmpty()) {
            throw new NotFoundException(String.format("No wallets found for pet with id: [%s]", petId));
        }

        // Iterate through each wallet to determine if 'active' is true or not
        // If true adds to the walletStream variable. Otherwise, doesn't.
        Stream<WalletEntity> walletStream = walletEntities.stream();
        if (active) {
            walletStream = walletStream.filter(walletEntity -> walletEntity.getActive());
        }

        return walletStream
                .map(walletsConverter::convertWalletsToWalletResponse)
                .collect(Collectors.toList());
    }

    /**
     * @param walletId
     * @return
     */
    @Transactional(readOnly = true)
    public WalletsResponse getWalletByWalletId(boolean active, final String walletId) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether to build the response
        // If the wallet object is null then it will throw the NotFoundException exception
        Optional<WalletEntity> wallet = walletsRepository.findByWalletId(walletId);
        return wallet.map(walletsConverter::convertWalletsToWalletResponse).orElseThrow(() -> new NotFoundException(String.format("Id not found: [%s]", walletId)));
    }
    /**
     * @param walletsRequest
     */
    @Transactional
    public WalletsResponse createWallet(final WalletsRequest walletsRequest) {
        WalletEntity wallet = walletsConverter.convertWalletRequestToWallet(walletsRequest);
        wallet = walletsRepository.save(wallet);
        return walletsConverter.convertWalletsToWalletResponse(wallet);
    }

    /**
     *
     */
    @Transactional
    public void deleteWallet(final String walletId) {
        // Attempts to delete wallet using the passed walletId
        // If an empty result is returned (exception for no value) i is caught
        // and NOtFoundException is thrown to display message to user
        try {
            walletsRepository.deleteById(walletId);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(String.format("Wallet with id [%s] not found",
                    walletId));
        }
    }

}
