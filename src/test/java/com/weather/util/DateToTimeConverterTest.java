package com.weather.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by arthur on 16/05/16.
 */
@Slf4j
public class DateToTimeConverterTest {
    DateToTimeConverter underTest;

    @Before
    public void setup() {

    }

    @Test
    public void shouldConvertDateToStringTime() {
        Date date = new Date();
        String convertedTime = DateToTimeConverter.getTimeFromDate(date);
        log.info("converted time: " + convertedTime);
        assertFalse(convertedTime.isEmpty());
    }
}