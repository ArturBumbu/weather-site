package com.weather.service;

import com.weather.domain.Weather;
import com.weather.util.JsonToWeather;
import com.weather.util.OpenWeatherUrlBuilter;
import com.weather.util.TemperatureConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static org.springframework.util.Assert.notNull;

/**
 * Created by arthur on 15/05/16.
 */
@Service
@Slf4j
public class OpenWeatherMapService {

    private RestTemplate restTemplate;

    @Autowired
    public OpenWeatherMapService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Weather retrieveCurrentWeather(String city) {
        log.info("OpenWeatherMapService - retrieving weather for city: " + city);
        String response = retrievingWeatherFromOpenWeather(city);
        log.info("JSON object retrieved: " + response);
        notNull(response, "failed to call open weather");
        return createWeatherResponse(response);
    }

    private Weather createWeatherResponse(String jsonWeather) {
        Weather response = new JsonToWeather(jsonWeather).getWeather();
        response.setTodayDate(new Date().toString());
        response.setTemperatureCel(TemperatureConverter.farToCel(response.getTemperatureFar()));
        return response;
    }

    private String retrievingWeatherFromOpenWeather(String city) {
        return restTemplate.getForObject(new OpenWeatherUrlBuilter().byCity(city).build(), String.class);
    }
}
