package com.example.weather.utils;

public class TemperatureConverter {
    public static int kelvinToCelsius(double t) {
        return (int) (Math.round(t) - 273);
    }
}
