package com.example.getmeservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(restrictedInfoException.class)
    public ResponseEntity<String> restrictedInfoError(restrictedInfoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchFieldException.class)
    public  ResponseEntity<String>  NoSuchFieldException(){
        return new ResponseEntity<>("No such element found",HttpStatus.CONFLICT);
    }
}
