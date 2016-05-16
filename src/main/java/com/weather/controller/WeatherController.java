package com.weather.controller;

import com.weather.domain.Weather;
import com.weather.service.OpenWeatherMapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

/**
 * Created by arthur on 15/05/16.
 */
@RestController
@Slf4j
public class WeatherController {
    private OpenWeatherMapService openWeatherMapService;

    @Autowired
    public WeatherController(OpenWeatherMapService openWeatherMapService) {
        this.openWeatherMapService = openWeatherMapService;
    }

    @RequestMapping(value = "/weather/{city}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Weather getWeatherByCity(@PathVariable String city) {
        log.info("WeatherController - retrieving weather for " + city);
        notNull(city, "City cannot be null");
        isTrue(!city.isEmpty());
        return openWeatherMapService.retrieveCurrentWeather(city.trim());
    }
}
