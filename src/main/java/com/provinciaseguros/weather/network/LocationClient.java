package com.provinciaseguros.weather.network;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.provinciaseguros.weather.config.WeatherAPIProperties;
import com.provinciaseguros.weather.entity.Location;
import com.provinciaseguros.weather.exceptions.ApiException;

@Component
public class LocationClient extends HttpClient {
    
    public LocationClient(WeatherAPIProperties weatherAPIProperties) {
        super(weatherAPIProperties);
    }

    private final String serviceUrl = weatherAPIProperties.getApiUrl() + "/locations/v1/cities/autocomplete";

    public Location[] getLocationsByQuery(String query) throws ApiException {
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(serviceUrl)
            .queryParam("q", query)
            .queryParam("apikey", weatherAPIProperties.getApiKey())
            .encode()
            .toUriString();
        return this.doRequest(
            HttpMethod.GET.name(), 
            urlTemplate, 
            null, 
            null, 
            Location[].class);
    }

}
