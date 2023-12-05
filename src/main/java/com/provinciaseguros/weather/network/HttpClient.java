package com.provinciaseguros.weather.network;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.provinciaseguros.weather.config.WeatherAPIProperties;
import com.provinciaseguros.weather.exceptions.ApiException;
import com.provinciaseguros.weather.exceptions.BadRequestException;
import com.provinciaseguros.weather.exceptions.ForbbidenException;
import com.provinciaseguros.weather.exceptions.InternalServerErrorException;
import com.provinciaseguros.weather.exceptions.NotFoundException;
import com.provinciaseguros.weather.exceptions.UnauthorizedException;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
    public class HttpClient {
    private RestTemplate restTemplate;
    private ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
    
    protected WeatherAPIProperties weatherAPIProperties;

    public HttpClient(WeatherAPIProperties weatherAPIProperties) {
        this.restTemplate = new RestTemplate(factory);
        this.weatherAPIProperties = weatherAPIProperties;
    }

    public <R, T> T doRequest(String method, String url, Map<String, String> headers, R body, Class<T> responseType) throws ApiException {
        HttpMethod httpMethod = HttpMethod.valueOf(method.toUpperCase());
        HttpHeaders header = new HttpHeaders();
        if(headers != null) {
            headers.forEach((String name, String value) -> {
                header.add(name, value);
            });
        }
        HttpEntity<R> httpEntity = new HttpEntity<>(body, header);
        try {
            return restTemplate.exchange(url, httpMethod, httpEntity, responseType).getBody();
            
        } catch (HttpStatusCodeException  e) {
            int status = e.getStatusCode().value();
            if(status == 404) {
                throw new NotFoundException("Resource could not be found.");
            } else if(status == 401) {
                throw new UnauthorizedException("Could not access API Info.");
            } else if(status == 403) {
                throw new ForbbidenException("Could not access resource.");
            } else if(status == 400) {
                throw new BadRequestException("Request was malformed.");
            }
            throw new InternalServerErrorException("An unknown error ocurred in API.");
        }
    }    
}
