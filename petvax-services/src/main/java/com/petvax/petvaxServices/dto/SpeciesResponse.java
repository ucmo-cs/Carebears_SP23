package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = SpeciesResponse.Builder.class)
public class SpeciesResponse {
    private String uuid;
    private String speciesName;

    // Response constructor
    public SpeciesResponse(final String uuid, final String speciesName) {
        this.uuid = uuid;
        this.speciesName = speciesName;
    }

    /**
     * @return {@code uuid}
     */
    public String getUuid() { return uuid; }

    /**
     * @return {@code name}
     */
    public String getSpeciesName() { return speciesName; }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String uuid;
        private String speciesName;

        // Empty Builder constructor
        public Builder() {
        }

        // Builder Response Constructor
        public Builder(final SpeciesResponse speciesResponse) {
            setUuid(speciesResponse.getUuid());
            setSpeciesName(speciesResponse.getSpeciesName());
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
         * @param speciesName the name to set
         * @return {@code this} builder
         */
        public Builder setSpeciesName(String speciesName) {
            this.speciesName = speciesName;
            return this;
        }

        // Builds response object with appropriate values
        public SpeciesResponse build() {
            return new SpeciesResponse(uuid, speciesName);
        }

    }
}
