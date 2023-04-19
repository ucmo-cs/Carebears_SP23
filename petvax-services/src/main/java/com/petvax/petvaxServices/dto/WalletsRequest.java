package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = com.petvax.petvaxServices.dto.WalletsRequest.Builder.class)
public final class WalletsRequest {
    private final String walletId;
    private String petId;
    private String name;
    private String purpose;
    private Boolean active;

    public WalletsRequest(final String walletId, final String petId, final String name, final String purpose,
                          final Boolean active) {
        this.walletId = walletId;
        this.petId = petId;
        this.name = name;
        this.purpose = purpose;
        this.active = active;
    }

    public String getWalletId() {return walletId;}
    public String getPetId() {return petId;}
    public String getName() {return name;}
    public String getPurpose() {return purpose;}
    public Boolean getActive() {return active;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String walletId;
        private String petId;
        private String name;
        private String purpose;
        private Boolean active;

        public Builder() {

        }

        // Builder constructor
        public Builder(final WalletsRequest walletsRequest) {
            setPetId(walletsRequest.getPetId());
            setName(walletsRequest.getName());
            setPurpose(walletsRequest.getPurpose());
            setActive(walletsRequest.getActive());
        }

        /**
         * @param petId the petId to set
         * @return {@code this} builder
         */
        public WalletsRequest.Builder setPetId(String petId) {
            this.petId = petId;
            return this;
        }

        /**
         * @param name the name to set
         * @return {@code this} builder
         */
        public WalletsRequest.Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * @param purpose the purpose to set
         * @return {@code this} builder
         */
        public WalletsRequest.Builder setPurpose(String purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * @param active the active to set
         * @return {@code this} builder
         */
        public WalletsRequest.Builder setActive(Boolean active) {
            this.active = active;
            return this;
        }

        // Builds request object with appropriate values
        public WalletsRequest build() {
            return new WalletsRequest(walletId, petId, name, purpose,
                    active);
        }
    }
}
