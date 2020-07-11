package com.sso.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoUserExistException.class)
    public ResponseEntity<Error> handleTokenExpireException(NoUserExistException ex) {
        /*Give not found error code for user doesn't exist*/
        Error error = new Error(404, ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }
}
