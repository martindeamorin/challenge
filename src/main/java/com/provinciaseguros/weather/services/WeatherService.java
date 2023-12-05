package com.provinciaseguros.weather.services;

import com.provinciaseguros.weather.exceptions.ApiException;
import com.provinciaseguros.weather.models.CurrentWeather;

public interface WeatherService {
    CurrentWeather getCurrentWeatherByLocation(Long locationKey) throws ApiException;
}
