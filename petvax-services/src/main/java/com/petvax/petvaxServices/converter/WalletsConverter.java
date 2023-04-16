package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.WalletsResponse;
import com.petvax.petvaxServices.entity.WalletEntity;
import org.springframework.stereotype.Component;

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

}