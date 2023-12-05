package com.provinciaseguros.weather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.provinciaseguros.weather.entity.Location;
import com.provinciaseguros.weather.exceptions.ApiException;
import com.provinciaseguros.weather.models.ErrorResponse;
import com.provinciaseguros.weather.services.LocationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping(value =  "/v1/location", produces = "application/json")
@Tag(name = "Locations")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping
    @Operation(
        description = "Get locations",
        summary = "Provide a search query to get the location key.",
        responses = {
            @ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
        }
    )
    public Location[] getLocations(
        @RequestParam(required = true) 
        @NotBlank
        String q) throws ApiException {
        return locationService.getLocationByQuery(q);
    }
}
