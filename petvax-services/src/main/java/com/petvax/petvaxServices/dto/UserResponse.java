package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = UserResponse.Builder.class)
public class UserResponse {
    private String ownerId;

    // Response constructor
    public UserResponse(final String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @return {@code ownerId}
     */
    public String getOwnerId() {
        return ownerId;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String ownerId;

        // Empty Builder constructor
        public Builder() {
        }

        // Builder Response Constructor
        public Builder(final UserResponse userResponse) {
            setOwnerId(userResponse.getOwnerId());
        }

        /**
         * @param ownerId the createdDate to set
         * @return {@code this} builder
         */
        public UserResponse.Builder setOwnerId(final String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        // Builds response object with appropriate values
        public UserResponse build() {
            return new UserResponse(ownerId);
        }
    }
}
