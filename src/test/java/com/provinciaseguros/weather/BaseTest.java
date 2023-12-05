package com.provinciaseguros.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.provinciaseguros.weather.config.WeatherAPIProperties;

import lombok.Data;

@Data
@ContextConfiguration(classes = WeatherAPIProperties.class)
public class BaseTest {
    @Autowired
    WeatherAPIProperties weatherAPIProperties;
}
