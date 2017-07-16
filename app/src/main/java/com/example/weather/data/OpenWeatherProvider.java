package com.example.weather.data;

import com.example.weather.domain.entities.DetailedWeather;

import io.reactivex.Single;

public class OpenWeatherProvider implements WeatherProvider {

    WeatherApi weatherApi;

    public OpenWeatherProvider(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @Override
    public Single<DetailedWeather> getWeather(String city, String key) {
        return weatherApi.getCurrentWeather(city, key);
    }
}
