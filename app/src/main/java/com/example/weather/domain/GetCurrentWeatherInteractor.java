package com.example.weather.domain;

import com.example.weather.WeatherApp;
import com.example.weather.data.WeatherApi;
import com.example.weather.data.WeatherProvider;
import com.example.weather.domain.entities.DetailedWeather;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class GetCurrentWeatherInteractor {

    WeatherProvider weatherProvider;

    public GetCurrentWeatherInteractor(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public void execute(String city, Consumer<? super DetailedWeather> onSuccess,
                        Consumer<? super Throwable> onError) {
        weatherProvider.getWeather(city, WeatherApi.API_KEY)
                .subscribe(onSuccess, onError);
    }
}
