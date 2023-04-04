package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.petvax.petvaxServices.entity.ProviderEntity;

import java.time.Instant;

@JsonDeserialize(builder = VaccinationRecordResponse.Builder.class)
public class VaccinationRecordResponse {
    private final VaccinationsResponse vaccination;
    private Instant vaccinationDate;
    private ProviderEntity provider;
    private Boolean active;

    // Response constructor
    public VaccinationRecordResponse(final VaccinationsResponse vaccination,
                                     final Instant vaccinationDate, final ProviderEntity provider, final Boolean active) {
        this.vaccination = vaccination;
        this.vaccinationDate = vaccinationDate;
        this.provider = provider;
        this.active = active;
    }

    /**
     * @return {@code active}
     */
    public VaccinationsResponse getVaccination() {
        return vaccination;
    }

    /**
     * @return {@code vaccinationDate}
     */
    public Instant getVaccinationDate() { return vaccinationDate; }

    /**
     * @return {@code providerId}
     */
    public ProviderEntity getProvider() { return provider; }

    /**
     * @return {@code active}
     */
    public Boolean getActive() {
        return active;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private VaccinationsResponse vaccination;
        private Instant vaccinationDate;
        private ProviderEntity provider;
        private Boolean active;

        // Empty Builder constructor
        public Builder() {
        }

        // Builder Response Constructor
        public Builder(final VaccinationRecordResponse vaccinationRecordResponse) {
            setVacciantion(vaccinationRecordResponse.getVaccination());
            setVaccinationDate(vaccinationRecordResponse.getVaccinationDate());
            setProvider(vaccinationRecordResponse.getProvider());
            setActive(vaccinationRecordResponse.getActive());
        }

        /**
         * @param vaccination the vaccination to set
         * @return {@code this} builder
         */
        public void setVacciantion(VaccinationsResponse vaccination) {
            this.vaccination = vaccination;
        }

        /**
         * @param vaccinationDate the name to set
         * @return {@code this} builder
         */
        public Builder setVaccinationDate(Instant vaccinationDate) {
            this.vaccinationDate = vaccinationDate;
            return this;
        }

        /**
         * @param provider the name to set
         * @return {@code this} builder
         */
        public Builder setProvider(ProviderEntity provider) {
            this.provider = provider;
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
        public VaccinationRecordResponse build() {
            return new VaccinationRecordResponse(vaccination, vaccinationDate, provider, active);
        }

    }
}
