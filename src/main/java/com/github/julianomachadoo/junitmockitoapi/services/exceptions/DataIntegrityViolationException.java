package com.github.julianomachadoo.junitmockitoapi.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
