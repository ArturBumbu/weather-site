package com.weather.util;

import java.text.DecimalFormat;
import java.util.Formatter;

/**
 * Created by arthur on 16/05/16.
 */
public class TemperatureConverter {
    public static double farToCel(Double farTemp) {
        DecimalFormat df = new DecimalFormat("#.##");
        double celcius = (farTemp - 32) * 5 / 9.0;
        return Double.valueOf(df.format(celcius));
    }
}
