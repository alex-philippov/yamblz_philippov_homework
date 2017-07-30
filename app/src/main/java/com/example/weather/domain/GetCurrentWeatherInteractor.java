package com.example.weather.domain;

import com.example.weather.domain.entities.DetailedWeather;

import io.reactivex.functions.Consumer;

public interface GetCurrentWeatherInteractor {
    void execute(Consumer<? super DetailedWeather> onSuccess,
                        Consumer<? super Throwable> onError);
}
