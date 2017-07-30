package com.example.weather.data;

import com.example.weather.domain.entities.DetailedWeather;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface WeatherProvider {
    Observable<DetailedWeather> getWeather(String key);
}
