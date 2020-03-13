package org.example.boot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.example.exception.NotFoundException;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({NotFoundException.class})
    public final ResponseEntity<?> handleNotFoundException(final Exception ex) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
