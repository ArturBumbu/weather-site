package com.weather.util;

/**
 * Created by arthur on 15/05/16.
 */
public class OpenWeatherUrlBuilter {

    private final String hostName = "http://api.openweathermap.org/";
    private final String path = "data/2.5/weather?q=";
    private String city;
    private final String format = "&mode=json";
    private final String units = "&units=imperial";
    private final String app_id = "&APPID=4cd2d82a8e15ab3d2a469035bf86ed25";


    public OpenWeatherUrlBuilter byCity(String city) {
        this.city = city;
        return this;
    }

    public String build() {
        return new StringBuilder().append(hostName).append(path).append(city).append(format).append(units).append(app_id).toString();
    }
}
