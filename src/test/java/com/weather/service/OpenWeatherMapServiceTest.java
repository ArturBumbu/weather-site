package com.weather.service;

import com.weather.data.WeatherData;
import com.weather.domain.Weather;
import com.weather.util.OpenWeatherUrlBuilter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by arthur on 15/05/16.
 */
@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class OpenWeatherMapServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private OpenWeatherMapService underTest;

    @Before
    public void setup() {
        underTest = new OpenWeatherMapService(restTemplate);
    }

    @Test
    public void shouldRetrieveWeatherDetailsFromOpenWeather() {
        String city = "London";
        when(restTemplate.getForObject(new OpenWeatherUrlBuilter().byCity(city).build(), String.class)).thenReturn(WeatherData.mockWeatherStringJSON());
        Weather response = underTest.retrieveCurrentWeather(city);
        assertNotNull(response);
        assertEquals(city, response.getCityName());
    }
}