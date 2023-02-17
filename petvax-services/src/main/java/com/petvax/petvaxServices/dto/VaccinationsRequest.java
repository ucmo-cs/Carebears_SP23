package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.Instant;

@JsonDeserialize(builder = com.petvax.petvaxServices.dto.VaccinationsRequest.Builder.class)
public class VaccinationsRequest {

    private String name;
    private String type;
    private String age;
    private String frequency;
    private String species;
    private Instant createdDate;

    public VaccinationsRequest(final String name, final String type, final String age,
                        final String frequency, final String species, final Instant createdDate) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.frequency = frequency;
        this.species = species;
        this.createdDate = createdDate;
    }

    public String getName() { return name; }

    public String getType() { return type; }

    public String getAge() { return age; }

    public String getFrequency() { return frequency; }

    public String getSpecies() { return species; }

    public Instant getCreatedDate() { return createdDate; }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String name;
        private String type;
        private String age;
        private String frequency;
        private String species;
        private Instant createdDate;

        public Builder() {

        }

        // Builder constructor
        public Builder(final VaccinationsRequest vaccinationsRequest) {
            setName(vaccinationsRequest.getName());
            setType(vaccinationsRequest.getType());
            setAge(vaccinationsRequest.getAge());
            setFrequency(vaccinationsRequest.getFrequency());
            setSpecies(vaccinationsRequest.getSpecies());
            setCreatedDate(vaccinationsRequest.getCreatedDate());
        }

        /**
         * @param name the name to set
         * @return {@code this} builder
         */
        private Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * @param type the type to set
         * @return {@code this} builder
         */
        private Builder setType(String type) {
            this.type = type;
            return this;
        }

        /**
         * @param age the age to set
         * @return {@code this} builder
         */
        private Builder setAge(String age) {
            this.age = age;
            return this;
        }

        /**
         * @param frequency the frequency to set
         * @return {@code this} builder
         */
        private Builder setFrequency(String frequency) {
            this.frequency = frequency;
            return this;
        }

        /**
         * @param species the species to set
         * @return {@code this} builder
         */
        private Builder setSpecies(String species) {
            this.species = species;
            return this;
        }

        /**
         * @param createdDate the createdDate to set
         * @return {@code this} builder
         */
        public Builder setCreatedDate(final Instant createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        // Builds request object with appropriate values
        protected VaccinationsRequest build() {
            return new VaccinationsRequest(name, type, age,
                    frequency, species, createdDate);
        }
    }
}
