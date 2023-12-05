package com.provinciaseguros.weather.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@ConfigurationProperties(prefix = "accuweather")
@Configuration
@Data
public class WeatherAPIProperties {
    private String apiKey;
    private String apiUrl;
}
