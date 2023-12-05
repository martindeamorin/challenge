package com.provinciaseguros.weather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.provinciaseguros.weather.exceptions.ApiException;
import com.provinciaseguros.weather.models.CurrentWeather;
import com.provinciaseguros.weather.models.ErrorResponse;
import com.provinciaseguros.weather.services.WeatherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value =  "/v1/weather", produces = "application/json")
@Tag(name = "Current Weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/{locationKey}")
    @Operation(
        description = "Get current weather endpoint",
        summary = "Provide a location key to retrieve current weather conditions.",
        responses = {
            @ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
        }
    )
    public CurrentWeather getCurrentWeatherByCity(
            @PathVariable 
            @NotNull( message = "You must provide a location key.")
            @Min(value = 0, message = "Location key must be positive.")
            Long locationKey
        ) throws ApiException {
        return weatherService.getCurrentWeatherByLocation(locationKey);
    }
}
