package com.provinciaseguros.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.provinciaseguros.weather.config.WeatherAPIProperties;

@SpringBootApplication
@EnableConfigurationProperties(WeatherAPIProperties.class)
@ComponentScan(value = {"com.provinciaseguros.weather.*"})
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

}
