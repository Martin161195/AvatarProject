package com.mramirez.avatarproject.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ProductoException extends  Exception{

    private String errorMessage ;
    private HttpStatus httpStatus;

    public ProductoException(String errorMessage, HttpStatus httpStatus){
        super(errorMessage);
        this.httpStatus = httpStatus;

    }

    public ProductoException(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }


}
