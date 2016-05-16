package com.weather.util;

import com.jayway.restassured.path.json.JsonPath;
import com.weather.domain.Weather;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.springframework.util.Assert.notNull;

/**
 * Created by arthur on 16/05/16.
 */
@Slf4j
public class JsonToWeather {
    private Weather weather;

    public Weather getWeather() {
        return weather;
    }

    public JsonToWeather(String json) {

        log.info("Json object to be converted: " + json);
        notNull(json, "Json object cannot be null");

        this.weather = new Weather();
        copyWeatherDetailsFromString(json);
    }

    public JsonToWeather(JSONObject json) {
        log.info("Json object to be converted: " + json);
        notNull(json, "Json object cannot be null");


        this.weather = new Weather();
        copyWeatherDetailsFromJson(json);
    }

    private void copyWeatherDetailsFromJson(JSONObject json) {
        JsonPath jsonPath = from(json.toString());
        this.weather.setCityName(jsonPath.getString("name"));
        this.weather.setWeatherDescription(jsonPath.getString("weather[0].description"));
        this.weather.setSunrise(getSunRiseTime(jsonPath));
        this.weather.setSunset(getSunSetTime(jsonPath));
        this.weather.setTemperatureFar(jsonPath.getDouble("main.temp"));
    }

    private void copyWeatherDetailsFromString(String json) {
        JsonPath jsonPath = from(json);
        this.weather.setCityName(jsonPath.getString("name"));
        this.weather.setWeatherDescription(jsonPath.getString("weather[0].description"));
        this.weather.setSunrise(getSunRiseTime(jsonPath));
        this.weather.setSunset(getSunSetTime(jsonPath));
        NumberFormat formatter = new DecimalFormat("#0.00");
        Double aDouble = jsonPath.getDouble("main.temp");
        formatter.format(aDouble);
        this.weather.setTemperatureFar(aDouble);
    }

    private String getSunSetTime(JsonPath jsonPath) {
        return DateToTimeConverter.getTimeFromDate(new Date(jsonPath.getLong("sys.sunset")));
    }

    private String getSunRiseTime(JsonPath jsonPath) {
        return DateToTimeConverter.getTimeFromDate(new Date(jsonPath.getLong("sys.sunrise")));
    }
}
