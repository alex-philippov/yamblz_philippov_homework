package com.example.weather.data;

import com.example.weather.domain.entities.DetailedWeather;

import io.reactivex.Single;

public interface WeatherProvider {
    Single<DetailedWeather> getWeather(String city, String key);
}
