package com.weather.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by arthur on 16/05/16.
 */
public class DateToTimeConverter {

    public static String getTimeFromDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
        return sdf.format(date);
    }
}
