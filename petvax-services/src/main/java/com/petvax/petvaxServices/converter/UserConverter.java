package com.petvax.petvaxServices.converter;

import com.petvax.petvaxServices.dto.UserResponse;
import com.petvax.petvaxServices.dto.WalletsResponse;
import com.petvax.petvaxServices.entity.UserEntity;
import com.petvax.petvaxServices.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public final class UserConverter {

    public UserResponse convertUserToUserResponse(final UserEntity userEntity) {

        // Creates response with returned value based upon request
        UserResponse.Builder userResponseBuilder = new UserResponse.Builder();

        userResponseBuilder.setOwnerId(userEntity.getOwnerId());

        return userResponseBuilder.build();
    }

}
