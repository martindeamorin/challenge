package com.provinciaseguros.weather.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApiException extends Exception {
    private HttpStatus httpCode;
    private String clientMessage;
    private Map<String, String> validationErrors;

    public ApiException(HttpStatus httpCode, String clientMessage, Map<String, String> validationErrors) {
        super(clientMessage);
        this.httpCode = httpCode;
        this.clientMessage = clientMessage;
        this.validationErrors = validationErrors;
    }

    public ApiException(HttpStatus httpCode, String clientMessage) {
        super(clientMessage);
        this.httpCode = httpCode;
        this.clientMessage = clientMessage;
    }
}
