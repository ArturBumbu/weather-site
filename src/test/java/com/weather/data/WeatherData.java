package com.weather.data;

import org.json.JSONObject;

/**
 * Created by arthur on 16/05/16.
 */
public class WeatherData {
    public static JSONObject mockWeatherJSON() {
      return new JSONObject(mockWeatherStringJSON());
    }

        public static String mockWeatherStringJSON() {
        return "{\"coord\":{\"lon\":139,\"lat\":35},\n" +
                "\"sys\":{\"country\":\"JP\",\"sunrise\":1369769524,\"sunset\":1369821049},\n" +
                "\"weather\":[{\"id\":804,\"main\":\"clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\n" +
                "\"main\":{\"temp\":289.5,\"humidity\":89,\"pressure\":1013,\"temp_min\":287.04,\"temp_max\":292.04},\n" +
                "\"wind\":{\"speed\":7.31,\"deg\":187.002},\n" +
                "\"rain\":{\"3h\":0},\n" +
                "\"clouds\":{\"all\":92},\n" +
                "\"dt\":1369824698,\n" +
                "\"id\":1851632,\n" +
                "\"name\":\"London\",\n" +
                "\"cod\":200" +
                "}";
    }
}
