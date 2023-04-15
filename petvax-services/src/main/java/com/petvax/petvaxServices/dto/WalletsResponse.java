package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = WalletsResponse.Builder.class)
public class WalletsResponse {
    private String walletId;
    private String petId;
    private String name;
    private String purpose;
    private Boolean active;

    // Response constructor
    public WalletsResponse(final String walletId, final String petId, final String name, final String purpose, final Boolean active) {

        this.walletId = walletId;
        this.petId = petId;
        this.name = name;
        this.purpose = purpose;
        this.active = active;
    }

    /**
     * @return {@code walletId}
     */
    public String getWalletId() {
        return walletId;
    }

    /**
     * @return {@code petId}
     */
    public String getPetId() { return petId; }

    /**
     * @return {@code name}
     */
    public String getName() { return name; }

    /**
     * @return {@code purpose}
     */
    public String getPurpose() { return purpose; }

    /**
     * @return {@code active}
     */
    public Boolean getActive() { return active; }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String walletId;
        private String petId;
        private String name;
        private String purpose;
        private Boolean active;

        // Empty Builder constructor
        public Builder() {
        }

        // Builder Response Constructor
        public Builder(final WalletsResponse walletsResponse) {
            setWalletId(walletsResponse.getWalletId());
            setPetId(walletsResponse.getPetId());
            setName(walletsResponse.getName());
            setPurpose(walletsResponse.getPurpose());
            setActive(walletsResponse.getActive());
        }

        /**
         * @param walletId the createdDate to set
         * @return {@code this} builder
         */
        public WalletsResponse.Builder setWalletId(final String walletId) {
            this.walletId = walletId;
            return this;
        }

        /**
         * @param petId the createdDate to set
         * @return {@code this} builder
         */
        public WalletsResponse.Builder setPetId(final String petId) {
            this.petId = petId;
            return this;
        }

        /**
         * @param name the createdDate to set
         * @return {@code this} builder
         */
        public WalletsResponse.Builder setName(final String name) {
            this.name = name;
            return this;
        }

        /**
         * @param purpose the createdDate to set
         * @return {@code this} builder
         */
        public WalletsResponse.Builder setPurpose(final String purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * @param active the createdDate to set
         * @return {@code this} builder
         */
        public WalletsResponse.Builder setActive(final Boolean active){
            this.active = active;
            return this;
        }

        // Builds response object with appropriate values
        public WalletsResponse build() {
            return new WalletsResponse(walletId, petId, name, purpose, active);
        }
    }
}
