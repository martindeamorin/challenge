package com.provinciaseguros.weather.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.provinciaseguros.weather.exceptions.ApiException;
import com.provinciaseguros.weather.models.CurrentWeather;
import com.provinciaseguros.weather.network.WeatherClient;
import com.provinciaseguros.weather.services.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    WeatherClient weatherClient;

    @Override
    public CurrentWeather getCurrentWeatherByLocation(Long locationKey) throws ApiException {
        return weatherClient.getCurrentTime(locationKey);
    }
    
}
