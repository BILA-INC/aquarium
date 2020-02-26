package com.devops.aquarium.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ISException extends RuntimeException {
    public ISException(String I_S) {
        super(I_S);
    }
}