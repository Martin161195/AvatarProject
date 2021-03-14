package com.mramirez.avatarproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductoExceptionHandler extends Throwable {


    @ExceptionHandler(value = {ProductoException.class})
    public ResponseEntity<Object> genericHandlerProductoException(ProductoException productoException){

        HttpStatus genericError = HttpStatus.BAD_REQUEST;

        productoException.setErrorMessage("error generico");

        return new ResponseEntity<>(productoException.getErrorMessage(), genericError);

    }
}
