package com.provinciaseguros.weather.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.provinciaseguros.weather.BaseTest;
import com.provinciaseguros.weather.services.WeatherService;

@WebMvcTest(WeatherController.class)
@ContextConfiguration(classes = WeatherController.class)
public class WeatherControllerTest extends BaseTest{
    @Autowired
    public MockMvc mockMvc;

    @MockBean
    WeatherService weatherService;

    @Test
    public void it_should_return_200() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/v1/weather/10");
        mockMvc.perform(requestBuilder)
        .andExpect(status().isOk());
    }

    @Test
    public void it_should_return_404() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/v1/weather");
        mockMvc.perform(requestBuilder)
        .andExpect(status().isNotFound());
    }

    @Test
    public void it_should_return_400() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/v1/weather/test");
        mockMvc.perform(requestBuilder)
        .andExpect(status().isBadRequest());
    }
}
