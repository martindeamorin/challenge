package com.provinciaseguros.weather.exceptions.handlers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.provinciaseguros.weather.exceptions.ApiException;
import com.provinciaseguros.weather.models.ErrorResponse;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ApiException.class})
    protected ResponseEntity<ErrorResponse> handleApiException(ApiException apiException) {
        return ResponseEntity
            .status(apiException.getHttpCode().value())
            .body(ErrorResponse.builder()
                .httpCode(apiException.getHttpCode())
                .clientMessage(apiException.getClientMessage())
                .validationErrors(apiException.getValidationErrors())
                .build()
            );
    }
    
}
