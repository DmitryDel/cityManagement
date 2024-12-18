package com.shendyuk.cityManagement.exceptionHandler;

import com.shendyuk.cityManagement.exception.HomeAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HomeAlreadyExistsException.class)
    public ResponseEntity<String> handleHomeAlreadyExistsException(HomeAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage()); // 409
    }
}
