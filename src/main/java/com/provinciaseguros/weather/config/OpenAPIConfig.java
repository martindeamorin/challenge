package com.provinciaseguros.weather.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        contact = @Contact(
            name = "Martin de Amorin",
            email = "martindeamorin@gmail.com",
            url = "https://www.linkedin.com/in/martin-de-amorin-7924b0201/"
        ),
        description = "Weather API for Provincia Seguros",
        title = "Provincia Seguros REST API",
        version = "1.0"
    ),
    servers = @Server(
        description = "Local DEV Environment",
        url = "http://localhost:8080"
    )
)
public class OpenAPIConfig {
    
}
