package com.shendyuk.cityManagement.exceptionHandler;

import com.shendyuk.cityManagement.exception.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handle(EntityNotFoundException entityNotFoundException) {
        return ResponseEntity.status(400).body(entityNotFoundException.getMessage());
    }
}
