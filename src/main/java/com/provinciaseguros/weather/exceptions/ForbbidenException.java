package com.provinciaseguros.weather.exceptions;

import org.springframework.http.HttpStatus;

public class ForbbidenException extends ApiException {
    public ForbbidenException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}
