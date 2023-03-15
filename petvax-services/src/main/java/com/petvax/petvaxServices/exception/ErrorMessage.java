package com.petvax.petvaxServices.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("ErrorMessage")
public final class ErrorMessage {

    @ApiModelProperty(name = "status", notes = "Status", example = "500")
    private Integer status;

    @ApiModelProperty(name = "message", notes = "Error", example = "Internal Server Error")
    private String error;

    @ApiModelProperty(name = "exception", notes = "Exception", example = "BusinessException")
    private String exception;

    @ApiModelProperty(name = "message", notes = "Error message", example = "Could not process resource for id= {id}")
    private String message;

    private List<ValidationError> validationErrors;

    // Constructor with validationErrors list
    public ErrorMessage(final Integer status, final String error, final String exception, final String message, final List<ValidationError> validationErrors) {
        this.status = status;
        this.error = error;
        this.exception = exception;
        this.message = message;
        this.validationErrors = validationErrors;
    }

    // Constructor without validationErrors list
    public ErrorMessage(final Integer status, final String error, final String exception, final String message) {
        this.status = status;
        this.error = error;
        this.exception = exception;
        this.message = message;
    }

    /**
     * @return {@code status}
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     * @return {@code this}
     */
    public void setStatus(final Integer status) {
        this.status = status;
    }

    /**
     * @return {@code error}
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     * @return {@code this}
     */
    public void setError(final String error) {
        this.error = error;
    }

    /**
     * @return {@code exception}
     */
    public String getException() {
        return exception;
    }

    /**
     * @param exception the exception to set
     * @return {@code this}
     */
    public void setException(final String exception) {
        this.exception = exception;
    }

    /**
     * @return {@code message}
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     * @return {@code this}
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * @return {@code validationErrors}
     */
    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    /**
     * @param validationErrors the validationErrors to set
     * @return {@code this}
     */
    public void setValidationErrors(final List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public static final class ValidationError {
        private String field;
        private String message;

        // Constructor
        public ValidationError(final String field, final String message) {
            this.field = field;
            this.message = message;
        }

        /**
         * @return {@code field}
         */
        public String getField() {
            return field;
        }

        /**
         * @param field the field to set
         * @return {@code field}
         */
        public void setField(final String field) {
            this.field = field;
        }

        /**
         * @return {@code message}
         */
        public String getMessage() {
            return message;
        }

        /**
         * @param message the message to set
         * @return {@code this}
         */
        public void setMessage(final String message) {
            this.message = message;
        }
    }
}
