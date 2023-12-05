package com.provinciaseguros.weather.services.impl;

import java.util.Arrays;

import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.provinciaseguros.weather.entity.Location;
import com.provinciaseguros.weather.exceptions.ApiException;
import com.provinciaseguros.weather.network.LocationClient;
import com.provinciaseguros.weather.repositories.LocationRepository;
import com.provinciaseguros.weather.services.LocationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService{

    @Autowired
    LocationClient locationClient;

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location[] getLocationByQuery(String query) throws ApiException {
        Location[] locations = locationClient.getLocationsByQuery(query);
        if(locations == null) locations = new Location[0];
        try{
            locationRepository.saveAll(Arrays.asList(locations));
        } catch( IllegalArgumentException | OptimisticEntityLockException ex) {
            log.info("Could not save locations to db.");
        }

        return locations;
    }
    
}
