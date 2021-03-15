package com.mramirez.avatarproject.exception;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ApiException {

    private final String errorMessage;

    public ApiException(String errorMessage) {
        this.errorMessage = errorMessage;

    }
}
