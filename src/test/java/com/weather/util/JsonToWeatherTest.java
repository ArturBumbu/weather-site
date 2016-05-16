package com.weather.util;

import com.weather.domain.Weather;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static com.weather.data.WeatherData.mockWeatherJSON;
import static com.weather.data.WeatherData.mockWeatherStringJSON;
import static org.junit.Assert.*;

/**
 * Created by arthur on 16/05/16.
 */
@Slf4j
public class JsonToWeatherTest {
    private JsonToWeather underTest;

    @Test
    public void shouldCreateWeatherObjectFromStringJson() {
        underTest = new JsonToWeather(mockWeatherStringJSON());
        Weather weather = underTest.getWeather();
        checkJsonCreation();
        checkCityName(weather);
        checkWeatherDescription(weather);
        checkSunRise(weather);
        checkSunSet(weather);
    }

    @Test
    public void shouldCreateWeatherObjectFromJson() {
        underTest = new JsonToWeather(mockWeatherJSON());
        Weather weather = underTest.getWeather();
        checkJsonCreation();
        checkCityName(weather);
        checkWeatherDescription(weather);
        checkSunRise(weather);
        checkSunSet(weather);
    }

    private void checkSunSet(Weather weather) {
        assertFalse(weather.getSunset().isEmpty());
    }

    private void checkWeatherDescription(Weather weather) {
        assertEquals("overcast clouds", weather.getWeatherDescription());
    }

    private void checkJsonCreation() {
        assertNotNull("Failed to create weather object from JSON");
    }

    private void checkSunRise(Weather weather) {
        assertFalse(weather.getSunrise().isEmpty());
    }

    private void checkCityName(Weather weather) {
        assertEquals("London", weather.getCityName());
    }
}