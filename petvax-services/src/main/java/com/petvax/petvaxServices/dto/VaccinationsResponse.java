package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.Instant;
import java.util.Optional;

@JsonDeserialize(builder = VaccinationsResponse.Builder.class)
public class VaccinationsResponse {
    private String vaccinationId;
    private String name;
    private String type;
    private String age;
    private String frequency;
    private String species;
    private Instant createdDate;

    // Response constructor
    public VaccinationsResponse(final String vaccinationId, String name, final String type, final String age,
                                String frequency, String species, final Instant createdDate) {
        this.vaccinationId = vaccinationId;
        this.name = name;
        this.type = type;
        this.age = age;
        this.frequency = frequency;
        this.species = species;
        this.createdDate = createdDate;
    }

    /**
     * @return {@code vaccinationId}
     */
    public String getVaccinationId() {
        return vaccinationId;
    }

    /**
     * @return {@code name}
     */
    public String getName() {
        return name;
    }

    /**
     * @return {@code type}
     */
    public String getType() {
        return type;
    }

    /**
     * @return {@code age}
     */
    public String getAge() {
        return age;
    }

    /**
     * @return {@code frequency}
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * @return {@code species}
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @return {@code createdDate}
     */
    public Instant getCreatedDate() {
        return createdDate;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String vaccinationId;
        private String name;
        private String type;
        private String age;
        private String frequency;
        private String species;
        private Instant createdDate;

        // Empty Builder constructor
        public Builder() {
        }

        // Builder Response Constructor
        public Builder(final VaccinationsResponse vaccinationsResponse) {
            setVaccinationId((vaccinationsResponse.getVaccinationId()));
            setName(vaccinationsResponse.getName());
            setType(vaccinationsResponse.getType());
            setAge(vaccinationsResponse.getAge());
            setFrequency(vaccinationsResponse.getFrequency());
            setSpecies(vaccinationsResponse.getSpecies());
            setCreatedDate(vaccinationsResponse.getCreatedDate());
        }

        /**
         * @param vaccinationId the createdDate to set
         * @return {@code this} builder
         */
        public VaccinationsResponse.Builder setVaccinationId(String vaccinationId) {
            this.vaccinationId = vaccinationId;
            return this;
        }

        /**
         * @param name the createdDate to set
         * @return {@code this} builder
         */
        public VaccinationsResponse.Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * @param type the type to set
         * @return {@code this} builder
         */
        public VaccinationsResponse.Builder setType(String type) {
            this.type = type;
            return this;
        }

        /**
         * @param age the age to set
         * @return {@code this} builder
         */
        public VaccinationsResponse.Builder setAge(String age) {
            this.age = age;
            return this;
        }

        /**
         * @param frequency the frequency to set
         * @return {@code this} builder
         */
        public VaccinationsResponse.Builder setFrequency(String frequency) {
            this.frequency = frequency;
            return this;
        }

        /**
         * @param species the species to set
         * @return {@code this} builder
         */
        public VaccinationsResponse.Builder setSpecies(String species) {
            this.species = species;
            return this;
        }

        /**
         * @param createdDate the createdDate to set
         * @return {@code this} builder
         */
        public VaccinationsResponse.Builder setCreatedDate(final Instant createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        // Builds response object with appropriate values
        public VaccinationsResponse build() {
                return new VaccinationsResponse(vaccinationId, name, type, age, frequency, species, createdDate);
        }
    }
}
