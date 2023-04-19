package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.petvax.petvaxServices.entity.ProviderEntity;

import java.time.Instant;

@JsonDeserialize(builder = WalletVaccinationRecordResponse.Builder.class)
public class WalletVaccinationRecordResponse {
    private final VaccinationsResponse vaccination;
    private String walletId;
    private Instant walletVaccinationDate;
    private Boolean active;

    // Response constructor
    public WalletVaccinationRecordResponse(final VaccinationsResponse vaccination, final String walletId,
                                           final Instant walletVaccinationDate, final Boolean active) {
        this.vaccination = vaccination;
        this.walletId = walletId;
        this.walletVaccinationDate = walletVaccinationDate;
        this.active = active;
    }

    /**
     * @return {@code active}
     */
    public VaccinationsResponse getVaccination() {
        return vaccination;
    }

    /**
     * @return {@code walletId}
     */
    public String getWalletId() { return walletId; }

    /**
     * @return {@code vaccinationDate}
     */
    public Instant getWalletVaccinationDate() { return walletVaccinationDate; }

    /**
     * @return {@code active}
     */
    public Boolean getActive() {
        return active;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private VaccinationsResponse vaccination;
        private String walletId;
        private Instant walletVaccinationDate;
        private Boolean active;

        // Empty Builder constructor
        public Builder() {
        }

        // Builder Response Constructor
        public Builder(final WalletVaccinationRecordResponse walletVaccinationRecordResponse) {
            setVacciantion(walletVaccinationRecordResponse.getVaccination());
            setWalletId(walletVaccinationRecordResponse.getWalletId());
            setWalletVaccinationDate(walletVaccinationRecordResponse.getWalletVaccinationDate());
            setActive(walletVaccinationRecordResponse.getActive());
        }

        /**
         * @param vaccination the vaccination to set
         * @return {@code this} builder
         */
        public void setVacciantion(VaccinationsResponse vaccination) {
            this.vaccination = vaccination;
        }

        /**
         * @param walletId the name to set
         * @return {@code this} builder
         */
        public Builder setWalletId(String walletId) {
            this.walletId = walletId;
            return this;
        }

        /**
         * @param walletVaccinationDate the name to set
         * @return {@code this} builder
         */
        public Builder setWalletVaccinationDate(Instant walletVaccinationDate) {
            this.walletVaccinationDate = walletVaccinationDate;
            return this;
        }

        /**
         * @param active the age to set
         * @return {@code this} builder
         */
        public Builder setActive(Boolean active) {
            this.active = active;
            return this;
        }

        // Builds response object with appropriate values
        public WalletVaccinationRecordResponse build() {
            return new WalletVaccinationRecordResponse(vaccination, walletId, walletVaccinationDate, active);
        }

    }
}
