package com.provinciaseguros.weather.services;

import com.provinciaseguros.weather.entity.Location;
import com.provinciaseguros.weather.exceptions.ApiException;

public interface LocationService {
    Location[] getLocationByQuery(String query) throws ApiException;
}
