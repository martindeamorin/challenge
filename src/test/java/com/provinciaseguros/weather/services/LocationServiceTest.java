package com.provinciaseguros.weather.services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.provinciaseguros.weather.BaseTest;
import com.provinciaseguros.weather.WeatherApplication;
import com.provinciaseguros.weather.entity.Location;
import com.provinciaseguros.weather.exceptions.ApiException;


@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = WeatherApplication.class)
public class LocationServiceTest extends BaseTest {

    @Autowired
    LocationService locationService;

    @Test
    public void it_should_return_empty_array() throws ApiException {
        Location[] locations = locationService.getLocationByQuery("test_no_results");

        assertArrayEquals(new Location[0], locations);
    }

    @Test
    public void it_should_return_results() throws ApiException {
        Location[] locations = locationService.getLocationByQuery("merlo");

        assertTrue(locations.length > 0);
    }

    
}
