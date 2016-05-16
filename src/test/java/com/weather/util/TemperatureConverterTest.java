package com.weather.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arthur on 16/05/16.
 */
public class TemperatureConverterTest {

    private TemperatureConverter underTest;

    @Before
    public void setup() {
        underTest = new TemperatureConverter();
    }

    @Test
    public void shouldConvertFarToCel() {
        Double farTemp = 200.0;
        assertEquals(93.33333333333333, underTest.farToCel(farTemp),0.1);
    }
}