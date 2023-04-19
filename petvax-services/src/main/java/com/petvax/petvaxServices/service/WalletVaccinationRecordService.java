package com.petvax.petvaxServices.service;

import com.petvax.petvaxServices.converter.VaccinationRecordConverter;
import com.petvax.petvaxServices.converter.WalletVaccinationRecordConverter;
import com.petvax.petvaxServices.dto.VaccinationRecordResponse;
import com.petvax.petvaxServices.dto.WalletVaccinationRecordResponse;
import com.petvax.petvaxServices.entity.VaccinationRecordEntity;
import com.petvax.petvaxServices.entity.WalletVaccinationRecordEntity;
import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.repository.VaccinationRecordRepository;
import com.petvax.petvaxServices.repository.WalletVaccinationRecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.SystemException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WalletVaccinationRecordService {

    private static final Logger LOG = LoggerFactory.getLogger(VaccinationsService.class);

    private final WalletVaccinationRecordRepository walletVaccinationRecordRepository;

    private final WalletVaccinationRecordConverter walletVaccinationRecordConverter;
    private String active;

    @Autowired
    public WalletVaccinationRecordService(final WalletVaccinationRecordRepository walletVaccinationRecordRepository,
                                          final WalletVaccinationRecordConverter walletVaccinationRecordConverter) {
        this.walletVaccinationRecordRepository = walletVaccinationRecordRepository;
        this.walletVaccinationRecordConverter = walletVaccinationRecordConverter;
    }

    /**
     * @param walletId
     * @return
     */
    @Transactional(readOnly = true)
    public List<WalletVaccinationRecordResponse> findVaccinationRecordByWalletId(boolean active,
                                                                                 final String walletId) throws SystemException {

        List<WalletVaccinationRecordEntity> walletVaccinationRecordEntities = walletVaccinationRecordRepository.findVaccinationRecordByWalletId(walletId);

        // Checks if the list contains value or not
        // Throws an exception if the list is empty
        if (walletVaccinationRecordEntities.isEmpty()) {
            throw new NotFoundException(String.format("No wallet vaccination records found for pet with id: [%s]", walletId));
        }

        // Iterate through each wallet vaccination record to determine if 'active' is true or not
        // If true adds to the vaccinationRecordStream variable. Otherwise, doesn't.
        Stream<WalletVaccinationRecordEntity> walletVaccinationRecordStream = walletVaccinationRecordEntities.stream();
        if (active) {
            walletVaccinationRecordStream = walletVaccinationRecordStream.filter(walletVaccinationRecordEntity -> walletVaccinationRecordEntity.getActive());
        }

        return walletVaccinationRecordStream
                .map(walletVaccinationRecordConverter::convertWalletVaccinationRecordToWalletVaccinationRecordResponse)
                .collect(Collectors.toList());
    }
}
