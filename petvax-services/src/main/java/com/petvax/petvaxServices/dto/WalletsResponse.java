package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = WalletsResponse.Builder.class)
public class WalletsResponse {
    public String walletId;

    // Response constructor
    public WalletsResponse(final String walletId) {
        this.walletId = walletId;
    }

    /**
     * @return {@code walletId}
     */
    public String getWalletId() {
        return walletId;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String walletId;

        // Empty Builder constructor
        public Builder() {
        }

        // Builder Response Constructor
        public Builder(final WalletsResponse walletsResponse) {
            setWalletId(walletsResponse.getWalletId());
        }

        /**
         * @param walletId the createdDate to set
         * @return {@code this} builder
         */
        public WalletsResponse.Builder setWalletId(final String walletId) {
            this.walletId = walletId;
            return this;
        }

        // Builds response object with appropriate values
        public WalletsResponse build() {
            return new WalletsResponse(walletId);
        }
    }
}
