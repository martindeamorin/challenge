package com.provinciaseguros.weather.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Temperature {
    @JsonProperty("Metric")
    UnitData metric;
    @JsonProperty("Imperial")
    UnitData imperial;
}
