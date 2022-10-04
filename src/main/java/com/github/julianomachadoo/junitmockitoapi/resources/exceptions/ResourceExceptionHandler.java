package com.github.julianomachadoo.junitmockitoapi.resources.exceptions;

import com.github.julianomachadoo.junitmockitoapi.services.exceptions.DataIntegrityViolationException;
import com.github.julianomachadoo.junitmockitoapi.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(
            ObjectNotFoundException ex,
            HttpServletRequest request) {

        StandardError error = new StandardError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException (
            DataIntegrityViolationException ex,
            HttpServletRequest request) {

        StandardError error = new StandardError(
                LocalDateTime.now(),
                BAD_REQUEST.value(),
                ex.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(BAD_REQUEST).body(error);
    }
}
