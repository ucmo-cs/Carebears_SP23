package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = PetsResponse.Builder.class)
public class PetsResponse {
    private final SpeciesResponse species;
    private final BreedsResponse breed;
    private String uuid;
    private String name;
    private String ownerID;
    private String age;
    private Boolean active;

    // Response constructor
    public PetsResponse(final SpeciesResponse species, final BreedsResponse breed, String uuid, String name, String ownerID, String age, Boolean active) {

        this.species = species;
        this.breed = breed;
        this.uuid = uuid;
        this.name = name;
        this.ownerID = ownerID;
        this.age = age;
        this.active = active;
    }

    /**
     * @return {@code species}
     */
    public SpeciesResponse getSpecies() {
        return species;
    }

    /**
     * @return {@code breed}
     */
    public BreedsResponse getBreed() {
        return breed;
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
        private SpeciesResponse species;
        private BreedsResponse breed;
        private String uuid;
        private String name;
        private String ownerID;
        private String age;
        private Boolean active;

        // Empty Builder constructor
        public Builder() {
        }

        // Builder Response Constructor
        public Builder(final PetsResponse petsResponse) {

            setSpecies(petsResponse.getSpecies());
            setBreed(petsResponse.getBreed());
            setUuid(petsResponse.getUuid());
            setName(petsResponse.getName());
            setOwnerID(petsResponse.getOwnerID());
            setAge(petsResponse.getAge());
            setActive(petsResponse.getActive());
        }

        /**
         * @param species the species to set
         * @return {@code this} builder
         */
        public void setSpecies(SpeciesResponse species) {
            this.species = species;
        }

        /**
         * @param breed the breed to set
         * @return {@code this} builder
         */
        public void setBreed(BreedsResponse breed) {
            this.breed = breed;
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
            return new PetsResponse(species, breed, uuid, name, ownerID, age, active);
        }
    }
}
