package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = PetsResponse.Builder.class)
public class PetsResponse {
    private String uuid;
    private String name;
    private String speciesID;
    private String breedID;
    private String ownerID;
    private String age;
    private Boolean active;

    // Response constructor
    public PetsResponse(final String uuid, String name, String speciesID, String breedID, String ownerID, String age, Boolean active) {

        this.uuid = uuid;
        this.name = name;
        this.speciesID = speciesID;
        this.breedID = breedID;
        this.ownerID = ownerID;
        this.age = age;
        this.active = active;
    }

    /**
     * @return {@code uuid}
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @return {@code name}
     */
    public String getName() {
        return name;
    }

    /**
     * @return {@code speciesID}
     */
    public String getSpeciesID() {
        return speciesID;
    }

    /**
     * @return {@code breedID}
     */
    public String getBreedID() {
        return breedID;
    }

    /**
     * @return {@code ownerID}
     */
    public String getOwnerID() {
        return ownerID;
    }

    /**
     * @return {@code age}
     */
    public String getAge() {
        return age;
    }

    /**
     * @return {@code active}
     */
    public Boolean getActive() {
        return active;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String uuid;
        private String name;
        private String speciesID;
        private String breedID;
        private String ownerID;
        private String age;
        private Boolean active;

        // Empty Builder constructor
        public Builder() {
        }

        // Builder Response Constructor
        public Builder(final PetsResponse petsResponse) {

            setUuid(petsResponse.getUuid());
            setName(petsResponse.getName());
            setSpeciesID(petsResponse.getSpeciesID());
            setBreedID(petsResponse.getBreedID());
            setOwnerID(petsResponse.getOwnerID());
            setAge(petsResponse.getAge());
            setActive(petsResponse.getActive());
        }

        /**
         * @param uuid the createdDate to set
         * @return {@code this} builder
         */
        public PetsResponse.Builder setUuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        /**
         * @param name the createdDate to set
         * @return {@code this} builder
         */
        public PetsResponse.Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * @param speciesID the createdDate to set
         * @return {@code this} builder
         */
        public PetsResponse.Builder setSpeciesID(String speciesID) {
            this.speciesID = speciesID;
            return this;
        }

        /**
         * @param breedID the createdDate to set
         * @return {@code this} builder
         */
        public PetsResponse.Builder setBreedID(String breedID) {
            this.breedID = breedID;
            return this;
        }

        /**
         * @param ownerID the createdDate to set
         * @return {@code this} builder
         */
        public PetsResponse.Builder setOwnerID(String ownerID) {
            this.ownerID = ownerID;
            return this;
        }

        /**
         * @param age the createdDate to set
         * @return {@code this} builder
         */
        public PetsResponse.Builder setAge(String age) {
            this.age = age;
            return this;
        }

        /**
         * @param active the active to set
         * @return {@code this} builder
         */
        public PetsResponse.Builder setActive(Boolean active) {
            this.active = active;
            return this;
        }

        // Builds response object with appropriate values
        public PetsResponse build() {
            return new PetsResponse(uuid, name, speciesID, breedID, ownerID, age, active);
        }
    }
}
