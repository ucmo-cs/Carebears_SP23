package com.petvax.petvaxServices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class NotFoundException extends RuntimeException{

    public NotFoundException(final String message) {
        super(message);
    }

}
