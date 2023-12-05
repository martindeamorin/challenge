package com.provinciaseguros.weather.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.provinciaseguros.weather.BaseTest;
import com.provinciaseguros.weather.services.LocationService;

@WebMvcTest(LocationController.class)
@ContextConfiguration(classes = {LocationController.class})
public class LocationControllerTest extends BaseTest {
    @Autowired
    public MockMvc mockMvc;

    @MockBean
    LocationService locationService;

    @Test
    public void it_should_return_200() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/v1/location")
                .param("q", "merlo");
        mockMvc.perform(requestBuilder)
        .andExpect(status().isOk());
    }

    @Test
    public void it_should_return_404() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/v1/location");
        mockMvc.perform(requestBuilder)
        .andExpect(status().isBadRequest());
    }
}
