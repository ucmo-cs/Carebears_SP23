package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.Instant;

@JsonDeserialize(builder = OwnersResponse.Builder.class)
public class OwnersResponse {
    private String UUID;
    private String fname;
    private String lname;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
    private String email;
    private Instant createdDate;

    // Response constructor
    public OwnersResponse(final String UUID, final String fname, final String lname,
                          final String address1, final String address2, final String city,
                          final String state, final String zipCode, final String email,
                          final Instant createdDate) {
        this.UUID = UUID;
        this.fname = fname;
        this.lname = lname;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.createdDate = createdDate;
    }

    /**
     * @return {@code UUID}
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * @return {@code fname}
     */
    public String getFname() {
        return fname;
    }

    /**
     * @return {@code lname}
     */
    public String getLname() {
        return lname;
    }

    /**
     * @return {@code address1}
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @return {@code address2}
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @return {@code city}
     */
    public String getCity() {
        return city;
    }

    /**
     * @return {@code state}
     */
    public String getState() {
        return state;
    }

    /**
     * @return {@code zipCode}
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @return {@code email}
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return {@code createdDate}
     */
    public Instant getCreatedDate() {
        return createdDate;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String UUID;
        private String fname;
        private String lname;
        private String address1;
        private String address2;
        private String city;
        private String state;
        private String zipCode;
        private String email;
        private Instant createdDate;

        // Empty Builder constructor
        public Builder() {
        }

        // Response constructor
        public Builder(final OwnersResponse ownersResponse) {
            setUUID(ownersResponse.getUUID());
            setFName(ownersResponse.getFname());
            setLName(ownersResponse.getLname());
            setAddress1(ownersResponse.getAddress1());
            setAddress2(ownersResponse.getAddress2());
            setCity(ownersResponse.getCity());
            setState(ownersResponse.getState());
            setZipCode(ownersResponse.getZipCode());
            setEmail(ownersResponse.getEmail());
            setCreatedDate(ownersResponse.getCreatedDate());
        }

        /**
         * @param UUID the createdDate to set
         * @return {@code this} builder
         */
        public OwnersResponse.Builder setUUID(final String UUID) {
            this.UUID = UUID;
            return this;
        }

        /**
         * @param fname the createdDate to set
         * @return {@code this} builder
         */
        public OwnersResponse.Builder setFName(final String fname) {
            this.fname = fname;
            return this;
        }

        /**
         * @param lname the createdDate to set
         * @return {@code this} builder
         */
        public OwnersResponse.Builder setLName(final String lname) {
            this.lname = lname;
            return this;
        }

        /**
         * @param address1 the createdDate to set
         * @return {@code this} builder
         */
        public OwnersResponse.Builder setAddress1(final String address1) {
            this.address1 = address1;
            return this;
        }

        /**
         * @param address2 the createdDate to set
         * @return {@code this} builder
         */
        public OwnersResponse.Builder setAddress2(final String address2) {
            this.address2 = address2;
            return this;
        }

        /**
         * @param city the createdDate to set
         * @return {@code this} builder
         */
        public OwnersResponse.Builder setCity(final String city) {
            this.city = city;
            return this;
        }

        /**
         * @param state the createdDate to set
         * @return {@code this} builder
         */
        public OwnersResponse.Builder setState(final String state) {
            this.state = state;
            return this;
        }

        /**
         * @param zipCode the createdDate to set
         * @return {@code this} builder
         */
        public OwnersResponse.Builder setZipCode(final String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        /**
         * @param email the createdDate to set
         * @return {@code this} builder
         */
        public OwnersResponse.Builder setEmail(final String email) {
            this.email = email;
            return this;
        }

        /**
         * @param createdDate the createdDate to set
         * @return {@code this} builder
         */
        public OwnersResponse.Builder setCreatedDate(final Instant createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        // Builds response object with appropriate values
        public OwnersResponse build() {
            return new OwnersResponse(UUID, fname, lname, address1, address2,
                    city, state, zipCode, email, createdDate);
        }
    }
}
