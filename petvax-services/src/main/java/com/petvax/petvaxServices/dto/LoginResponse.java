package com.petvax.petvaxServices.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = WalletsResponse.Builder.class)
public class LoginResponse {
    private String token;
    private String message;

    // Response constructor
    public LoginResponse(final String token, final String message) {
        this.token = token;
        this.message = message;
    }

    /**
     * @return {@code token}
     */
    public String getToken() {
        return token;
    }

    /**
     * @return {@code message}
     */
    public String getMessage() {
        return message;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String token;
        private String message;

        // Empty Builder constructor
        public Builder() {
        }

        // Builder Response Constructor
        public Builder(final LoginResponse loginResponse) {
            setToken(loginResponse.getToken());
            setMessage(loginResponse.getMessage());
        }

        /**
         * @param token the createdDate to set
         * @return {@code this} builder
         */
        public LoginResponse.Builder setToken(String token) {
            this.token = token;
            return this;
        }

        /**
         * @param message the createdDate to set
         * @return {@code this} builder
         */
        public LoginResponse.Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        // Builds response object with appropriate values
        public LoginResponse build() {
            return new LoginResponse(token, message);
        }
    }
}
