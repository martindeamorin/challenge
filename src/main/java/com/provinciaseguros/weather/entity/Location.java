package com.provinciaseguros.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "id")
    @JsonProperty("Key")
    private String key;

    @Column(name = "type")
    @JsonProperty("Type")
    private String type;

    @Column(name = "localized_name")
    @JsonProperty("LocalizedName")
    private String localizedName;

    @Column(name = "rank")
    @JsonProperty("Rank")
    private Long rank;
}
