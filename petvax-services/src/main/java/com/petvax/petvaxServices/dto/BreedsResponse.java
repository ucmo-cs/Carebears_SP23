package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = BreedsResponse.Builder.class)
public class BreedsResponse {
    private String uuid;
    private String name;
    private final SpeciesResponse species;

    // Response constructor
    public BreedsResponse(final String uuid, final String name, final SpeciesResponse species) {
        this.uuid = uuid;
        this.name = name;
        this.species = species;
    }

    /**
     * @return {@code uuid}
     */
    public String getUuid() { return uuid; }

    /**
     * @return {@code name}
     */
    public String getName() { return name; }

    /**
     * @return {@code species}
     */
    public SpeciesResponse getSpecies() {
        return species;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String uuid;
        private String name;
        private SpeciesResponse species;

        // Empty Builder constructor
        public Builder() {
        }

        // Builder Response Constructor
        public Builder(final BreedsResponse breedsResponse) {
            setUuid(breedsResponse.getUuid());
            setName(breedsResponse.getName());
            setSpecies(breedsResponse.getSpecies());
        }

        /**
         * @param uuid the name to set
         * @return {@code this} builder
         */
        public Builder setUuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        /**
         * @param name the name to set
         * @return {@code this} builder
         */
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * @param species the species to set
         * @return {@code this} builder
         */
        public void setSpecies(SpeciesResponse species) {
            this.species = species;
        }

        // Builds response object with appropriate values
        public BreedsResponse build() {
            return new BreedsResponse(uuid, name, species);
        }

    }
}
