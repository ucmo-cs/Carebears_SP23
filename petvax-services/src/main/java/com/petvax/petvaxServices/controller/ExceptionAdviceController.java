package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public final class ExceptionAdviceController {

    // Handles when responses return null value
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleException(final NotFoundException e) {
        return responseEntity(HttpStatus.NOT_FOUND, e);
    }

    // Returns status code and error message to response body
    private ResponseEntity<?> responseEntity(final HttpStatus httpStatus, final RuntimeException e) {
        return ResponseEntity.status(httpStatus).body(new ErrorMessage(httpStatus.value(),
                httpStatus.getReasonPhrase(),
                e.getClass().getName(),
                e.getMessage()));
    }
}
