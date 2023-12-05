package com.provinciaseguros.weather.network;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.provinciaseguros.weather.config.WeatherAPIProperties;
import com.provinciaseguros.weather.exceptions.ApiException;
import com.provinciaseguros.weather.models.CurrentWeather;

@Component
public class WeatherClient extends HttpClient {

    public WeatherClient(WeatherAPIProperties weatherAPIProperties) {
        super(weatherAPIProperties);
    }

    private final String serviceUrl = weatherAPIProperties.getApiUrl() + "/currentconditions/v1";


    public CurrentWeather getCurrentTime(Long locationKey) throws ApiException {
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(serviceUrl)
            .pathSegment(String.valueOf(locationKey))
           .queryParam("apikey", weatherAPIProperties.getApiKey())
            .encode()
            .toUriString();
        return this.doRequest(
            HttpMethod.GET.name(), 
            urlTemplate, 
            null, 
            null, 
            CurrentWeather[].class)[0];
    }
}
