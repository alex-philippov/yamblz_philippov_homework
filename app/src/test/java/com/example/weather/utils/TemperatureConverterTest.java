package com.example.weather.utils;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TemperatureConverterTest {

    @Test
    public void convertFromKelvinToCelsius() {
        assertEquals(TemperatureConverter.kelvinToCelsius(288.4), 15);
    }
}
