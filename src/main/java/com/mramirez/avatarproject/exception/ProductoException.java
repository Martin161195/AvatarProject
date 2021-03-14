package com.mramirez.avatarproject.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoException extends  Exception{

    private String errorMessage;

    public ProductoException(String errorMessage){
        super(errorMessage );

    }

}
