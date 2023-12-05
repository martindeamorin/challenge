package com.provinciaseguros.weather.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException{
    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

    public BadRequestException(String message, Map<String, String> validationErrors) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
