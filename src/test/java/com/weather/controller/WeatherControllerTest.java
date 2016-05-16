package com.weather.controller;

import com.weather.domain.Weather;
import com.weather.service.OpenWeatherMapService;
import com.weather.util.OpenWeatherUrlBuilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static com.weather.data.WeatherData.mockWeatherStringJSON;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by arthur on 15/05/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class WeatherControllerTest {
    @Mock
    RestTemplate restTemplate;

    @Mock
    OpenWeatherMapService openWeatherMapService;

    @InjectMocks
    WeatherController underTest;

    @Before
    public void setup() {
        openWeatherMapService = new OpenWeatherMapService(restTemplate);
        underTest = new WeatherController(openWeatherMapService);
    }

    @Test
    public void shouldRetrieveWeatherByCityId() {
        String city = "London";
        mockCallToOpenWeather(city);
        assertNotNull(underTest);
        Weather response = underTest.getWeatherByCity(city);

        assertNotNull(response);
        assertEquals(city, response.getCityName());
        assertFalse(response.getTodayDate().isEmpty());
        assertEquals("overcast clouds", response.getWeatherDescription());
        assertFalse(response.getSunrise().isEmpty());
        assertFalse(response.getSunset().isEmpty());
        assertEquals(289.5, response.getTemperatureFar(), 0.1);
    }

    private void mockCallToOpenWeather(String city) {
        when(restTemplate.getForObject(new OpenWeatherUrlBuilter().byCity(city).build(), String.class)).thenReturn(mockWeatherStringJSON());
    }

}