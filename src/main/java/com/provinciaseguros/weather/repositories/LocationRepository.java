package com.provinciaseguros.weather.repositories;

import org.springframework.data.repository.CrudRepository;

import com.provinciaseguros.weather.entity.Location;

public interface LocationRepository extends CrudRepository<Location, String> {
    
}
