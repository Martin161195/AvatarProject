package com.mramirez.avatarproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(value = {ProductoException.class})
    public ResponseEntity<Object> handlerProductoException(ProductoException productoException){

        if(productoException.getMessage()==null){

            return new ResponseEntity<>(productoException.getHttpStatus());

        }else{

            ApiException apiException = new ApiException(
                    productoException.getMessage()
            );
            return new ResponseEntity<>(apiException, productoException.getHttpStatus());

        }

    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void badJsonHandler() { }

    @ExceptionHandler(value= {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void genericException(){}

}
