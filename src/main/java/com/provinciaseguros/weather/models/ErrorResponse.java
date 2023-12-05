package com.provinciaseguros.weather.models;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(Include.NON_NULL)
public class ErrorResponse {
    public HttpStatus httpCode;
    public String clientMessage;
    public Map<String, String> validationErrors;
}
