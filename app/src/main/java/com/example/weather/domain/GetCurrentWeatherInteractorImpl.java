package com.example.weather.domain;

import com.example.weather.data.WeatherApi;
import com.example.weather.data.WeatherProvider;
import com.example.weather.domain.entities.DetailedWeather;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class GetCurrentWeatherInteractorImpl implements GetCurrentWeatherInteractor {

    WeatherProvider weatherProvider;

    public GetCurrentWeatherInteractorImpl(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    @Override
    public void execute(Consumer<? super DetailedWeather> onSuccess,
                        Consumer<? super Throwable> onError) {
        weatherProvider.getWeather(WeatherApi.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onSuccess, onError);
    }
}
