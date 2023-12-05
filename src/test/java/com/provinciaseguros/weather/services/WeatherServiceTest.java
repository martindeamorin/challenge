package com.provinciaseguros.weather.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.provinciaseguros.weather.BaseTest;
import com.provinciaseguros.weather.WeatherApplication;
import com.provinciaseguros.weather.exceptions.ApiException;
import com.provinciaseguros.weather.exceptions.BadRequestException;
import com.provinciaseguros.weather.models.CurrentWeather;


@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = WeatherApplication.class)
public class WeatherServiceTest extends BaseTest{

    @Autowired
    WeatherService weatherService;

    @Test
    public void it_should_return_current_weather() throws ApiException {
        CurrentWeather currentWeather = weatherService.getCurrentWeatherByLocation(10L);

        assertNotNull(currentWeather);
    }

    @Test
    public void it_should_throw_bad_request() throws ApiException {
        assertThrows(BadRequestException.class, () -> weatherService.getCurrentWeatherByLocation(333323131L));
    }

    
}
