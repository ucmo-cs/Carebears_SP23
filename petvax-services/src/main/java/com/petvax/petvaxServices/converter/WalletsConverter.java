package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.WalletsRequest;
import com.petvax.petvaxServices.dto.WalletsResponse;
import com.petvax.petvaxServices.entity.WalletEntity;
import org.springframework.stereotype.Component;

import javax.transaction.SystemException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public final class WalletsConverter {

    public WalletsResponse convertWalletsToWalletResponse(final WalletEntity walletEntity) {

        // Creates response with returned value based upon request
        WalletsResponse.Builder walletResponseBuilder = new WalletsResponse.Builder();

        walletResponseBuilder.setWalletId(walletEntity.getWalletId());
        walletResponseBuilder.setPetId(walletEntity.getPetId());
        walletResponseBuilder.setName(walletEntity.getName());
        walletResponseBuilder.setPurpose(walletEntity.getPurpose());
        walletResponseBuilder.setActive(walletEntity.getActive());

        return walletResponseBuilder.build();
    }

    /**
     * @param objects to be converted
     * @return
     */
    public List<WalletsResponse> convertWalletsToWalletsResponse(final List<WalletEntity> objects) throws SystemException {
        if (objects == null) {
            throw new SystemException("input was null");
        }
        return objects.stream().map(o -> convertWalletsToWalletResponse(o)).collect(Collectors.toList());
    }

    public WalletEntity convertWalletRequestToWallet(final WalletsRequest walletsRequest) {
        WalletEntity wallet = new WalletEntity();

        wallet.setWalletId(walletsRequest.getWalletId());
        wallet.setPetId(walletsRequest.getPetId());
        wallet.setName(walletsRequest.getName());
        wallet.setPurpose(walletsRequest.getPurpose());
        wallet.setActive(walletsRequest.getActive());

        return wallet;
    }

}
