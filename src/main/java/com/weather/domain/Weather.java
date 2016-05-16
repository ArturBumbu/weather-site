package com.weather.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by arthur on 15/05/16.
 */
@Getter
@Setter
public class Weather {
    private String todayDate;
    private String cityName;
    private String weatherDescription;
    private Double temperatureFar;
    private Double temperatureCel;
    private String sunrise;
    private String sunset;
}
